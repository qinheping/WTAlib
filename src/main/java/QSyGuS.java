import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ASTVisitor;
import parser.QSygusNode;
import parser.QSygusParserLexer;
import parser.QSygusParserParser;
import semirings.ProbabilitySemiring;
import semirings.TropicalSemiring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QSyGuS {
    public static  void main(String[] args)throws FileNotFoundException{
        String solverName = args[0];
        List<String> benchmarkPaths = new ArrayList<String>();
        for(int i = 1; i < args.length; i++){
            solve(args[i],solverName);
        }

    }

    private static void solve(String benchmarkPath, String solverName)throws FileNotFoundException {
        String input = new Scanner(new File(benchmarkPath)).useDelimiter("\\Z").next();
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        QSygusParserLexer lexer = new QSygusParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QSygusParserParser parser = new QSygusParserParser(tokens);
        ParseTree parseTree = parser.prog();
        QSygusNode prog = (QSygusNode)new ASTVisitor().visit(parseTree);
        GrammarReduction<String, Float> gr1, gr2;
        if(prog.semirings.get(0).equals("TROP"))
            gr1 = new GrammarReduction<String, Float>(new TropicalSemiring());
        if(prog.semirings.get(0).equals("PROB"))
            gr1 = new GrammarReduction<String, Float>(new ProbabilitySemiring());
        if(prog.semirings.size()>1){
            if(prog.semirings.get(1).equals("TROP"))
                gr2 = new GrammarReduction<String, Float>(new TropicalSemiring());
            if(prog.semirings.get(0).equals("PROB"))
                gr2 = new GrammarReduction<String, Float>(new ProbabilitySemiring());
        }

        String initial_script;

        // no weight constain
        if(prog.weightConstraint == null){
            initial_script = prog.toString();
        }
    }

}
