package utilities;

import edu.nyu.acsys.CVC4.Expr;
import semirings.LinearSet;

import java.lang.Integer;
import java.util.*;
import edu.nyu.acsys.CVC4.*;


public class SMTQGenerator {
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

        List<Expr> bvars_forall = new ArrayList<>();
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < ls.getPeriod().size(); j++){
                bvars_forall.add(em.mkBoundVar("x_"+i+"_"+j,integer));
            }
        }

        List<LinearSet> sl_that_list = new ArrayList<>(sl_that);
        List<Expr> bvars_exists = new ArrayList<>();
        for(int k = 0; k < sl_that_list.size();k++){
            for(int i = 0; i < dim; i++){
                for(int j = 0; j < sl_that_list.get(k).getPeriod().size();j++){
                    bvars_exists.add(em.mkBoundVar("y_"+k+"_"+i+"_"+j,integer));
                }
            }
        }

        Expr body = em.mkConst(true);
        for(int k = 0; k < sl_that_list.size(); k++){
            Expr body_k = em.mkConst(true);
            for(int i = 0; i < dim; i++){
                Expr body_i_left = em.mkConst(new Rational(ls.getBase().get(i)));
                Expr body_i_right = em.mkConst(new Rational(sl_that_list.get(k).getBase().get(i)));
                for(int jx = 0; jx < ls.getPeriod().size(); jx++){
                    body_i_left = em.mkExpr(Kind.PLUS,body_i_left, em.mkExpr(Kind.MULT,bvars_forall.get(jx), em.mkConst(new Rational(((Vector<Integer>)ls.getPeriod().toArray()[jx]).get(i)) )));
                }
                for(int jy = 0; jy < sl_that_list.get(k).getPeriod().size(); jy++){
                    body_i_right = em.mkExpr(Kind.PLUS,body_i_right, em.mkExpr(Kind.MULT,bvars_exists.get(jy),em.mkConst(new Rational(((Vector<Integer>)sl_that_list.get(k).getPeriod().toArray()[jy]).get(i)) )));
                }
                body_k = em.mkExpr(Kind.AND,body_k,em.mkExpr(Kind.EQUAL,body_i_left,body_i_right));
            }
            body = em.mkExpr(Kind.OR,body,body_k);
        }

        Expr q = body;
        for(int k = 0; k < sl_that_list.size();k++){
            for(int i = 0; i < dim; i++){
                for(int j = 0; j < sl_that_list.get(k).getPeriod().size();j++){
                    q = em.mkExpr(Kind.EXISTS,em.mkExpr(Kind.BOUND_VAR_LIST,em.mkBoundVar("y_"+k+"_"+i+"_"+j,integer)),q);
                }
            }
        }

        for(int i = 0; i < dim; i++){
            for(int j = 0; j < ls.getPeriod().size(); j++){
                q = em.mkExpr(Kind.FORALL,em.mkExpr(Kind.BOUND_VAR_LIST,em.mkBoundVar("x_"+i+"_"+j,integer)),q);
            }
        }
        return smt.query(q).toString().equals("valid");

    }

}
