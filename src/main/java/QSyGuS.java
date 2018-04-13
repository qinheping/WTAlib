
import automata.wta.WTA;
import automata.wta.WTAMove;
import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import semirings.Semiring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QSyGuS {
    static private Float h,l;
    static private boolean sup,inf;
    static private List<String> weightName;
    static private int constaintedIndex = 0;
    static private int optimizingIndex = -1;
    static private boolean isPairedOpt;
    static private boolean detail = true;
    static private List<Semiring<Float>> semirings = new ArrayList<>();

    static private List<Float> currentWeight = new ArrayList<>();

    static private int timeout = 200;
    static private List<WTA> weightedGrammars = new ArrayList<WTA>();

    static private boolean optFound;

    public static  void main(String[] args)throws InterruptedException, IOException{
        String solverName = args[0];
        if(!(solverName.equals("ESolver")||solverName.equals("CVC4"))){

            System.out.println("No solver found");
            return;
        }
        System.out.println("Solver: " + solverName);
        for(int i = 1; i < args.length; i++){
            solve(args[i],solverName);
        }

    }

    private static void solve(String benchmarkPath, String solverName)throws InterruptedException, IOException{
        // initialization
        List<GrammarReduction<String, Float>> gr = new ArrayList<GrammarReduction<String, Float>>();
        currentWeight.add(0.f);
        currentWeight.add(0.f);
        boolean isPairedWeight = false;

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


        // first weight
        weightName = prog.weightNames;
        gr.add(new GrammarReduction<String, Float>((Semiring<Float>) prog.semirings.get(0)));
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


        System.out.println("Start to find initial solution");
        // no weight constain
        if(prog.weightConstraint == null){
            System.out.println("no weight constraint");
            initial_script = prog.toString(prog.getSynthFun().toFTA());
        }else{
            //System.out.println("weight constraint: " + prog.weightConstraint);
            TermNode constraint = prog.getWeightConstraint();
            // parse weight constraint
            // 1. interval [l,h]
            // 2. base case (-inf,h] [h,h] [l,inf)
            // 3. combinzation of base case
            // special case
            isInterval = isInterval(constraint);
            if(isInterval){
                initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(constaintedIndex),l, inf, h,sup));
            }else {
                reset();
                atomCheck = checkIneq(constraint);
                if (atomCheck != 3) {
                    if (atomCheck == 0) {
                        initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(constaintedIndex), l, inf, h, sup));
                    }
                    if (atomCheck < 0) {
                        initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(constaintedIndex), gr.get(constaintedIndex).sr.one(), true, h, sup));
                    }
                    if (atomCheck > 0) {
                        // TODO greater than? complement
                        initial_script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(constaintedIndex), l, inf, h, sup));
                    }
                }
            }
        }

        if(detail) System.out.println("initial script: \n"+initial_script);

        if(prog.weightOpt.getFlag() == null){
            optimizingIndex = 0;
            isPairedOpt = false;}else
                isPairedOpt = true;
        // solve the initial script with the specified solver
        Float result = callSolver(initial_script, solverName, weightedGrammars.get(constaintedIndex),semirings.get(constaintedIndex));

        if(!result.equals(-1f)){ System.out.println("The weight "+weightName.get(constaintedIndex) + " is "+result);
            if(prog.weightOpt.getFlag() != null)System.out.println("The weight "+weightName.get(1-constaintedIndex) + " is "+currentWeight.get(1-constaintedIndex));
        }
        else {
            System.out.println("no solutions found in the constraint.\nTest done.");
            return;
        }

        if(prog.weightOpt == null){
            System.out.println("No optmization objective.\nTest done.");
            return;
        }


        // no paired
        if(isPairedOpt && prog.weightOpt.getFlag().equals("SORT")){
            optimizingIndex = (prog.weightOpt.getWeightTuple().get(0).equals(weightName.get(0)))?0:1;
            isPairedOpt = true;
        }

        // number of weight optimized
        int numOfOptimized = 0;
        if(l == null){
            l = semirings.get(optimizingIndex).one();
        }
        if((constaintedIndex == optimizingIndex && l.equals(result))){
            optFound = true;
            if(!isPairedOpt) {
                System.out.println("This solution is the optimized within constraint range.\nTest done.");
                return;
            }
            System.out.println("This solution is optimized regard to " +weightName.get(optimizingIndex) + ". Move to next weight");
            // move optimizing index to next one
            optimizingIndex = 1-optimizingIndex;
            numOfOptimized = 1;
        }

        // start to optimization
        System.out.println("Start to refine solutions");
        String script;

        while(optimizingIndex!=3){

            System.out.println("----------\nnew iteration starts");
            script = null;
            // if the constaint is an interval
            if(isInterval){
                // constainted == optimized
                if(constaintedIndex == optimizingIndex ){
                    if( semirings.get(optimizingIndex).lessThan(result,h))
                        script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(optimizingIndex),l, inf, currentWeight.get(optimizingIndex), false));
                    else {
                        System.out.println("no solution in the contraint range");
                        break;
                    }
                }else{
                    script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(optimizingIndex),l, inf, h,sup).intersectionWith(gr.get(optimizingIndex).mkFTALessThanC(prog.toWTA(), currentWeight.get(optimizingIndex))));
                }
            }
            if(atomCheck!=3){
                if(atomCheck == 0){
                    System.out.println("already optimized");
                    break;
                }
                if(atomCheck < 0){
                    if(constaintedIndex == optimizingIndex )
                    script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(optimizingIndex), gr.get(constaintedIndex).sr.one(), true, currentWeight.get(optimizingIndex), false));
                    else {
                        script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(optimizingIndex), gr.get(constaintedIndex).sr.one(), true,  h, sup).intersectionWith(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(), gr.get(optimizingIndex).sr.one(), true, currentWeight.get(optimizingIndex), false)));
                    }
                }
                if(atomCheck > 0  ){
                    // TODO greater than? complement
                    script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(optimizingIndex),l, inf, h,sup));
                }
            }

            if(prog.weightConstraint == null){
                script = prog.toString(gr.get(constaintedIndex).mkFTAInRange(prog.toWTA(optimizingIndex), gr.get(constaintedIndex).sr.one(), true, currentWeight.get(optimizingIndex), false));
            }

            if(detail)System.out.println(script);
            result = callSolver(script, solverName, weightedGrammars.get(optimizingIndex),semirings.get(optimizingIndex));

            if(!result.equals(-1f)) {
                System.out.println("The weight " + weightName.get(constaintedIndex) + " is " + result);
                if(isPairedOpt)
                    if(isPairedOpt)System.out.println("The weight "+weightName.get(1-constaintedIndex) + " is "+currentWeight.get(1-constaintedIndex));
            }
            else {
                System.out.println("no solutions found.");
                if(isPairedOpt == false||numOfOptimized == 1){
                    System.out.println("already optimized");
                    break;
                }
                System.out.println("move to next weight.");
                numOfOptimized++;
                optimizingIndex = (optimizingIndex == 0)?1:0;
            }
        }
    }

    public static Float callSolver(String script, String solverName, WTA wta, Semiring semiring)throws InterruptedException{
        optFound = false;
        boolean solutionFound = true;

        // write script to tmp file
        File dir = new File("../../../tmp/");
        File tmp = new File(dir, "SolverInput.txt");
        Runtime rt = Runtime.getRuntime();
        String result = "";
        try {

            tmp.createNewFile();
            WriteStringToFile(tmp, script);
            File libdir = new File("../../../solver/ESolver/bin");
            final long startTime = System.currentTimeMillis();

            // exec solver
            System.out.println("Solver running. Timeout is set to " + timeout +" seconds");
            Process proc = rt.exec("bash  starexec_run_Default ../../../tmp/SolverInput.txt",null, libdir);

            // timeout
            if(!proc.waitFor(timeout, TimeUnit.SECONDS)) {
                //timeout - kill the process.
                proc.destroy(); // consider using destroyForcibly instead
                solutionFound = false;
                optFound = true;
                System.out.println("TIMEOUT");
                return -1f;
            }
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());
            final long endTime = System.currentTimeMillis();

            // solved in time
            System.out.println("Solved in "+ (endTime-startTime) + " ms");
            LineNumberReader input = new LineNumberReader(ir);
            String line = input.readLine();
            if(proc.exitValue() != 0){
                System.out.println("Failed to solve the script.");
                solutionFound = false;
                optFound = false;
                return -1f;
            }

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
        currentWeight.set(0,evluateString(weightedGrammars.get(0),result,semirings.get(0)));
        if(isPairedOpt){
            currentWeight.set(1,evluateString(weightedGrammars.get(1),result,semirings.get(1)));}
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
            if(weightName.contains(t.getChildren().get(0).getSymbol())){
                h = Float.parseFloat(t.getChildren().get(1).getSymbol());
                l = h;
                constaintedIndex = (t.getChildren().get(0).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                inf = true;
            }else {
                h = Float.parseFloat(t.getChildren().get(0).getSymbol());
                l = h;
                constaintedIndex = (t.getChildren().get(1).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                inf = true;
            }
            return 0;
        }
        if(t.getSymbol().equals("<")) {
            if(weightName.contains(t.getChildren().get(0).getSymbol())){
                h = Float.parseFloat(t.getChildren().get(1).getSymbol());
                constaintedIndex = (t.getChildren().get(0).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                sup = false;
                return -1;
            }else{
                constaintedIndex = (t.getChildren().get(1).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                l = Float.parseFloat(t.getChildren().get(0).getSymbol());
                inf = false;
                return 1;
            }
        }
        if(t.getSymbol().equals("<=")) {
            if(weightName.contains(t.getChildren().get(0).getSymbol())){
                h = Float.parseFloat(t.getChildren().get(1).getSymbol());
                constaintedIndex = (t.getChildren().get(0).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                return -2;
            }else{
                constaintedIndex = (t.getChildren().get(1).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                inf = true;
                l = Float.parseFloat(t.getChildren().get(0).getSymbol());
                return 2;
            }
        }
        if(t.getSymbol().equals(">")) {
            if(weightName.contains(t.getChildren().get(0).getSymbol())){
                l = Float.parseFloat(t.getChildren().get(1).getSymbol());
                constaintedIndex = (t.getChildren().get(0).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                sup = false;
                return 1;
            }else{
                constaintedIndex = (t.getChildren().get(1).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                inf = false;
                h = Float.parseFloat(t.getChildren().get(0).getSymbol());
                return -1;
            }
        }
        if(t.getSymbol().equals(">=")) {
            if(weightName.contains(t.getChildren().get(0).getSymbol())){
                l = Float.parseFloat(t.getChildren().get(1).getSymbol());
                constaintedIndex = (t.getChildren().get(0).getSymbol().equals(weightName.get(0))) ? 0 : 1;
                sup = true;
                return 2;
            }else{
                h = Float.parseFloat(t.getChildren().get(0).getSymbol());
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
