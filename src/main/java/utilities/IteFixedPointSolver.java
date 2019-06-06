package utilities;

import semirings.LinearSet;

import java.util.*;

public class IteFixedPointSolver {
    public static int  iteCount = 0;
    public static Map<String,Set<LinearSet>> SolveIteFixedPoint(List<Equation> termEqs, Map<String,Vector<Integer>> map){
        int stage = 0;
        List<Set<LinearSet>> dicIteSl = new ArrayList<>();
        List<Equation> valEqs = ExpressionSubstitution.EquationSubst(termEqs,map);
        iteCount = getIteCount(termEqs);
        Map<Integer, Map<String,Set<LinearSet>>> solutionStore = new HashMap<>();

        while(true){
            List<Equation> valEqsNoIte = ExpressionSubstitution.EquationSubstIte(valEqs,dicIteSl);
        }
        return null;
    }

    // count ite only for eq with type int
    private static int getIteCount(List<Equation> termEqs) {
        int result = 0;
        for(Equation currectEq: termEqs){
            result += getIteCountInExp(currectEq.getRight());
        }
        return result;
    }

    private static int getIteCountInExp(Expression exp) {
        switch (exp.type) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
            case 3:
                return getIteCountInExp(exp.left) + getIteCountInExp(exp.right);
            case 4:
                return 1;
            case 5:
                return 0;
            case 6:
                return 0;
        }
        return 0;
    }
}
