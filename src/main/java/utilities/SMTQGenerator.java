package utilities;

import semirings.LinearSet;

import java.lang.Integer;
import java.util.*;
import edu.nyu.acsys.CVC4.*;


import com.microsoft.z3.*;
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

        Integer dim = ((LinearSet)sls.values().iterator().next()).getBase().size();
    }

}
