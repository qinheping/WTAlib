package utilities;

import edu.nyu.acsys.CVC4.Expr;
import semirings.LinearSet;

import java.io.*;
import java.lang.Integer;
import com.microsoft.z3.*;
import java.util.*;
import edu.nyu.acsys.CVC4.*;

public class SMTQGenerator {
    public static int SMTSolver = 0; // 0 for CVC4, 1 for Z3

    public static  ExprManager em;
    public static SmtEngine smt;
    public static Type integer;

    public static String genearteSimpleSMTQ(Set<LinearSet> sls, Vector<Integer> target){
        String result = "(assert (or ";
        for(LinearSet sl : sls){
            result += "(and ";
            for(int i = 0; i < target.size(); i++){
                result += "(= "+ target.get(i)+" "+sl.getBase().get(i)+")";
            }
            result +=")";
        }
        result +=")) (check-sat)";
        return  result;
    }

    static int count = 0;
    public static boolean checkSat(Vector<Integer> spec, Set<LinearSet> start) {
        if(SMTQGenerator.SMTSolver==1){
            return checkSat_z3(spec,start);
        }
        count = 0;
        Iterator<LinearSet> iterator = start.iterator();

        while(iterator.hasNext()){
            if(checkInLinearSet(spec,iterator.next())) {
                //System.out.print(spec+" "+ls);
                return true;
            }
            iterator.remove();
            //System.out.println(" start next Q");
        }
        return false;
    }

