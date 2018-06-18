//import com.microsoft.z3.*;
import com.microsoft.z3.Context;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import prover.AbstractLearner;
import prover.PredicateSet;
import prover.ProverUtilities;
import prover.TAConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TAConstructorTest {
    String grammarString = "(synth-fun max2 ((x Int) (y Int)) Int ((Start Int (x y 0 1\n" +
            "             (+ Start Start)\n" +
            "             (- Start Start)\n))))";

    ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
    QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    QSygusParserParser parser = new QSygusParserParser(tokens);
    ParseTree parseTree = parser.synthFunCmd();
    GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);

    String specString = "(and (>= (max2 x y) x) (and (>= (max2 x y) y) (or (= x (max2 x y)) (= y (max2 x y)))))";

    ANTLRInputStream inputStreamSpec = new ANTLRInputStream(specString);
    QSygusParserLexer lexerSpec = new QSygusParserLexer(inputStreamSpec);
    CommonTokenStream tokensSpec = new CommonTokenStream(lexerSpec);
    QSygusParserParser parserSpec = new QSygusParserParser(tokensSpec);
    ParseTree parseTreeSpec = parserSpec.term();
    TermNode specNode = (TermNode) new ASTVisitor().visit(parseTreeSpec);


    @org.junit.Test
    public void testPredicateSet() {
        //Context ctx = new Context();
        System.out.println(grammarNode.toFTA());
        System.out.println(ProverUtilities.reduceFTA(grammarNode.toFTA()));

    }

    @org.junit.Test
    public void testTAConstructor() {
        Context ctx = new Context();
        TermNode tree = ProverUtilities.parseString2TermNode("(ite (> x y) x y)");
        System.out.println(tree);
        List<String> args = new ArrayList<>();
        args.add("x");
        args.add("y");
        AbstractLearner abL = new AbstractLearner(ctx,args,tree,ctx.mkIntSort());
        PredicateSet pSet = abL.learn();
        TAConstructor taCon = new TAConstructor(ctx,grammarNode,specNode, pSet,new HashMap<>());
    }
}
