import automata.fta.FTA;
import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import semirings.TropicalSemiring;

import java.io.*;
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
    public void testToWTA() throws FileNotFoundException {
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
    public void testReduction() throws IOException {
        String input = new Scanner(new File("benchmarks/sygus/max3.sl")).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        GrammarReduction<String, Float> gr = new GrammarReduction<String, Float>(new TropicalSemiring());

        //System.out.println(": "+ gr.mkFTAInRange(prog.toWTA(), 2.0f, 3.0f));
        //System.out.println("GR: "+ prog.toString(gr.mkFTAInRange(prog.toWTA(),11.0f, true,11.0f,true)));
        //System.out.println(QSyGuS.callSolver(prog.toString(gr.mkFTAInRange(prog.toWTA(),2.0f, true,3.0f,true)),"",prog.toWTA(),gr.sr));
        //System.out.println(prog.getSynthFun().toFTA());
        FTA fta_0 = gr.mkFTALessThanC(prog.toWTA(), 2.0f);
        FTA fta_1 = gr.mkFTALessThanC(prog.toWTA(), 4.0f);
        System.out.println(fta_0);
        //System.out.println(fta_1);
        //System.out.println(fta);
        //fta.compressState();
        //System.out.println(fta_0.intersectionWith(fta_1));

    }

    @org.junit.Test
    public void testReduction_hackers() throws IOException{
        String input = new Scanner(new File("benchmarks/CLIA_Track_PLUS/fg_mpg_plane3.sl")).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        GrammarReduction<String, Float> gr = new GrammarReduction<String, Float>(new TropicalSemiring());
        //System.out.println("GR: "+ gr.mkFTALessThanC(prog.toWTA(),4.0f));
        BufferedWriter writer = new BufferedWriter(new FileWriter("benchmarks/CLIA_Track_PLUS/out"));
        writer.write(prog.toString(gr.mkFTALessThanC(prog.toWTA(),4.0f)));
        writer.close();
    }
}