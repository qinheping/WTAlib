import edu.nyu.acsys.CVC4.ExprManager;
import edu.nyu.acsys.CVC4.SmtEngine;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ASTVisitor;
import parser.GrammarNode;
import parser.QSygusParserLexer;
import parser.QSygusParserParser;
import semirings.LinearSet;
import utilities.Equation;
import utilities.GrammarInterpretor;
import utilities.IteFixedPointSolver;
import utilities.SMTQGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class SLMain {
    public static void main(String args[]) throws FileNotFoundException {
        String path = args[0];

        int numEx = Integer.parseInt(args[1]);

        System.loadLibrary("cvc4jni");
         ExprManager em = new ExprManager();
         SmtEngine smt = new SmtEngine(em);


        String grammarString = new Scanner(new File(path+"/grammar.sl")).useDelimiter("\\Z").next();
        System.out.println(grammarString);
        ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.synthFunCmd();
        GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);
        GrammarInterpretor ginterpreter = new GrammarInterpretor(grammarNode);
        List<Equation> termEqs = ginterpreter.GrammarToEquations(grammarNode);

        Scanner scanner = new Scanner(new File(path+"/example"+args[2]+".txt"));

        String[] var_array = scanner.nextLine().split(" ");
        Vector<Integer> spec = new Vector<>();
        Map<String,Vector<Integer>> inputExMap = new HashMap<>();

        for(int i = 0; i < numEx; i++){
            String[] line = scanner.nextLine().split(" ");
            for(int j = 0; j < line.length-1; j++){
                if(!inputExMap.keySet().contains(var_array[j]))
                    inputExMap.put(var_array[j],new Vector<Integer>());
                inputExMap.get(var_array[j]).add(Integer.parseInt(line[j]));
            }
            spec.add(Integer.parseInt(line[line.length-1]));
        }
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputExMap);
        System.out.println(solution.get("Start").size());
        System.out.println(SMTQGenerator.checkSat(spec,solution.get("Start")));
    }
}
