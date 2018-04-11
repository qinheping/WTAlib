import grammar.GrammarReduction;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
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
            initial_script = prog.toString(prog.getSynthFun().toFTA());
        }else{
            TermNode constraint = prog.getWeightConstraint();
            //special case
            if(isInterval(constraint)){
                boolean isSupClosed = true;
                boolean isInfClosed = true;

                TermNode term0 = constraint.getChildren().get(0);
                TermNode term1 = constraint.getChildren().get(1);
                if(term0)
            }
        }
    }

    private static boolean isInterval(TermNode term){
        if(!term.getSymbol().equals("and"))
            return false;
        if(term.getChildren().size()!=2)
            return false;
        String s0 = term.getChildren().get(0).getSymbol();
        String s1 = term.getChildren().get(1).getSymbol();
        if((s0.equals(">=") || s0.equals(">")) && (s1.equals("<=") || s1.equals("<")))
            return true;
        if((s1.equals(">=") || s1.equals(">")) && (s0.equals("<=") || s0.equals("<")))
            return true;
        return false;
    }
}
