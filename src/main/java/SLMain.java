import edu.nyu.acsys.CVC4.ExprManager;
import edu.nyu.acsys.CVC4.SmtEngine;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import semirings.LinearSet;
import utilities.*;

import java.io.*;
import java.util.*;

public class SLMain {
    public static void main(String args[]) throws IOException {
        String path = args[0];

        int numEx = Integer.parseInt(args[1]);


        String grammarString;
        if(args.length>3 && args[3].equals("b"))
            grammarString = new Scanner(new File(path)).useDelimiter("\\Z").next();
        else
            grammarString = new Scanner(new File(path+"/grammar.sl")).useDelimiter("\\Z").next();


        if(args.length>3 && args[3].equals("noOpt")) {
            Newton.opt = false;
            IteFixedPointSolver.opt = false;
        }

        if(args.length>3 && args[3].equals("z3")) {
            SMTQGenerator.SMTSolver = 1;
        }else {
            System.loadLibrary("cvc4jni");
            SMTQGenerator.em = new ExprManager();
            SMTQGenerator.smt = new SmtEngine(SMTQGenerator.em);
            SMTQGenerator.integer = SMTQGenerator.em.integerType();
        }



        ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.synthFunCmd();
        GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);
        GrammarInterpretor ginterpreter = new GrammarInterpretor(grammarNode);
        List<Equation> termEqs = ginterpreter.GrammarToEquations(grammarNode);
        Scanner scanner;
        if(args.length>3 && args[3].equals("b"))
            scanner = new Scanner(new File("/benchmarks/benchmarking/example"+args[2]+".txt"));
        else
            scanner = new Scanner(new File(path+"/example"+args[2]+".txt"));
        String[] var_array = scanner.nextLine().split(" ");
        Vector<Integer> spec = new Vector<>();
        Map<String,Vector<Integer>> inputExMap = new HashMap<>();

        for(int i = 0; i < numEx; i++){
            String[] line = scanner.nextLine().replace("\t"," ").split(" ");
            for(int j = 0; j < line.length-1; j++){
                if(!inputExMap.keySet().contains(var_array[j]))
                    inputExMap.put(var_array[j],new Vector<Integer>());
                inputExMap.get(var_array[j]).add(Integer.parseInt(line[j]));
            }
            spec.add(Integer.parseInt(line[line.length-1]));
        }


        PrintStream original = System.out;

        int totalTrans = 0;
        for (NTNode nt:grammarNode.getNtNodes()){
            totalTrans+=nt.getRules().size();
        }
        System.out.print(grammarNode.getNtNodes().size()+" & "+totalTrans+ " & "+inputExMap.keySet().size()+" & "+numEx+" & ");
        System.setOut(new PrintStream(new OutputStream() {            public void write(int b) {                          }        }));
        float startTime_sl = System.nanoTime();
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputExMap);
        float endTime_sl = System.nanoTime();
        float timeElapsed_sl = endTime_sl - startTime_sl;

        System.out.println(solution);
        int solutionSize = solution.get("Start").size();

        float avgPeriod = 0;
        int periodCount = 0;
        for(LinearSet ls:solution.get("Start")){
            if(avgPeriod == 0)
                avgPeriod = ls.getPeriod().size();
            avgPeriod = avgPeriod*periodCount+ls.getPeriod().size();
            periodCount++;
            avgPeriod = avgPeriod/periodCount;
        }


        System.setOut(original);
        System.out.print(IteFixedPointSolver.totalStage+" & "+ IteFixedPointSolver.bvSize+
                        " & "+solutionSize+ " & "+avgPeriod + " & "+String.format ("%.2f",(timeElapsed_sl/1000000000))+ " & ");

        //BufferedWriter writer = new BufferedWriter(new FileWriter(path+"out.txt"));
        //writer.write(solution.get("Start").toString());
        //writer.close();
        //File file = new File(path+"out.txt");
        //file.delete();
        if(args.length > 3 && args[3].equals("b"))
            return;
        float startTime_smt = System.nanoTime();
        Boolean result = SMTQGenerator.checkSat(spec,solution.get("Start"));
        float endTime_smt = System.nanoTime();
        float timeElapsed_smt = endTime_smt - startTime_smt;
        System.out.print(String.format ("%.2f",(timeElapsed_smt/1000000000))
        + " & "+String.format ("%.2f",((timeElapsed_sl+timeElapsed_smt)/1000000000))+" & "+result+"\\\\");
    }
}
