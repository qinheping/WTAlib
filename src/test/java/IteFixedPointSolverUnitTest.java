import com.microsoft.z3.Log;
import com.microsoft.z3.Version;
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

import java.io.*;
import java.util.*;

public class IteFixedPointSolverUnitTest {
    @org.junit.Test
    public void fg_mpg_plane1_2examples() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS_Pos/mpg_guard3/grammar.sl")).useDelimiter("\\Z").next();

        System.loadLibrary("cvc4jni");
        SMTQGenerator.em = new ExprManager();
        SMTQGenerator.smt = new SmtEngine(SMTQGenerator.em);
        SMTQGenerator.integer = SMTQGenerator.em.integerType();
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
        xEx.add(-31);
        //xEx.add(-6);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(10);
        //yEx.add(17);
        inputEx.put("y",yEx);
        Vector<Integer> zEx = new Vector<>();
        zEx.add(13);
        //zEx.add(-18);
        inputEx.put("z",zEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS_Pos/mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        //writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(-23);
        //spec.add(-23);
        System.out.println(SMTQGenerator.checkSat(spec,solution.get("Start")));
        //SMTQGenerator.checkSat_cmd(spec,solution.get("Start"));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }
    @org.junit.Test
    public void fg_mpg_plane1_2examples_z3() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/mpg_plane3/grammar.sl")).useDelimiter("\\Z").next();

        System.loadLibrary("cvc4jni");
        System.out.print("Z3 Major Version: ");
        System.out.println(Version.getMajor());
        System.out.print("Z3 Full Version: ");
        System.out.println(Version.getString());
        System.out.print("Z3 Full Version String: ");
        System.out.println(Version.getFullVersion());

        SMTQGenerator.SMTSolver = 1;
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
        xEx.add(9);
        xEx.add(25);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(17);
        yEx.add(25);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        //writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(135);
        spec.add(255);
        System.out.println(SMTQGenerator.checkSat(spec,solution.get("Start")));
        //SMTQGenerator.checkSat_cmd(spec,solution.get("Start"));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }
    @org.junit.Test
    public void fg_mpg_plane1_2examples_1() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/mpg_plane3/grammar.sl")).useDelimiter("\\Z").next();

        System.loadLibrary("cvc4jni");
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
        xEx.add(19);
        //xEx.add(33);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(50);
        //yEx.add(26);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(210);
        //spec.add(180);
        System.out.println(SMTQGenerator.checkSat(spec,solution.get("Start")));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }

    @org.junit.Test
    public void fg_mpg_plane3_2examples() throws IOException {
        //System.loadLibrary("cvc4jni");
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/mpg_plane3/grammar.sl")).useDelimiter("\\Z").next();

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
        xEx.add(9);
        xEx.add(15);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(17);
        yEx.add(21);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        System.out.println(solution.get("Start").size());
        Vector<Integer> spec = new Vector<>();
        spec.add(135);
        spec.add(185);
        System.out.println(SMTQGenerator.checkSat(spec,solution.get("Start")));

        //assert IteFixedPointSolver.iteCount == 1;
    }


    @org.junit.Test
    public void fg_mpg_plane3_1example() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/less14.sl")).useDelimiter("\\Z").next();

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
        xEx.add(1);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(2013);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(10055);
        System.out.println(SMTQGenerator.genearteSimpleSMTQ(solution.get("Start"),spec));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }

    @org.junit.Test
    public void fg_mpg_sum_2_5_2examples() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/less11.sl")).useDelimiter("\\Z").next();

        System.loadLibrary("cvc4jni");
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
        xEx.add(5);
        xEx.add(120);
        xEx.add(5);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(1);
        yEx.add(123);
        yEx.add(0);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(6);
        spec.add(243);
        spec.add(0);
        System.out.println(SMTQGenerator.checkSat(spec,solution.get("Start")));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }

    @org.junit.Test
    public void fg_mpg_guard_1_2examples() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/less3.sl")).useDelimiter("\\Z").next();

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
        xEx.add(-7);
        xEx.add(-4);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(3);
        yEx.add(10);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(-10);
        spec.add(6);
        System.out.println(SMTQGenerator.genearteSimpleSMTQ(solution.get("Start"),spec));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }

    @org.junit.Test
    public void fg_mpg_guard_2_2examples() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/less4.sl")).useDelimiter("\\Z").next();

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
        xEx.add(-15);
        xEx.add(11);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(5);
        yEx.add(15);
        inputEx.put("y",yEx);
        Vector<Integer> zEx = new Vector<>();
        zEx.add(10);
        zEx.add(15);
        inputEx.put("z",zEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(-20);
        spec.add(26);
        System.out.println(SMTQGenerator.genearteSimpleSMTQ(solution.get("Start"),spec));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }


    @org.junit.Test
    public void test_correctness() throws IOException {
        String grammarString = new Scanner(new File("benchmarks/simple.sl")).useDelimiter("\\Z").next();

        System.loadLibrary("cvc4jni");
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
        xEx.add(-15);
        xEx.add(11);
        inputEx.put("x",xEx);
        Vector<Integer> yEx = new Vector<>();
        yEx.add(5);
        yEx.add(15);
        inputEx.put("y",yEx);
        Map<String,Set<LinearSet>> solution =  IteFixedPointSolver.SolveIteFixedPoint(termEqs,inputEx);
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/fg_mpg_plane2/solution.txt"));
        System.out.println(solution.get("Start").size());
        for(LinearSet ls:solution.get("Start"))
        {
            System.out.println(ls.getBase());
        }
        System.out.println(solution.get("Start").iterator().next().getPeriod());
        writer.write(solution.get("Start").toString());
        Vector<Integer> spec = new Vector<>();
        spec.add(-20);
        spec.add(26);
        System.out.println(SMTQGenerator.genearteSimpleSMTQ(solution.get("Start"),spec));
        writer.close();

        //assert IteFixedPointSolver.iteCount == 1;
    }
}
