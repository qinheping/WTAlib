import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import semirings.TropicalSemiring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParserUnitTest {
    @org.junit.Test
    public void testVisitor() throws FileNotFoundException{
        String input = new Scanner(new File("benchmarks/sygus/max.sl")).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        System.out.println(prog);
    }

    @org.junit.Test
    public void testToWTA() throws FileNotFoundException{
        String input = new Scanner(new File("benchmarks/sygus/max.sl")).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        System.out.println("WTA: " + prog.toWTA());
    }

    @org.junit.Test
    public void testReduction() throws FileNotFoundException{
        String input = new Scanner(new File("benchmarks/sygus/max.sl")).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        GrammarReduction<String, Float> gr = new GrammarReduction<String, Float>(new TropicalSemiring());

        System.out.println(": "+ gr.mkFTAInRange(prog.toWTA(), 2.0f, 3.0f));
        System.out.println("GR: "+ prog.toString(gr.mkFTAInRange(prog.toWTA(),2.0f,15.0f)));
        System.out.println(prog.toString(prog.getSynthFun().toFTA()));

    }

    @org.junit.Test
    public void testReduction_hackers() throws FileNotFoundException{
        String input = new Scanner(new File("benchmarks/sygus/hackers/hd-11-d1-prog.sl")).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        GrammarReduction<String, Float> gr = new GrammarReduction<String, Float>(new TropicalSemiring());

        System.out.println("GR: "+ gr.mkFTALessThanC(prog.toWTA(),4.0f));
        System.out.println("GR: "+ prog.toString(gr.mkFTALessThanC(prog.toWTA(),4.0f)));
    }
}