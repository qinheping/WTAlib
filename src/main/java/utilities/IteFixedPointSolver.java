package utilities;

import semirings.LinearSet;

import java.util.*;

public class IteFixedPointSolver {
    public static int  iteCount = 0;
    public static Map<String,Set<LinearSet>> SolveIteFixedPoint(List<Equation> termEqs, Map<String,Vector<Integer>> map){
        int stage = 0;
        int dim = map.values().iterator().next().size();
        List<Set<LinearSet>> dicIteSl = new ArrayList<>();
        List<Equation> valEqs = ExpressionApplication.EquationApplication_LinearSet(termEqs,map);
        // # of ite in arithmetic non-terminal
        iteCount = getIteCount(termEqs);
        List<String> boolNames = new ArrayList<>();
        for(int i = 0; i < valEqs.size(); i++){
            if(valEqs.get(i).type == 0)
                boolNames.add(valEqs.get(i).left);
        }
        for(int i = 0; i <iteCount; i++){
            dicIteSl.add(SemilinearFactory.getEmpty());
        }

        Map<Integer, Map<String,Set<LinearSet>>> solutionStore = new HashMap<>();
        Map<Integer, Map<String,Set<Vector<Boolean>>>> bvStore = new HashMap<>();
        Map<String,Set<Vector<Boolean>>> initBV = new HashMap<>();
        for(String boolName: boolNames){
            initBV.put(boolName,new HashSet<>());
        }
        bvStore.put(0,initBV);
        //valEqs.forEach(System.out::println);

        // start solving fixed point
        while(true){
            System.out.println("Stage: "+stage);
            // substitute ite in eqs by previous solution
            List<Equation> valEqsNoIte = ExpressionApplication.EquationSubstIte(valEqs,dicIteSl);
            System.out.println("\tIte substituted");
            //valEqsNoIte.forEach(System.out::println);

            // solving linear eqs by newton method
            Map<String,Set<LinearSet>> currentSolution = Newton.SolveSlEq(valEqsNoIte,(map.values().iterator().next()).size());
            System.out.println("\tnew solution got");
            solutionStore.put(stage,currentSolution);

            // get the new bv map with new solution
            Map<String,Set<Vector<Boolean>>> currentBV = BVSolver.SolveBV(dim,valEqs,currentSolution, bvStore.get(stage));
            System.out.println(currentBV); System.out.println(bvStore.get(stage));
            if(checkBVFixedPoint(currentBV,bvStore.get(stage))){
                // fixed point reached
                return currentSolution;
            }
            stage++;
            bvStore.put(stage,currentBV);
            dicIteSl = EvalIte(valEqs,currentBV,currentSolution);
            for(String var: currentSolution.keySet()){
                System.out.println(var+" "+currentSolution.get(var).size());
            }
            for(int i = 0; i < dicIteSl.size(); i++){
                System.out.println(dicIteSl.get(i).size());
            }


            // TODO check if the current solution reach a fixed point
        }
    }
    private static int count = 0;

    public static List<Set<LinearSet>>  EvalIte(List<Equation> valEqs, Map<String,Set<Vector<Boolean>>> bvSet, Map<String,Set<LinearSet>> assignment) {
        List<Set<LinearSet>> result = new ArrayList<>();
        count = 0;
        for(Equation currecntEq : valEqs){
            if(currecntEq.type == 0)
                continue;
            result.addAll(ExpressionEvalIte(currecntEq.right,bvSet,assignment));
        }
        return  result;
    }

    public static List<Set<LinearSet>> ExpressionEvalIte(Expression exp,  Map<String,Set<Vector<Boolean>>> bvSet, Map<String,Set<LinearSet>> assignment){

        List<Set<LinearSet>> result = new ArrayList<>();
        switch (exp.type){
            case 0:
            case 5:
            case 6:
            case 1:
                return result;
            case 2:
            case 3:
                result.addAll(ExpressionEvalIte(exp.left,bvSet,assignment));
                result.addAll(ExpressionEvalIte(exp.right,bvSet,assignment));
                return result;
            case 4:
                result.add(projection_sls_vs(assignment.get(exp.left.var),assignment.get(exp.right.var),bvSet.get(exp.condition.var)));
                count ++;
                return result;

        }
        return  null;
    }

    private static boolean checkBVFixedPoint(Map<String, Set<Vector<Boolean>>> currentBV, Map<String, Set<Vector<Boolean>>> previousBV) {
        for(String bvar:currentBV.keySet()){
            if(!currentBV.get(bvar).equals(previousBV.get(bvar)))
                return false;
        }
        return true;
    }

    // count ite only for eq with type int
    private static int getIteCount(List<Equation> termEqs) {
        int result = 0;
        for(Equation currectEq: termEqs){
            result += getIteCountInExp(currectEq.getRight());
        }
        return result;
    }


    private static Set<LinearSet> projection_sls_vs (Set<LinearSet> sl_T,Set<LinearSet> sl_F, Set<Vector<Boolean>> bvSet){
        Set<LinearSet> result_T = projection_sl_vs(sl_T,bvSet);
        Set<LinearSet> result_F = projection_sl_vs(sl_F,flip(bvSet));
        return  SemilinearFactory.dot(result_T,result_F);
    }

    private static Set<Vector<Boolean>> flip(Set<Vector<Boolean>> bvSet) {
        Set<Vector<Boolean>> result = new HashSet<>();
        int dim;
        for(Vector<Boolean> bv: bvSet){
            dim = bv.size();
            Vector<Boolean> newBv = new Vector<>();
            for(int i = 0; i < dim; i++){
                newBv.add(!bv.get(i));
            }
            result.add(newBv);
        }
        return result;
    }

    private static Set<LinearSet> projection_sl_vs(Set<LinearSet> sl_f, Set<Vector<Boolean>> bvSet) {
        Set<LinearSet> result = new HashSet<>();
        for(Vector bv: bvSet){
            result = SemilinearFactory.union(result,projection_sl_vector(sl_f,bv));
        }
        return result;
    }

    private static Set<LinearSet> projection_sl_vector (Set<LinearSet> sl, Vector<Boolean> bv){
        Set<LinearSet> result = new HashSet<>();
        for(LinearSet ls:sl){
            result.add(projection_ls_vector(ls,bv));
        }
        return  result;
    }

    private static LinearSet projection_ls_vector(LinearSet ls, Vector<Boolean> bv) {
        Vector<Integer> base = new Vector<>();
        Set<Vector<Integer>> peroid = new HashSet<>();
        int dim = bv.size();
        for(int i = 0; i < dim; i++){
            if(bv.get(i))
                base.add(ls.getBase().get(i));
            else
                base.add(0);
        }
        for(Vector<Integer> pv:ls.getPeriod()){
            Vector<Integer> newPv = new Vector<>();
            for(int i = 0; i < dim; i++){
                if(bv.get(i))
                    newPv.add(pv.get(i));
                else
                    newPv.add(0);
            }
        }
        LinearSet result = new LinearSet(base,peroid);
        return  result;

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
