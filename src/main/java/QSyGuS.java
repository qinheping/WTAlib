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
import java.util.concurrent.TimeUnit;

public class QSyGuS {
    static String h,l;
    static boolean sup,inf;
    static List<String> weightName;
    static List<WTA> weightedGrammars;
    static boolean isPairedWeight;
    static List<Semiring<Float>> semirings;
    static int constaintedIndex;
    static int optimizingIndex;
    static boolean isPairedOpt;
    static boolean detail = true;

    static int timeout = 20;

    static boolean optFound;
    public static  void main(String[] args)throws FileNotFoundException,InterruptedException, IOException{
        String solverName = args[0];
        if(!(solverName.equals("ESolver")||solverName.equals("CVC4"))){

            System.out.println("No solver found");
            return;
        }
        System.out.println("Solver: " + solverName);
        List<String> benchmarkPaths = new ArrayList<String>();
        for(int i = 1; i < args.length; i++){
            solve(args[i],solverName);
        }

    }

    private static void solve(String benchmarkPath, String solverName)throws FileNotFoundException,InterruptedException, IOException{
        // initialization
        weightedGrammars = new ArrayList<WTA>();
        List<GrammarReduction<String, Float>> gr = new ArrayList<GrammarReduction<String, Float>>();
        isPairedWeight = false;

        System.out.println("testing benchmark: " + benchmarkPath.substring(9));

        // read and parse benchmark
        String input = new Scanner(new File(benchmarkPath)).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        // parse end

        semirings = new ArrayList<>();

        // first weight
        weightName = prog.weightNames;
        gr.add(new GrammarReduction<String, Float>(prog.semirings.get(0)));
        System.out.println("Semiring for weight " + weightName.get(0) + " is " + prog.semirings.get(0));
        semirings.add(gr.get(0).sr);
        weightedGrammars.add(prog.toWTA());

        // second weight
        if(prog.semirings.size()>1){
            isPairedWeight = true;
            gr.add(new GrammarReduction<String, Float>(prog.semirings.get(1)));
            System.out.println("Semiring for weight " + weightName.get(1) + " is " + prog.semirings.get(1));
            weightedGrammars.add(prog.toWTA(1));
            semirings.add(gr.get(1).sr);
        }


        String initial_script = null;

        boolean isInterval = false;
        int atomCheck =3;


        System.out.println("Start finding initial solution");
        // no weight constain
        if(prog.weightConstraint == null){
            System.out.println("no weight constraint");
            initial_script = prog.toString(prog.getSynthFun().toFTA());
        }else{
            //System.out.println("weight constraint: " + prog.weightConstraint);
            TermNode constraint = prog.getWeightConstraint();
            //special case
            isInterval = isInterval(constraint);
            if(isInterval){
                initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
            }
            reset();
            atomCheck = checkIneq(constraint);
            if(atomCheck!=3){
            if(atomCheck == 0){
                initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
            }
            if(atomCheck < 0){
                initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(), gr.get(constaintedIndex).sr.one(), true, Float.parseFloat(h),sup));
            }
            if(atomCheck> 0  ){
                // TODO greater than? complement
                initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
            }}
        }

        if(detail) System.out.println("initial script: \n"+initial_script);

        Float result = callSolver(initial_script, solverName, weightedGrammars.get(constaintedIndex),semirings.get(constaintedIndex));

        // no paired
        if(prog.weightOpt.getFlag() == null){
            optimizingIndex = 0;
            isPairedOpt = false;}
        else if(prog.weightOpt.getFlag().equals("PARETO")){
            optimizingIndex = (prog.weightOpt.getWeightTuple().get(0).equals(weightName.get(0)))?0:1;
            isPairedOpt = true;
        }

        String script;
        int numOfOptimized = 0;
        while(optimizingIndex!=3){
            script = null;
            // if the constaint is an interval
            if(isInterval){
                // constainted == optimized
                if(constaintedIndex == optimizingIndex ){
                    if( semirings.get(optimizingIndex).lessThan(result,Float.parseFloat(h)))
                        script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, result, false));
                    else {
                        System.out.println("no solution in the contraint range");
                        break;
                    }
                }else{
                    script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup).intersectionWith(gr.get(optimizingIndex).mkFTALessThanC(prog.toWTA(), result)));
                }
            }
            if(atomCheck!=3){
                if(atomCheck == 0){
                    System.out.println("already optimized");
                    break;
                }
                if(atomCheck < 0){
                    if(constaintedIndex == optimizingIndex )
                    script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(), gr.get(constaintedIndex).sr.one(), true, result, false));
                    else {

                        script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(), gr.get(constaintedIndex).sr.one(), true,  Float.parseFloat(h), sup).intersectionWith(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(), gr.get(optimizingIndex).sr.one(), true, result, false)));
                    }
                }
                if(atomCheck > 0  ){
                    // TODO greater than? complement
                    script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(),Float.parseFloat(l), inf, Float.parseFloat(h),sup));
                    }
                }
            result = callSolver(script, solverName, weightedGrammars.get(optimizingIndex),semirings.get(optimizingIndex));
            if(result == -1){
                if(isPairedOpt == false||numOfOptimized == 1){
                    System.out.println("already optimized");
                    break;
                }
                numOfOptimized++;
                optimizingIndex = (optimizingIndex == 0)?1:0;
            }
        }
    }

    public static Float callSolver(String script, String solverName, WTA wta, Semiring semiring)throws IOException,InterruptedException{
        optFound = false;
        boolean solutionFound = true;
        File dir = new File("tmp");
        File tmp = new File(dir, "SolverInput.txt");
        Runtime rt = Runtime.getRuntime();
        String result = "";
        try {
            tmp.createNewFile();
            WriteStringToFile(tmp, script);
            File libdir = new File("./solver/ESolver/bin");
            final long startTime = System.currentTimeMillis();
            Process proc = rt.exec("bash  starexec_run_Default ../../../tmp/SolverInput.txt",null, libdir);
            if(!proc.waitFor(timeout, TimeUnit.SECONDS)) {
                //timeout - kill the process.
                proc.destroy(); // consider using destroyForcibly instead
                solutionFound = false;
                optFound = true;
                System.out.println("TIMEOUT, the last one is optimized");
                return -1f;
            }
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());

            final long endTime = System.currentTimeMillis();
            System.out.println("Solved in "+ (endTime-startTime) + " ms");
            LineNumberReader input = new LineNumberReader(ir);
            String line = input.readLine();
            if(line.equals("No Solutions!")){
                solutionFound = false;
                optFound = true;
                System.out.println("No solution found, the last one is optimized");
                return -1f;
            }
            while(!(line=input.readLine()).equals("-----------------------------------------------"))
                result+=line;
            System.out.println("Solution:\n" + result);
        }catch (IOException e) {
            e.printStackTrace();
        }
        Float resultWeight = evluateString(wta,result, semiring);
        if((constaintedIndex == optimizingIndex && l!=null && l.equals(resultWeight))){
            optFound = true;
            System.out.println("This solution is the optimized within constraint range.");
            return -1f;
        }
        return  resultWeight;
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
        if(checkIneq(s0)*checkIneq(s1) < 0 ){
            checkIneq(s0);
            int weightIndex0 =constaintedIndex;
            checkIneq(s1);
            int weightIndex1 =constaintedIndex;

            return weightIndex0 == weightIndex1;
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
                constaintedIndex = (t.getChildren().get(0).equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                inf = true;
            }else {
                h = t.getChildren().get(0).getSymbol();
                l = h;
                constaintedIndex = (t.getChildren().get(1).equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                inf = true;
            }
            return 0;
        }
        if(t.getSymbol().equals("<")) {
            if(weightName.contains(t.getChildren().get(0))){
                h = t.getChildren().get(1).getSymbol();
                constaintedIndex = (t.getChildren().get(0).equals(weightName.get(0))) ? 0 : 1;
                sup = false;
                return -1;
            }else{
                constaintedIndex = (t.getChildren().get(1).equals(weightName.get(0))) ? 0 : 1;
                l = t.getChildren().get(0).getSymbol();
                inf = false;
                return 1;
            }
        }
        if(t.getSymbol().equals("<=")) {
            if(weightName.contains(t.getChildren().get(0))){
                h = t.getChildren().get(1).getSymbol();
                constaintedIndex = (t.getChildren().get(0).equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                return -2;
            }else{
                constaintedIndex = (t.getChildren().get(1).equals(weightName.get(0))) ? 0 : 1;
                inf = true;
                l = t.getChildren().get(0).getSymbol();
                return 2;
            }
        }
        if(t.getSymbol().equals(">")) {
            if(weightName.contains(t.getChildren().get(0))){
                l = t.getChildren().get(1).getSymbol();
                constaintedIndex = (t.getChildren().get(0).equals(weightName.get(0))) ? 0 : 1;
                sup = false;
                return 1;
            }else{
                constaintedIndex = (t.getChildren().get(1).equals(weightName.get(0))) ? 0 : 1;
                inf = false;
                h = t.getChildren().get(0).getSymbol();
                return -1;
            }
        }
        if(t.getSymbol().equals(">=")) {
            if(weightName.contains(t.getChildren().get(0))){
                l = t.getChildren().get(1).getSymbol();
                constaintedIndex = (t.getChildren().get(0).equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                return 2;
            }else{
                h = t.getChildren().get(0).getSymbol();
                constaintedIndex = (t.getChildren().get(1).equals(weightName.get(0))) ? 0 : 1;
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
