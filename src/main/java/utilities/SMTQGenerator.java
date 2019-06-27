package utilities;

import edu.nyu.acsys.CVC4.Expr;
import semirings.LinearSet;

import java.lang.Integer;
import java.util.*;
import edu.nyu.acsys.CVC4.*;


public class SMTQGenerator {

    static ExprManager em = new ExprManager();
    static SmtEngine smt = new SmtEngine(em);
    static Type integer = em.integerType();
    static Type bool = em.booleanType();
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

    public static boolean checkSat(Vector<Integer> spec, Set<LinearSet> start) {
        for(LinearSet ls: start){
            if(checkInLinearSet(spec,ls)) {
                //System.out.print(spec+" "+ls);
                return true;
            }
        }
        return false;
    }
    public static Boolean checkInLinearSet(Vector<Integer> target, LinearSet ls){


        int dim = target.size();

        Expr body = em.mkConst(true);
        Expr zero = em.mkConst(new Rational(0));
        Expr assert_nature = em.mkConst(true);
        List<Vector<Integer>> peroid_list = new ArrayList<>(ls.getPeriod());

        List<List<Expr>> bound_vars = new ArrayList<>();
        for(int i = 0; i < ls.getPeriod().size();i++){
            bound_vars.add(new ArrayList<>());
            for(int j = 0; j < dim; j++){
                bound_vars.get(i).add(em.mkBoundVar("z"+"_"+i+"_"+j,integer));
                assert_nature = em.mkExpr(Kind.AND,assert_nature,em.mkExpr(Kind.GEQ,bound_vars.get(i).get(j),zero));
            }
        }

        body = assert_nature;

        for(int j = 0; j < dim; j++){
            Expr body_j = em.mkConst(new Rational(ls.getBase().get(j)));
            for(int i = 0; i < ls.getPeriod().size(); i++){
                body_j = em.mkExpr(Kind.PLUS,body_j,em.mkExpr(Kind.MULT,bound_vars.get(i).get(j),em.mkConst(new Rational(peroid_list.get(i).get(j)))));
            }
            body_j = em.mkExpr(Kind.EQUAL,body_j,em.mkConst(new Rational(target.get(j))));
            body = em.mkExpr(Kind.AND, body,body_j);
        }

        return smt.checkSat(body).toString().equals("sat");
    }


    public static Boolean checkSLEQ(Map<String,Set<LinearSet>> sls, Map<String,Set<LinearSet>> newSls) {
        for(String key:sls.keySet()){
            if(sls.get(key).size() == 0 && newSls.get(key).size() == 0)
                continue;
            if(sls.get(key).size()*newSls.get(key).size() == 0)
                return  false;
            if(checkSubset(sls.get(key),newSls.get(key)) && checkSubset(newSls.get(key),sls.get(key)))
                continue;
            return false;
        }
        return true;


    }

    // check if sl_this is subset of sl_that
    private static boolean checkSubset(Set<LinearSet> sl_this,  Set<LinearSet> sl_that) {

        for(LinearSet ls: sl_this){
            if(checkSubset_ls(ls,sl_that))
                continue;
            return false;
        }
        return true;
    }