    public static boolean checkSat_z3(Vector<Integer> spec, Set<LinearSet> start) {
        Iterator<LinearSet> iterator = start.iterator();
        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);
        while(iterator.hasNext()){
            if(checkInLinearSet_z3(spec,iterator.next(),ctx)) {
                //System.out.print(spec+" "+ls);
                return true;
            }
            iterator.remove();
            //System.out.println(" start next Q");
        }
        return false;
    }

    private static boolean checkInLinearSet_z3(Vector<Integer> target, LinearSet ls, Context ctx)  {

        int dim = target.size();



        BoolExpr body;
        IntExpr zero = ctx.mkInt(0);
        BoolExpr assert_nature = ctx.mkTrue();
        List<Vector<Integer>> peroid_list = new ArrayList<>(ls.getPeriod());
        List<IntExpr> bound_vars = new ArrayList<>();

        for(int i = 0; i < ls.getPeriod().size();i++){
            bound_vars.add(ctx.mkIntConst("z"+"_"+i));
            assert_nature = ctx.mkAnd(assert_nature,ctx.mkGe(bound_vars.get(i),zero));
        }

        body = assert_nature;

        for(int j = 0; j < dim; j++){
            ArithExpr body_j = ctx.mkInt(ls.getBase().get(j));
            for(int i = 0; i < ls.getPeriod().size(); i++){
                body_j = ctx.mkAdd(body_j,ctx.mkMul(bound_vars.get(i),ctx.mkInt(peroid_list.get(i).get(j))));
            }
            body =ctx.mkAnd( ctx.mkEq(body_j,ctx.mkInt(target.get(j))),body);
        }
        Boolean result =  checkSMTSat(ctx,body);
        return result;
    }

    static Boolean checkSMTSat(Context ctx, BoolExpr f)
    {
        Solver s = ctx.mkSolver();
        s.add(f);
        if (s.check() == Status.SATISFIABLE)
            return true;
        return false;
    }

    private static String mkExpr_cmd(String op, String first, String second){
        return "(" +op+" "+first +" "+second+")";
    }

    static String unaryMinus(Integer i){
        if(i < 0)
            return "(- "+(-i);
        return i.toString();
    }


    public static Boolean checkInLinearSet(Vector<Integer> target, LinearSet ls){
        count++;
        int dim = target.size();
        Boolean result = true;
        if (ls.getPeriod().size() == 0) { // simple mode
            for(int i = 0; i < dim; i++){
                result = result && (ls.getBase().get(i) == target.get(i));
            }
            return result;
        }

        Expr body = em.mkConst(true);
        Expr zero = em.mkConst(new Rational(0));
        Expr assert_nature = em.mkConst(true);
        List<Vector<Integer>> peroid_list = new ArrayList<>(ls.getPeriod());

        List<Expr> bound_vars = new ArrayList<>();
        for(int i = 0; i < ls.getPeriod().size();i++){
                bound_vars.add(em.mkVar("z"+"_"+i,integer));
                assert_nature = em.mkExpr(Kind.AND,assert_nature,em.mkExpr(Kind.GEQ,bound_vars.get(i),zero));

        }

        body = assert_nature;

        for(int j = 0; j < dim; j++){
            Expr body_j = em.mkConst(new Rational(ls.getBase().get(j)));
            for(int i = 0; i < ls.getPeriod().size(); i++){
                body_j = em.mkExpr(Kind.PLUS,body_j,em.mkExpr(Kind.MULT,bound_vars.get(i),em.mkConst(new Rational(peroid_list.get(i).get(j)))));
            }
            body_j = em.mkExpr(Kind.EQUAL,body_j,em.mkConst(new Rational(target.get(j))));
            body = em.mkExpr(Kind.AND, body,body_j);
        }
         result =  smt.checkSat(body).toString().equals("sat");
        return result;
    }

    public static Set<Vector<Boolean>> getBVSet(Set<LinearSet> left, Set<LinearSet> right, String bop) {
        Set<Vector<Boolean>> result = new HashSet<>();
        List<LinearSet> leftList = new ArrayList<>(left);
        List<LinearSet> rightList = new ArrayList<>(right);
        if(leftList.size() == 0 || rightList.size() == 0)
            return result;

        int dim = leftList.get(0).getBase().size();
        Vector<Boolean> currentBv = new Vector();
        return getBVSet_recursion(leftList,rightList,bop,dim,result,currentBv);
    }

    private static Set<Vector<Boolean>> getBVSet_recursion(List<LinearSet> left, List<LinearSet> right, String bop, int remain, Set<Vector<Boolean>> result, Vector<Boolean> currentBv) {

        for(LinearSet leftLS:left){
           for(LinearSet rightLS:right){
               if(SMTSolver == 1) {
                   result.addAll(getBVSet_recursion_z3(leftLS, rightLS, bop, remain, result, currentBv));
               }
               else
                   result.addAll(getBVSet_recursion(leftLS,rightLS,bop,remain,result,currentBv));

               if(result.size()==Math.pow(2,left.get(0).getBase().size()))
                   return result;
           }
       }
       return result;
    }


    private static Set<Vector<Boolean>> getBVSet_recursion_z3(LinearSet left, LinearSet right, String bop, int remain, Set<Vector<Boolean>> result, Vector<Boolean> currentBv) {
        if(remain != 0){
            Vector<Boolean> currentBv_T = new Vector(currentBv);
            Vector<Boolean> currentBv_F = new Vector(currentBv);
            currentBv_T .add(true);
            currentBv_F.add(false);
            result.addAll(getBVSet_recursion_z3(left, right, bop, remain-1, result, currentBv_T));
            result.addAll(getBVSet_recursion_z3(left, right, bop, remain-1, result, currentBv_F));
            return  result;
        }
        if(result.contains(currentBv))
            return result;

        int dim = currentBv.size();
        if(result.size()==Math.pow(2,dim))
            return result;

        float startTime_1 = System.nanoTime();

        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);

        BoolExpr body = ctx.mkTrue();
        // body = true /\ (z = bx1 + x*px1 \/ z = bx2 + x*px2 \/ ...) /\ (z bop by1 + y*py1 \/ ..)
        //                        z \in left                                   z bop z' \in right

        List<IntExpr> boundx_list = new ArrayList<>();
        List<IntExpr> boundy_list = new ArrayList<>();

        BoolExpr assertx = ctx.mkTrue();
        BoolExpr asserty = ctx.mkTrue();
        IntExpr zero = ctx.mkInt(0);

        List<Vector<Integer>> period_list_x = new ArrayList<>(left.getPeriod());
        List<Vector<Integer>> period_list_y = new ArrayList<>(right.getPeriod());

        for(int ix = 0; ix < left.getPeriod().size(); ix++  ){
                boundx_list.add(ctx.mkInt("x_"+ix));
                assertx = ctx.mkAnd(assertx,ctx.mkGe(boundx_list.get(ix),zero));
        }

        for(int iy = 0; iy < right.getPeriod().size(); iy++  ){

                boundy_list.add(ctx.mkInt("y_"+iy));
                asserty = ctx.mkAnd(asserty,ctx.mkGe(boundy_list.get(iy),zero));

        }

        for(int d = 0; d < dim; d++){
            ArithExpr body_left = ctx.mkInt(left.getBase().get(d));
            ArithExpr body_right = ctx.mkInt(right.getBase().get(d));
            for(int i = 0; i < period_list_x.size();i++){
                body_left = ctx.mkAdd(body_left,ctx.mkMul(boundx_list.get(i),ctx.mkInt(period_list_x.get(i).get(d))));
            }
            for(int i = 0; i < period_list_y.size();i++){
                body_right = ctx.mkAdd(body_right,ctx.mkMul(boundy_list.get(i),ctx.mkInt(period_list_y.get(i).get(d))));
            }
            if(currentBv.get(d)) {
                if(bop.equals("<="))
                    body = ctx.mkAnd(body, ctx.mkLe( body_left, body_right));
                if(bop.equals(">="))
                    body = ctx.mkAnd(body, ctx.mkGe( body_left, body_right));
                if(bop.equals("<"))
                    body = ctx.mkAnd(body, ctx.mkLt( body_left, body_right));
                if(bop.equals(">"))
                    body = ctx.mkAnd(body, ctx.mkGt( body_left, body_right));
                if(bop.equals("="))
                    body = ctx.mkAnd(body, ctx.mkEq( body_left, body_right));
            }
            else
            {
                if(bop.equals("<="))
                    body = ctx.mkAnd(body, ctx.mkNot(ctx.mkLe( body_left, body_right)));
                if(bop.equals(">="))
                    body = ctx.mkAnd(body, ctx.mkNot(ctx.mkGe( body_left, body_right)));
                if(bop.equals("<"))
                    body = ctx.mkAnd(body, ctx.mkNot(ctx.mkLt( body_left, body_right)));
                if(bop.equals(">"))
                    body = ctx.mkAnd(body, ctx.mkNot(ctx.mkGt( body_left, body_right)));
                if(bop.equals("="))
                    body = ctx.mkAnd(body, ctx.mkNot(ctx.mkEq( body_left, body_right)));
            }
        }

        body = ctx.mkAnd(body,assertx);
        body = ctx.mkAnd(body,asserty);


        float startTime_2 = System.nanoTime();
        Boolean sat =checkSMTSat(ctx,body);
        float end = System.nanoTime();
        if((end-startTime_1)/1000>10000) {
            System.out.println(currentBv);
            System.out.println(result);
            System.out.println(body);
            System.out.println("time1: " + (end - startTime_1) / 1000 + "   time2: " + (end - startTime_2) / 1000);
        }

        if(sat) {
            // System.out.println("SAT: "+currentBv+" "+body);
            result.add(currentBv);
        }

        return result;
    }

    private static Set<Vector<Boolean>> getBVSet_recursion(LinearSet left, LinearSet right, String bop, int remain, Set<Vector<Boolean>> result, Vector<Boolean> currentBv) {
        if(remain != 0){
            Vector<Boolean> currentBv_T = new Vector(currentBv);
            currentBv_T .add(true);
            Vector<Boolean> currentBv_F = new Vector(currentBv);
            currentBv_F.add(false);
            result.addAll(getBVSet_recursion(left, right, bop, remain-1, result, currentBv_T));
            result.addAll(getBVSet_recursion(left, right, bop, remain-1, result, currentBv_F));
            return  result;
        }
        if(result.contains(currentBv))
            return result;

        int dim = currentBv.size();
        if(result.size()==Math.pow(2,dim))
            return result;


        if(left.getPeriod().size() == 0 && right.getPeriod().size() == 0){ // simple mode
            boolean flag = true;
            for(int i = 0; i < dim;i++){
                if(currentBv.get(i))
                    flag = flag && parse_bop_simple(bop, left.getBase().get(i),right.getBase().get(i));
                else
                    flag = flag && (!parse_bop_simple(bop,left.getBase().get(i),right.getBase().get(i)));
            }
            if (flag)
                result.add(currentBv);
            return result;

        }

        Expr body = em.mkConst(true);
        // body = true /\ (z = bx1 + x*px1 \/ z = bx2 + x*px2 \/ ...) /\ (z bop by1 + y*py1 \/ ..)
        //                        z \in left                                   z bop z' \in right

        List<Expr> boundx_list = new ArrayList<>();
        List<Expr> boundy_list = new ArrayList<>();

        Expr assertx = em.mkConst(true);
        Expr asserty = em.mkConst(true);
        Expr zero = em.mkConst(new Rational(0));

        List<Vector<Integer>> period_list_x = new ArrayList<>(left.getPeriod());
        List<Vector<Integer>> period_list_y = new ArrayList<>(right.getPeriod());

        for(int ix = 0; ix < left.getPeriod().size(); ix++  ){
                    boundx_list.add(em.mkVar("x_"+ix+"_"+"d",integer));
                    assertx = em.mkExpr(Kind.AND,assertx,em.mkExpr(Kind.GEQ,boundx_list.get(ix),zero));
        }

        for(int iy = 0; iy < right.getPeriod().size(); iy++  ){

            for(int d = 0; d < dim; d++){;
                boundy_list.add(em.mkVar("y_"+iy+"_"+"d",integer));
                asserty = em.mkExpr(Kind.AND,asserty,em.mkExpr(Kind.GEQ,boundy_list.get(iy),zero));
            }
        }

        for(int d = 0; d < dim; d++){
            Expr body_left = em.mkConst(new Rational(left.getBase().get(d)));
            Expr body_right = em.mkConst(new Rational(right.getBase().get(d)));
            for(int i = 0; i < period_list_x.size();i++){
                body_left = em.mkExpr(Kind.PLUS,body_left,em.mkExpr(Kind.MULT,boundx_list.get(i),em.mkConst(new Rational(period_list_x.get(i).get(d)))));
            }
            for(int i = 0; i < period_list_y.size();i++){
                body_right = em.mkExpr(Kind.PLUS,body_right,em.mkExpr(Kind.MULT,boundy_list.get(i),em.mkConst(new Rational(period_list_y.get(i).get(d)))));
            }
            if(currentBv.get(d))
            body =em.mkExpr(Kind.AND,body,em.mkExpr(parse_bop(bop),body_left,body_right));
            else
                body =em.mkExpr(Kind.AND,body,em.mkExpr(Kind.NOT,em.mkExpr(parse_bop(bop),body_left,body_right)));
        }

        body = em.mkExpr(Kind.AND,body,assertx);
        body = em.mkExpr(Kind.AND,body,asserty);


        if(smt.checkSat(body).toString().equals("sat")) {
            // System.out.println("SAT: "+currentBv+" "+body);
            result.add(currentBv);
        }

        return result;
    }

    private static Kind parse_bop(String bop){
        switch (bop){
            case "<":return Kind.LT;
            case ">":return Kind.GT;
            case "<=":return Kind.LEQ;
            case ">=":return Kind.GEQ;
            case "=":
            case "==":return Kind.EQUAL;

        }
        return  null;
    }
    private static boolean parse_bop_simple(String bop, Integer left, Integer right){
        switch (bop){
            case "<":return left < right;
            case ">":return left > right;
            case "<=":return left <= right;
            case ">=":return left >= right;
            case "=":
            case "==":return left == right;
        }
        return  false;
    }


}
