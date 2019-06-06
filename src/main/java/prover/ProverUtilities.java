package prover;

import automata.Move;
import automata.fta.FTA;
import com.microsoft.z3.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import parser.TimbukParser.Timbuk2FTAVisitor;
import parser.TimbukParser.TimbukLexer;
import parser.TimbukParser.TimbukParser;

import java.io.*;
import java.util.*;

public final class ProverUtilities {
    public static Expr parseTerm2Expr(Context ctx, TermNode term, Map<String, Sort> sortMap, Map<String, FuncDecl> funcDeclMap){
        String operator = term.getSymbol(); // current operator
        if(funcDeclMap.containsKey(operator)){
            Expr[] exprArray = new Expr[term.getChildren().size()];
            for(int i = 0; i < term.getChildren().size(); i++){
                exprArray[i] = parseTerm2Expr(ctx,term.getChildren().get(i),sortMap,funcDeclMap);
            }
            return ctx.mkApp(funcDeclMap.get(operator), exprArray);
        }

        // Binary operator
        if(term.getChildren().size() == 2){
            Expr expr0 = parseTerm2Expr(ctx,term.getChildren().get(0), sortMap, funcDeclMap);
            Expr expr1 = parseTerm2Expr(ctx,term.getChildren().get(1), sortMap, funcDeclMap);
            switch (operator) {
                case "+" :
                    return ctx.mkAdd((ArithExpr) expr0,(ArithExpr) expr1);
                case "-" :
                    return ctx.mkSub((ArithExpr) expr0,(ArithExpr) expr1);
                case "=" :
                    return ctx.mkEq(expr0, expr1);
                case "<" :
                    return ctx.mkLt((ArithExpr) expr0,(ArithExpr) expr1);
                case "<=" :
                    return ctx.mkLe((ArithExpr) expr0,(ArithExpr) expr1);
                case ">" :
                    return ctx.mkGt((ArithExpr) expr0,(ArithExpr) expr1);
                case ">=" :
                    return ctx.mkGe((ArithExpr) expr0,(ArithExpr) expr1);
                case "and" :
                    return ctx.mkAnd((BoolExpr) expr0,(BoolExpr) expr1);
                case "or" :
                    return ctx.mkOr((BoolExpr) expr0,(BoolExpr) expr1);
                case "bvadd" :
                    return ctx.mkBVAdd((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvor" :
                    return ctx.mkBVOR((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvxor" :
                    return ctx.mkBVXOR((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvsub" :
                    return ctx.mkBVSub((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvmul" :
                    return ctx.mkBVMul((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvudiv" :
                    return ctx.mkBVUDiv((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvusdiv" :
                    return ctx.mkBVSDiv((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvurem" :
                    return ctx.mkBVURem((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvusrem" :
                    return ctx.mkBVSRem((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvule" :
                    return ctx.mkBVULE((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvult" :
                    return ctx.mkBVULT((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvuge" :
                    return ctx.mkBVUGE((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvugt" :
                    return ctx.mkBVUGT((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvlshr" :
                    return ctx.mkBVLSHR((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvashr" :
                    return ctx.mkBVASHR((BitVecExpr) expr0,(BitVecExpr) expr1);
                case "bvshl" :
                    return ctx.mkBVSHL((BitVecExpr) expr0,(BitVecExpr) expr1);
                default:
                    System.out.println("operator not resolved: "+operator );
                    return null;
            }
        }
        // Leaf
        if(term.getChildren()==null || term.getChildren().size()==0){
            if(sortMap.keySet().contains(operator))
                return ctx.mkConst(operator, sortMap.get(operator));
            if(parseString2Const(ctx, operator) != null){
                return parseString2Const(ctx, operator);
            }

        }
        return null;
    }

    public static Sort parseSortNode2Sort(Context ctx, parser.SortNode sortNode){
        int type = sortNode.getType();
        switch (type){
            case SortNode.BOOL:
                return ctx.mkBoolSort();
            case SortNode.BV:
                return ctx.mkBitVecSort(sortNode.getLength());
            case SortNode.INT:
                return ctx.mkIntSort();
            case SortNode.REAL:
                return ctx.mkRealSort();
            default:
                System.out.println("fail to pass sort: " + sortNode.getType());
                return null;

        }
    }

    /**
     * Parse a given symbol to a z3 num object
     * @param ctx context
     * @param operator symbol used to parse
     * @return
     */
    public static Expr parseString2Const(Context ctx,String operator) {
        try {
            // LIA
            return ctx.mkInt(Integer.parseInt(operator));
        }catch(NumberFormatException e1){
            // BV
            Integer size = operator.length()-2;
            try {
                return ctx.mkBV(Integer.parseInt(operator.substring(2), 16), size);
            }catch (NumberFormatException|StringIndexOutOfBoundsException e2){
                return null;
            }
        }
    }

    /**
     * Check if the given expression <code>f</code> is satisfiable
     * @param ctx   Context
     * @param f     Expression to check
     * @return      null if unsat,
     *              model if sat
     */
    public static Model check(Context ctx, BoolExpr f)
    {
        Solver s = ctx.mkSolver();
        s.add(f);
        final long startTime = System.currentTimeMillis();
        //System.out.println("Starting checking: "+ f);
        if (s.check() == Status.SATISFIABLE){
            final long endTime = System.currentTimeMillis();
            //System.out.println("used time for SMT: " + (endTime - startTime) );

            return s.getModel();
        }
        final long endTime = System.currentTimeMillis();
        //System.out.println("used time for SMT: " + (endTime - startTime) );

        return null;

    }

    public static TermNode parseString2TermNode(String term_string){
        ANTLRInputStream inputStreamSpec = new ANTLRInputStream(term_string);
        QSygusParserLexer lexerSpec = new QSygusParserLexer(inputStreamSpec);
        CommonTokenStream tokensSpec = new CommonTokenStream(lexerSpec);
        QSygusParserParser parserSpec = new QSygusParserParser(tokensSpec);
        ParseTree parseTreeSpec = parserSpec.term();
        TermNode specNode = (TermNode) new ASTVisitor().visit(parseTreeSpec);
        return specNode;
    }

    public static Sort getSortFromExpr(Expr expr, String var){
        if(expr.getNumArgs() == 0){
            return var.equals(expr.toString())? expr.getSort():null;
        }
        for(Expr arg: expr.getArgs()){
            if(getSortFromExpr(arg, var) != null)
                return getSortFromExpr(arg, var);
        }
        return null;
    }

    public static void getMintermsRec(Context ctx, ArrayList<BoolExpr> predicates, int n,
                                      BoolExpr currPred, ArrayList<Integer> setBits,
                                      HashSet<Pair<BoolExpr,ArrayList<Integer>>> minterms){
        if (!IsSatisfiable(ctx,currPred))
            return;

        if (n == predicates.size()) {
            minterms.add(new Pair<BoolExpr, ArrayList<Integer>>(currPred, setBits));
        }
        else {
            ArrayList<Integer> posList = new ArrayList<Integer>(setBits);
            posList.add(1);
            BoolExpr pn =predicates.get(n);
            getMintermsRec(ctx,predicates, n + 1,
                    ctx.mkAnd(currPred, pn), posList, minterms);

            ArrayList<Integer> negList = new ArrayList<Integer>(setBits);
            negList.add(0);
            getMintermsRec(ctx,predicates, n + 1,
                    ctx.mkAnd(currPred, ctx.mkNot(pn)), negList,
                    minterms);
        }
    }

    public static boolean IsSatisfiable(Context ctx, BoolExpr expr){
        return check(ctx, expr) != null;
    }

    public static BoolExpr generateTermFromOperator(Context ctx, String operator, String output, List<String> args){
        switch (operator){
            case "+":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkIntSort()),ctx.mkAdd((ArithExpr) ctx.mkConst(args.get(0),ctx.mkIntSort()),(ArithExpr) ctx.mkConst(args.get(1),ctx.mkIntSort())));
            case "-":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkIntSort()),ctx.mkSub((ArithExpr) ctx.mkConst(args.get(0),ctx.mkIntSort()),(ArithExpr) ctx.mkConst(args.get(1),ctx.mkIntSort())));
            case "and":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkBoolSort()),ctx.mkAnd((BoolExpr) ctx.mkConst(args.get(0),ctx.mkBoolSort()),(BoolExpr) ctx.mkConst(args.get(1),ctx.mkBoolSort())));
            case "or":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkBoolSort()),ctx.mkOr((BoolExpr) ctx.mkConst(args.get(0),ctx.mkBoolSort()),(BoolExpr) ctx.mkConst(args.get(1),ctx.mkBoolSort())));
            case "not":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkBoolSort()),ctx.mkNot((BoolExpr) ctx.mkConst(args.get(0),ctx.mkBoolSort())));
            case "<=":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkBoolSort()),ctx.mkLe((ArithExpr) ctx.mkConst(args.get(0),ctx.mkIntSort()),(ArithExpr) ctx.mkConst(args.get(1),ctx.mkIntSort())));
            case ">=":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkBoolSort()),ctx.mkGe((ArithExpr) ctx.mkConst(args.get(0),ctx.mkIntSort()),(ArithExpr) ctx.mkConst(args.get(1),ctx.mkIntSort())));
            case "=":
                return ctx.mkEq(ctx.mkConst(output,ctx.mkBoolSort()),ctx.mkEq(ctx.mkConst(args.get(0),ctx.mkIntSort()), ctx.mkConst(args.get(1),ctx.mkIntSort())));
            default:
                return null;
        }
    }

    public static boolean isOutputBool(String operator){
        switch(operator){
            case "and":
            case "not":
            case "or":
            case ">":
            case ">=":
            case "<=":
            case "<":
            case "==":
            case "!=":
                return true;
            default:
                return false;
        }
    }
    public static boolean isArgsBool(String operator){
        switch(operator){
            case "and":
            case "not":
            case "or":
                return true;
            default:
                return false;
        }
    }
    public static boolean isSymmetric(String operator){
        switch(operator){
            case "and":
            case "not":
            case "+":
                return true;
            default:
                return false;
        }
    }

    public static FTA<String> parseTimbuk2FTA(String grammarString){


        ANTLRInputStream inputStream = new ANTLRInputStream(grammarString);
        TimbukLexer lexer = new TimbukLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TimbukParser parser = new TimbukParser(tokens);
        ParseTree parseTree = parser.file();
        FTA fta = new Timbuk2FTAVisitor().visit(parseTree);
        return fta;
    }

    public static FTA<String> reduceFTA(FTA<String> fta){
        String timbukIn = "";
        String timbuk = fta.toTimbukString();
        try {
            File tempOut = File.createTempFile("timbukOut", ".tmp");
            System.out.println("Temp file : " + tempOut.getAbsolutePath());
            tempOut.deleteOnExit();
            File tempIn = File.createTempFile("timbukIn", ".tmp");
            tempIn.deleteOnExit();


            BufferedWriter bw = new BufferedWriter(new FileWriter(tempOut));
            bw.write(timbuk);
            bw.close();

            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("./lib/vata red "+tempOut.getAbsolutePath().toString());

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while((line = reader.readLine())!=null)
                timbukIn+="\n"+line;


        }catch (java.io.IOException e){
            System.out.println("fail to create tmp file");
            return null;
        }




        return parseTimbuk2FTA(timbukIn);
    }

    public static boolean isConstantFTA(FTA fta){
        for(Move move: (Collection<Move>)fta.getLeafTransitions()){
            if(!isConstantSymbol( (String)move.symbol)){
                System.out.println(move.symbol);
                return false;
            }
        }
        return true;
    }

    public static boolean isConstantSymbol(String symbol){
        return parseString2Const(new Context(), symbol) != null;
    }

    public static FTA<String> callVata(FTA<String> fta1, FTA<String> fta2, String op) {

        String timbukIn = "";
        String timbuk1 = fta1.toTimbukString();
        String timbuk2 = fta2.toTimbukString();
        try {
            File tempOut1 = File.createTempFile("timbukOut1", ".tmp");
            System.out.println("Temp file 1: " + tempOut1.getAbsolutePath());
            tempOut1.deleteOnExit();
            File tempIn1 = File.createTempFile("timbukIn1", ".tmp");
            tempIn1.deleteOnExit();

            BufferedWriter bw1 = new BufferedWriter(new FileWriter(tempOut1));
            bw1.write(timbuk1);
            bw1.close();

            File tempOut2 = File.createTempFile("timbukOut2", ".tmp");
            System.out.println("Temp file 2: " + tempOut2.getAbsolutePath());
            tempOut2.deleteOnExit();
            File tempIn2 = File.createTempFile("timbukIn2", ".tmp");
            tempIn2.deleteOnExit();


            BufferedWriter bw2 = new BufferedWriter(new FileWriter(tempOut2));
            bw2.write(timbuk2);
            bw2.close();

            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("./lib/vata "+ op +" "+tempOut1.getAbsolutePath().toString()+ " " +tempOut2.getAbsolutePath().toString());

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while((line = reader.readLine())!=null)
                timbukIn+="\n"+line;


        }catch (java.io.IOException e){
            System.out.println("fail to create tmp file");
            return null;
        }


        //System.out.print(timbukIn);

        return parseTimbuk2FTA(timbukIn);
    }
}
