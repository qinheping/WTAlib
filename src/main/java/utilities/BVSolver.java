package utilities;

import semirings.LinearSet;

import java.util.*;

public class BVSolver {
    public static Map<String,Set<Vector<Boolean>>> SolveBV(List<Equation> eqs, Map<String,Set<LinearSet>> assignment){
        Map<String,Set<Vector<Boolean>>> result = new HashMap<>();
        List<String> bvars = getBVars(eqs);
        for(String bvar:bvars){
            result.putIfAbsent(bvar,new HashSet<>());
        }

        while(true){

            for()
        }
        return null;
    }

    private  static List<String> getBVars (List<Equation> eqs){
        List<String> result = new ArrayList<>();
        for(Equation eq:eqs){
            if(eq.type == 0){
                result.add(eq.left);
            }
        }
        return result;
    }
}