    private static boolean checkSubset_ls(LinearSet ls, Set<LinearSet> sl_that) {
        System.loadLibrary("cvc4jni");
        ExprManager em = new ExprManager();
        SmtEngine smt = new SmtEngine(em);

        Type integer = em.integerType();

        Integer dim = ls.getBase().size();

        List<LinearSet> sl_that_list = new ArrayList<>(sl_that);

        Expr body = em.mkConst(false);
        Expr zero = em.mkConst(new Rational(0));
        Expr assert_nature = em.mkConst(true);

        for(int k = 0; k < sl_that_list.size(); k++){
            Expr body_k = em.mkConst(true);
            for(int i = 0; i < dim; i++){
                Expr body_i_left = em.mkConst(new Rational(ls.getBase().get(i)));
                Expr body_i_right = em.mkConst(new Rational(sl_that_list.get(k).getBase().get(i)));
                for(int jx = 0; jx < ls.getPeriod().size(); jx++){
                    // + x_i_j * p_j_i
                    body_i_left = em.mkExpr(Kind.PLUS,body_i_left, em.mkExpr(Kind.MULT,em.mkBoundVar("x_"+i+"_"+jx,integer), em.mkConst(new Rational(((Vector<Integer>)ls.getPeriod().toArray()[jx]).get(i)) )));
                    if(k == 0)
                        assert_nature = em.mkExpr(Kind.AND,assert_nature,em.mkExpr(Kind.GEQ,em.mkBoundVar("x_"+i+"_"+jx,integer),zero));
                }
                for(int jy = 0; jy < sl_that_list.get(k).getPeriod().size(); jy++){
                    // + y_i_j_k * p_k_j_i
                    body_i_right = em.mkExpr(Kind.PLUS,body_i_right, em.mkExpr(Kind.MULT,em.mkBoundVar("y_"+k+"_"+i+"_"+jy,integer),em.mkConst(new Rational(((Vector<Integer>)sl_that_list.get(k).getPeriod().toArray()[jy]).get(i)) )));
                    assert_nature = em.mkExpr(Kind.AND,assert_nature,em.mkExpr(Kind.GEQ,em.mkBoundVar("y_"+k+"_"+i+"_"+jy,integer),zero));
                }
                body_k = em.mkExpr(Kind.AND,body_k,em.mkExpr(Kind.EQUAL,body_i_left,body_i_right));
            }
            body = em.mkExpr(Kind.OR,body,body_k);
        }



        Expr q = em.mkExpr(Kind.AND,body,assert_nature);
        for(int k = 0; k < sl_that_list.size();k++){
            for(int i = 0; i < dim; i++){
                for(int j = 0; j < sl_that_list.get(k).getPeriod().size();j++){
                    q = em.mkExpr(Kind.EXISTS,em.mkExpr(Kind.BOUND_VAR_LIST,em.mkBoundVar("y_"+k+"_"+i+"_"+j,integer)),q);
                }
            }
        }

        for(int i = 0; i < dim; i++) {
            for (int j = 0; j < ls.getPeriod().size(); j++) {
                q = em.mkExpr(Kind.FORALL, em.mkExpr(Kind.BOUND_VAR_LIST, em.mkBoundVar("x_" + i + "_" + j, integer)), q);
            }
        }
        long startTime = System.nanoTime();
        //System.out.println("log: new checkSubset SMT begin");
        String out = smt.query(q).toString();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        //System.out.println("Execution time in milliseconds : " +
         //       timeElapsed / 1000000);
        return out.equals("valid");

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
               result.addAll(getBVSet_recursion(leftLS,rightLS,bop,remain,result,currentBv));

               if(result.size()==Math.pow(2,left.get(0).getBase().size()))
                   return result;
           }
       }
       return result;
        /*if(remain != 0){
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

        Expr body = em.mkConst(true);
        Expr body_x = em.mkConst(false);
        Expr body_y = em.mkConst(false);
        // body = true /\ (z = bx1 + x*px1 \/ z = bx2 + x*px2 \/ ...) /\ (z bop by1 + y*py1 \/ ..)
        //                        z \in left                                   z bop z' \in right

        List<Expr> boundx_list = new ArrayList<>();
        List<Expr> boundy_list = new ArrayList<>();

        Expr assertx = em.mkConst(true);
        Expr asserty = em.mkConst(true);
        for(int ix = 0; ix < left.size(); ix++  ){
            for(int d = 0; d < dim; d++){;
                for(int jx = 0; jx < left.get(ix).getPeriod().size(); jx++){
                    boundx_list.add(em.mkBoundVar("x_"+ix+"_"+jx+"_"+"d",integer));
                }
            }
        }

        for(int iy = 0; iy < right.size(); iy++  ){
            for(int d = 0; d < dim; d++){
                for(int jy = 0; jy < right.get(iy).getPeriod().size(); jy++){
                    boundy_list.add(em.mkBoundVar("y_"+iy+"_"+jy+"_"+"d",integer));
                }
            }
        }

        List<Expr> varz_list = new ArrayList<>();
        for(int i = 0; i <dim; i++){
            varz_list.add(em.mkVar("z_"+i,integer));
        }


        for(int ix = 0; ix < left.size(); ix++  ){
            Expr body_i = em.mkConst(true);
            for(int d = 0; d < dim; d++){
                Expr body_eqx = em.mkConst(new Rational(left.get(ix).getBase().get(d)));
                for(int jx = 0; jx < left.get(ix).getPeriod().size(); jx++){
                    assertx = em.mkExpr(Kind.AND,assertx,em.mkExpr(Kind.GEQ,access_boundVar(left,dim,ix,d,jx,boundx_list),em.mkConst(new Rational(0))));
                    body_eqx = em.mkExpr(Kind.PLUS,body_eqx,em.mkExpr(Kind.MULT,access_boundVar(left,dim,ix,d,jx,boundx_list),em.mkConst(new Rational(((Vector<Integer>)(left.get(ix).getPeriod().toArray()[jx])).get(d)))));
                }
                body_eqx = em.mkExpr(Kind.EQUAL,varz_list.get(d),body_eqx);
                body_i = em.mkExpr(Kind.AND,body_i,body_eqx);
            }
            body_x = em.mkExpr(Kind.OR,body_x,body_i);
        }

        for(int iy = 0; iy < right.size(); iy++  ){
            Expr body_i = em.mkConst(true);
            for(int d = 0; d < dim; d++){
                Expr body_eqy = em.mkConst(new Rational(right.get(iy).getBase().get(d)));
                for(int jy = 0; jy < right.get(iy).getPeriod().size(); jy++){
                    asserty = em.mkExpr(Kind.AND,asserty,em.mkExpr(Kind.GEQ,access_boundVar(right,dim,iy,d,jy,boundy_list),em.mkConst(new Rational(0))));
                    body_eqy = em.mkExpr(Kind.PLUS,body_eqy,em.mkExpr(Kind.MULT,access_boundVar(right,dim,iy,d,jy,boundy_list),em.mkConst(new Rational(((Vector<Integer>)(right.get(iy).getPeriod().toArray()[jy])).get(d)))));
                }
                body_eqy = em.mkExpr(parse_bop(bop),varz_list.get(d),body_eqy);
                if(!currentBv.get(d))
                    body_eqy = em.mkExpr(Kind.NOT,body_eqy);
                body_i = em.mkExpr(Kind.AND,body_i,body_eqy);
            }
            body_y = em.mkExpr(Kind.OR,body_y,body_i);
        }
        body = em.mkExpr(Kind.AND,body_x,body_y);
        body = em.mkExpr(Kind.AND,body,assertx);
        body = em.mkExpr(Kind.AND,body,asserty);
        for(int ix = 0; ix < left.size(); ix++  ){
            for(int d = 0; d < dim; d++){;
                for(int jx = 0; jx < left.get(ix).getPeriod().size(); jx++){
                    Expr bound_var_list = em.mkExpr(Kind.BOUND_VAR_LIST,access_boundVar(left,dim,ix,d,jx,boundx_list));
                    body =em.mkExpr(Kind.EXISTS,bound_var_list,body);
                }
            }
        }

        for(int iy = 0; iy < right.size(); iy++  ){
            for(int d = 0; d < dim; d++){
                for(int jy = 0; jy < right.get(iy).getPeriod().size(); jy++){
                    Expr bound_var_list = em.mkExpr(Kind.BOUND_VAR_LIST,access_boundVar(right,dim,iy,d,jy,boundy_list));
                    body = em.mkExpr(Kind.EXISTS,bound_var_list,body);
                }
            }
        }

        long startTime = System.nanoTime();
        System.out.println("log: new getBv SMT begin: "+currentBv);
        if(smt.checkSat(body).toString().equals("sat")) {
           // System.out.println("SAT: "+currentBv+" "+body);
            result.add(currentBv);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        return result;*/
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

        Expr body = em.mkConst(true);
        // body = true /\ (z = bx1 + x*px1 \/ z = bx2 + x*px2 \/ ...) /\ (z bop by1 + y*py1 \/ ..)
        //                        z \in left                                   z bop z' \in right

        List<List<Expr>> boundx_list = new ArrayList<>();
        List<List<Expr>> boundy_list = new ArrayList<>();

        Expr assertx = em.mkConst(true);
        Expr asserty = em.mkConst(true);
        Expr zero = em.mkConst(new Rational(0));

        List<Vector<Integer>> period_list_x = new ArrayList<>(left.getPeriod());
        List<Vector<Integer>> period_list_y = new ArrayList<>(right.getPeriod());

        for(int ix = 0; ix < left.getPeriod().size(); ix++  ){
            boundx_list.add(new ArrayList<>());

            for(int d = 0; d < dim; d++){;
                    boundx_list.get(ix).add(em.mkBoundVar("x_"+ix+"_"+"d",integer));
                    assertx = em.mkExpr(Kind.AND,assertx,em.mkExpr(Kind.GEQ,boundx_list.get(ix).get(d),zero));
            }
        }

        for(int iy = 0; iy < right.getPeriod().size(); iy++  ){
            boundy_list.add(new ArrayList<>());

            for(int d = 0; d < dim; d++){;
                boundy_list.get(iy).add(em.mkBoundVar("y_"+iy+"_"+"d",integer));
                asserty = em.mkExpr(Kind.AND,asserty,em.mkExpr(Kind.GEQ,boundy_list.get(iy).get(d),zero));
            }
        }

        for(int d = 0; d < dim; d++){
            Expr body_left = em.mkConst(new Rational(left.getBase().get(d)));
            Expr body_right = em.mkConst(new Rational(right.getBase().get(d)));
            for(int i = 0; i < period_list_x.size();i++){
                body_left = em.mkExpr(Kind.PLUS,body_left,em.mkExpr(Kind.MULT,boundx_list.get(i).get(d),em.mkConst(new Rational(period_list_x.get(i).get(d)))));
            }
            for(int i = 0; i < period_list_y.size();i++){
                body_right = em.mkExpr(Kind.PLUS,body_right,em.mkExpr(Kind.MULT,boundy_list.get(i).get(d),em.mkConst(new Rational(period_list_y.get(i).get(d)))));
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

    private static Expr access_boundVar(List<LinearSet> left, int dim, int i, int d, int j, List<Expr> boundx_list) {
        int count = 0;
        for(int ix = 0; ix < left.size(); ix++  ){
            if(ix != i) {
                count += dim*left.get(ix).getPeriod().size();
                continue;
            }
            for(int dx = 0; dx < dim; dx++){
                if(dx != d){
                    count += left.get(ix).getPeriod().size();
                    continue;
                }
                for(int jx = 0; jx < left.get(ix).getPeriod().size(); jx++){
                    if(jx!=j){
                        count += 1;
                        continue;
                    }
                    return boundx_list.get(count);
                }
            }
        }
        System.out.println("ERROR: index not exists");
        return null;
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

}
