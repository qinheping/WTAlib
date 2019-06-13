package utilities;

import semirings.LinearSet;

import java.util.*;

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


    public static String checkSLEQ(Map<String,Set<LinearSet>> sls, Map<String,Set<LinearSet>> newSls) {

        // TODO
        Integer dim = ((LinearSet)sls.values().iterator().next()).getBase().size();
        return null;

    }

}
