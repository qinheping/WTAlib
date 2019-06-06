import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ASTVisitor;
import parser.GrammarNode;
import parser.QSygusParserLexer;
import parser.QSygusParserParser;
import utilities.Equation;
import utilities.GrammarInterpretor;
import utilities.IteFixedPointSolver;

import java.util.List;

public class IteFixedPointSolverUnitTest {
    String grammarString = "(synth-fun max2 ((x Int) (y Int)) Int ((Start Int (x y 0 1\n" +
            "             (+ Start Start) (ite B Start Start)\n" +
            "            \n))   (B Bool ( (< Start Start) (not B) ))  )))";

    ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
    QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    QSygusParserParser parser = new QSygusParserParser(tokens);
    ParseTree parseTree = parser.synthFunCmd();
    GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);
    //System.out.println(grammarNode.toString());

    GrammarInterpretor ginterpreter = new GrammarInterpretor(grammarNode);
    List<Equation> termEqs = ginterpreter.GrammarToEquations(grammarNode);
    @org.junit.Test
    public void iteCountTest(){
        IteFixedPointSolver.SolveIteFixedPoint(termEqs,null);
        assert IteFixedPointSolver.iteCount == 1;
    }
}
