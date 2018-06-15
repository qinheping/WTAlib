import automata.fta.FTA;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.TimbukParser.Timbuk2FTAVisitor;
import parser.TimbukParser.TimbukLexer;
import parser.TimbukParser.TimbukParser;

public class TimbukParserUnitTest {
    String grammarString = "Ops \n" +
            "Automaton anonymous\n" +
            "States \n" +
            "Final States q0 \n" +
            "Transitions\n" +
            "0 -> q0\n" +
            "0 -> q6\n" +
            "0 -> q8\n" +
            "0 -> q9\n" +
            "1 -> q0\n" +
            "1 -> q6\n" +
            "1 -> q8\n" +
            "1 -> q9\n" +
            "x -> q0\n" +
            "y -> q6\n" +
            "+(q0, q0) -> q0\n" +
            "+(q0, q0) -> q6\n" +
            "+(q0, q0) -> q8\n" +
            "-(q0, q0) -> q0\n" +
            "-(q0, q0) -> q6\n" +
            "-(q0, q0) -> q8\n" +
            "+(q0, q6) -> q0\n" +
            "+(q0, q6) -> q6\n" +
            "+(q0, q6) -> q8\n" +
            "-(q0, q6) -> q0\n" +
            "-(q0, q6) -> q6\n" +
            "-(q0, q6) -> q8\n" +
            "+(q0, q8) -> q0\n" +
            "+(q0, q8) -> q6\n" +
            "+(q0, q8) -> q8\n" +
            "-(q0, q8) -> q0\n" +
            "-(q0, q8) -> q6\n" +
            "-(q0, q8) -> q8\n" +
            "+(q6, q0) -> q0\n" +
            "+(q6, q0) -> q6\n" +
            "+(q6, q0) -> q8\n" +
            "-(q6, q0) -> q0\n" +
            "-(q6, q0) -> q6\n" +
            "-(q6, q0) -> q8\n" +
            "+(q6, q6) -> q0\n" +
            "+(q6, q6) -> q6\n" +
            "+(q6, q6) -> q8\n" +
            "-(q6, q6) -> q0\n" +
            "-(q6, q6) -> q6\n" +
            "-(q6, q6) -> q8\n" +
            "+(q6, q8) -> q0\n" +
            "+(q6, q8) -> q6\n" +
            "+(q6, q8) -> q8\n" +
            "-(q6, q8) -> q0\n" +
            "-(q6, q8) -> q6\n" +
            "-(q6, q8) -> q8\n" +
            "+(q8, q0) -> q0\n" +
            "+(q8, q0) -> q6\n" +
            "+(q8, q0) -> q8\n" +
            "-(q8, q0) -> q0\n" +
            "-(q8, q0) -> q6\n" +
            "-(q8, q0) -> q8\n" +
            "+(q8, q6) -> q0\n" +
            "+(q8, q6) -> q6\n" +
            "+(q8, q6) -> q8\n" +
            "-(q8, q6) -> q0\n" +
            "-(q8, q6) -> q6\n" +
            "-(q8, q6) -> q8\n" +
            "+(q8, q8) -> q0\n" +
            "+(q8, q8) -> q6\n" +
            "+(q8, q8) -> q8\n" +
            "+(q8, q8) -> q9\n" +
            "-(q8, q8) -> q0\n" +
            "-(q8, q8) -> q6\n" +
            "-(q8, q8) -> q8\n" +
            "-(q8, q8) -> q9\n" +
            "+(q8, q9) -> q8\n" +
            "+(q8, q9) -> q9\n" +
            "-(q8, q9) -> q8\n" +
            "-(q8, q9) -> q9\n" +
            "+(q9, q8) -> q8\n" +
            "+(q9, q8) -> q9\n" +
            "-(q9, q8) -> q8\n" +
            "-(q9, q8) -> q9\n" +
            "+(q9, q9) -> q8\n" +
            "+(q9, q9) -> q9\n" +
            "-(q9, q9) -> q8\n" +
            "-(q9, q9) -> q9\n";

    ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
    TimbukLexer lexer = new TimbukLexer(inputStream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    TimbukParser parser = new TimbukParser(tokens);
    ParseTree parseTree = parser.file();
    FTA fta = (FTA)new Timbuk2FTAVisitor().visit(parseTree);

    @org.junit.Test
    public void testParser() {
        //Context ctx = new Context();
        System.out.println(fta);

    }
}
