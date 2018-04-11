import automata.Move;
import automata.wta.WTA;
import automata.wta.WTAMove;
import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import semirings.ProbabilitySemiring;
import semirings.Semiring;
import semirings.TropicalSemiring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QSyGuS {
    static String h,l;
    static boolean sup,inf;
    static List<String> weightName;
    static List<WTA> weightedGrammars;
    static boolean isPairedWeight;
    static List<Semiring<Float>> semirings;
    public static  void main(String[] args)throws FileNotFoundException, IOException{
        String solverName = args[0];
        List<String> benchmarkPaths = new ArrayList<String>();
        for(int i = 1; i < args.length; i++){
            solve(args[i],solverName);
        }

    }

    private static void solve(String benchmarkPath, String solverName)throws FileNotFoundException, IOException{
        weightedGrammars = new ArrayList<WTA>();
        String input = new Scanner(new File(benchmarkPath)).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        weightName = prog.weightNames;
        GrammarReduction<String, Float> gr1 =null, gr2 = null;
        isPairedWeight = false;
        if(prog.semirings.get(0).equals("TROP"))
            gr1 = new GrammarReduction<String, Float>(new TropicalSemiring());
        if(prog.semirings.get(0).equals("PROB"))
            gr1 = new GrammarReduction<String, Float>(new ProbabilitySemiring());
        semirings.add(gr1.sr);
        weightedGrammars.add(prog.toWTA());

        if(prog.semirings.size()>1){
            isPairedWeight = true;
            if(prog.semirings.get(1).equals("TROP"))
                gr2 = new GrammarReduction<String, Float>(new TropicalSemiring());
            if(prog.semirings.get(0).equals("PROB"))
                gr2 = new GrammarReduction<String, Float>(new ProbabilitySemiring());
            weightedGrammars.add(prog.toWTA(1));
            semirings.add(gr2.sr);
        }


        String initial_script = null;

        // no weight constain
        if(prog.weightConstraint == null){
            initial_script = prog.toString(prog.getSynthFun().toFTA());
        }else{
            TermNode constraint = prog.getWeightConstraint();
            //special case
            if(isInterval(constraint)){
                // TODO gr1 or gr2 ?
                initial_script = prog.toString(gr1.mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
            }
            reset();
            int checkFlag = checkIneq(constraint);
            if(checkFlag!=3){
            if(checkFlag == 0){
                initial_script = prog.toString(gr1.mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
            }
            if(checkFlag < 0){
                initial_script = prog.toString(gr1.mkFTAInRange(prog.toWTA(), gr1.sr.one(), true, Float.parseFloat(h),sup));
            }
            if(checkIneq(constraint) > 0  ){
                // TODO greater than? complement
                initial_script = prog.toString(gr1.mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
            }}
        }
        Float result = callSolver(initial_script, solverName, weightedGrammars.get(0),semirings.get(0));
    }

    public static Float callSolver(String script, String solverName, WTA wta, Semiring semiring)throws IOException{
        File dir = new File("tmp");
        dir.mkdirs();
        File tmp = new File(dir, "SolverInput.txt");
        Runtime rt = Runtime.getRuntime();
        String result = "";
        try {
            tmp.createNewFile();
            WriteStringToFile(tmp, script);
            File libdir = new File("./solver/ESolver/bin");
            Process proc = rt.exec("bash  starexec_run_Default ../../../tmp/SolverInput.txt",null, libdir);
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line = input.readLine();
            while(!(line=input.readLine()).equals("-----------------------------------------------"))
                result+=line;
            System.out.println(result);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  evluateString(wta,result, semiring);
    }

    static Float evluateString(WTA wta, String fun, Semiring semiring){
        ANTLRInputStream inputStream = new ANTLRInputStream(fun);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.funDefCmd();
        TermNode term = (TermNode)new ASTVisitor().visit(parseTree);
        List<Float> weights = evluateTerm(wta, wta.getInitialState(), term, semiring);
        Float result = (Float)semiring.zero();
        for(Float weight: weights){
            result = (Float)semiring.plus(result,weight);
        }

        return result;
    }

    static List<Float> evluateTerm(WTA wta, Integer root, TermNode term, Semiring<Float> semiring){
        List<Float> result = new ArrayList<Float>();

        // leaf
        if(!term.hasChild()){
            for(Object move: wta.getMovesFrom(root)){
                if(((WTAMove) move).to.get(0).equals(1) && ((WTAMove) move).symbol.equals(term.getSymbol())){
                    result.add((Float) ((WTAMove) move).weight);
                    return result;
                }
            }
            return result;
        }
        for(Object move: wta.getMovesFrom(root)){
            List<Float> moveResult = new ArrayList<Float>();
            WTAMove wtaMove = (WTAMove) move;
            if(!wtaMove.symbol.equals(term.getSymbol()))
                continue;
            if(wtaMove.to.size()!=term.getChildren().size())
                continue;
            for(int i = 0; i < wtaMove.to.size(); i++){
                List<Float> childResult = evluateTerm(wta,(Integer)wtaMove.to.get(i),term.getChildren().get(i),semiring);
                if(childResult.size()==0)
                    return new ArrayList<Float>();
                if(i == 0){
                    moveResult = childResult;
                    continue;
                }
                List<Float> tmp = new ArrayList<Float>();
                for(Float f1 : moveResult){
                    for(Float f2 : childResult)
                        tmp.add(semiring.times(f1,f2));
                }
                moveResult = tmp;
            }
            for(int i = 0; i < moveResult.size(); i++){
                moveResult.set(i,semiring.times(moveResult.get(i),(Float) wtaMove.weight));
            }
            result.addAll(moveResult);
        }
        return result;
    }

    static void WriteStringToFile(File f, String s) throws IOException {
        FileWriter fileWriter = new FileWriter(f);
        fileWriter.write(s);
        fileWriter.close();
    }

    private static boolean isInterval(TermNode term){
        if(!term.getSymbol().equals("and"))
            return false;
        if(term.getChildren().size()!=2)
            return false;
        TermNode s0 = term.getChildren().get(0);
        TermNode s1 = term.getChildren().get(1);
        if(checkIneq(s0)*checkIneq(s1) < 0){
            return true;
        }else{
            reset();
            return false;
        }
    }

    private static int checkIneq(TermNode t){
        /*  1 : x >
            2 : x >=
            0 : x =
           -1 : x <
           -2 : x <=
            h : upper bound
            l : lower bound

        */
        if(t.getSymbol().equals("==")) {
            if(weightName.contains(t.getChildren().get(0))){
                h = t.getChildren().get(1).getSymbol();
                l = h;
                sup = true;
                inf = true;
            }else {
                h = t.getChildren().get(0).getSymbol();
                l = h;
                sup = true;
                inf = true;
            }
            return 0;
        }
        if(t.getSymbol().equals("<")) {
            if(weightName.contains(t.getChildren().get(0))){
                h = t.getChildren().get(1).getSymbol();
                sup = false;
                return -1;
            }else{
                l = t.getChildren().get(0).getSymbol();
                inf = false;
                return 1;
            }
        }
        if(t.getSymbol().equals("<=")) {
            if(weightName.contains(t.getChildren().get(0))){
                h = t.getChildren().get(1).getSymbol();
                sup = true;
                return -2;
            }else{
                inf = true;
                l = t.getChildren().get(0).getSymbol();
                return 2;
            }
        }
        if(t.getSymbol().equals(">")) {
            if(weightName.contains(t.getChildren().get(0))){
                l = t.getChildren().get(1).getSymbol();
                sup = false;
                return 1;
            }else{
                inf = false;
                h = t.getChildren().get(0).getSymbol();
                return -1;
            }
        }
        if(t.getSymbol().equals(">=")) {
            if(weightName.contains(t.getChildren().get(0))){
                l = t.getChildren().get(1).getSymbol();
                sup = true;
                return 2;
            }else{
                h = t.getChildren().get(0).getSymbol();
                inf = true;
                return -2;
            }
        }
        return 3;

    }

    private static void reset(){
        h = null;
        l = null;
        sup = false;
        inf = false;
    }
}
