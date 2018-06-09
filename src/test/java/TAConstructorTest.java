//import com.microsoft.z3.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import prover.TAConstructor;

public class TAConstructorTest {
    String grammarString = "(synth-fun max2 ((x Int) (y Int)) Int ((Start Int (x y 0 1\n" +
            "             (+ Start Start)\n" +
            "             (- Start Start)\n" +
            "             (ite StartBool Start Start) ))\n" +
            "\n" +
            " (StartBool Bool ((and StartBool StartBool)\n" +
            "                  (or StartBool StartBool)\n" +
            "                  (not StartBool)\n" +
            "                  (<= Start Start)\n" +
            "                  (= Start Start)\n" +
            "                  (>= Start Start)))))";
    @org.junit.Test
    public void testPredicateSet() {
        //Context ctx = new Context();
        ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.synthFunCmd();
        GrammarNode grammarNode = (GrammarNode)new ASTVisitor().visit(parseTree);
        System.out.println(grammarNode.toFTA());

    }
}
