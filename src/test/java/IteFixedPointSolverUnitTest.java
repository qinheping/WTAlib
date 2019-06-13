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

import java.io.*;
import java.util.*;

public class IteFixedPointSolverUnitTest {
    @org.junit.Test
    public void iteCountTestLess8() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/less8.sl")).useDelimiter("\\Z").next();

        ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.synthFunCmd();
        GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);
        //System.out.println(grammarNode.toString());

        GrammarInterpretor ginterpreter = new GrammarInterpretor(grammarNode);
        List<Equation> termEqs = ginterpreter.GrammarToEquations(grammarNode);
        Map<String,Vector<Integer>> inputEx = new HashMap<>();
        Vector<Integer> xEx = new Vector<>();
        xEx.add(10);
        xEx.add(20);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(17);
        yEx.add(21);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(84);
        spec.add(126);
        System.out.println(SMTQGenerator.genearteSimpleSMTQ(solution.get("Start"),spec));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }

    @org.junit.Test
    public void iteCountTestLess29() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/less29.sl")).useDelimiter("\\Z").next();

        ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.synthFunCmd();
        GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);
        //System.out.println(grammarNode.toString());

        GrammarInterpretor ginterpreter = new GrammarInterpretor(grammarNode);
        List<Equation> termEqs = ginterpreter.GrammarToEquations(grammarNode);
        Map<String,Vector<Integer>> inputEx = new HashMap<>();
        Vector<Integer> xEx = new Vector<>();
        xEx.add(10);
        xEx.add(20);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(17);
        yEx.add(21);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(140);
        spec.add(210);
        System.out.println(SMTQGenerator.genearteSimpleSMTQ(solution.get("Start"),spec));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }
}
