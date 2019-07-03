package utilities;

import prover.Pair;
import semirings.LinearSet;

import java.util.*;
import java.util.List;

public class IteFixedPointSolver {
    public static int  iteCount = 0;
    public static Map<String,Set<LinearSet>> SolveIteFixedPoint(List<Equation> termEqs, Map<String,Vector<Integer>> map){
        Map<String,Set<LinearSet>> finalSolution = new HashMap<>();
        int dim = map.values().iterator().next().size();
        List<Equation> oriValEqs = ExpressionApplication.EquationEval_LinearSet(termEqs,map);
        DAG dag = new DAG(oriValEqs);
        Set<String> currentEq = dag.popRoot();
        while(currentEq!=null) {

            //System.out.println("current EQ: "+ currentEq);
            List<Equation> valEqs = new ArrayList<>();
            // map from eq to var set appearing in the rhs
            Map<String, Set<String>> rhs_var_set = new HashMap<>();
            int stage = 0;
            for (Equation oriEq : oriValEqs) {
                if (currentEq.contains(oriEq.left))
                    valEqs.add(oriEq);
            }

            List<Set<LinearSet>> dicIteSl = new ArrayList<>();
            for (Equation eq : valEqs) {
                if (eq.type == 1)
                    rhs_var_set.put(eq.left, find_expr_vars(eq.right));
            }
            //System.out.println(rhs_var_set);

            // # of ite in arithmetic non-terminal
            iteCount = getIteCount(termEqs);
            List<String> boolNames = new ArrayList<>();
            for (int i = 0; i < valEqs.size(); i++) {
                if (valEqs.get(i).type == 0)
                    boolNames.add(valEqs.get(i).left);
            }
            for (int i = 0; i < iteCount; i++) {
                dicIteSl.add(SemilinearFactory.getEmpty());
            }

            Map<Integer, Map<String, Set<LinearSet>>> solutionStore = new HashMap<>();
            Map<Integer, Map<String, Set<Vector<Boolean>>>> bvStore = new HashMap<>();
            Map<String, Set<Vector<Boolean>>> initBV = new HashMap<>();
            for (String boolName : boolNames) {
                initBV.put(boolName, new HashSet<>());
            }
            bvStore.put(0, initBV);
            //valEqs.forEach(System.out::println);

            // start solving fixed point
            while (true) {
                //System.out.println("Stage: " + stage);

                for(Equation eq:valEqs){
                    eq.right = ExpressionEvalIte(eq.right);
                }
                // substitute ite in eqs by previous solution
                List<Equation> valEqsNoIte = ExpressionApplication.EquationSubstIte(valEqs, dicIteSl);

                //System.out.println("\tIte substituted");
                //valEqsNoIte.forEach(System.out::println);

                // solving linear eqs by newton method
                Map<String, Set<LinearSet>> currentSolution = Newton.SolveSlEq(valEqsNoIte, (map.values().iterator().next()).size(), rhs_var_set);
                //System.out.print("\tnew solution got: ");


                for(String nt:currentSolution.keySet()){
                    //System.out.print(nt+" "+currentSolution.get(nt).size()+" ");

                }
                //System.out.print("\n");
                solutionStore.put(stage, currentSolution);
                //System.out.println(currentSolution);

                // get the new bv map with new solution
                Map<String, Set<Vector<Boolean>>> currentBV = BVSolver.SolveBV(dim, valEqs, currentSolution, bvStore.get(stage));
                //System.out.println(currentBV);
                if (checkBVFixedPoint(currentBV, bvStore.get(stage))) {
                    //System.out.print("BV fixedpoint reached, return current solution: ");
                    //System.out.println("\nDot count in this eq iteration: "+SemilinearFactory.dotCount);
                    // fixed point reached
                    for (Equation oriEq : oriValEqs) {
                        oriEq.right = ExpressionApplication.ExpressionApplication_SemilinearSet(oriEq.right, currentSolution);
                        oriEq.right = ExpressionApplication.ExpressionApplication_BVSet(oriEq.right, currentBV);
                    }
                    finalSolution = currentSolution;
                    break;
                }
                stage++;
                bvStore.put(stage, currentBV);


                long startTime = System.nanoTime();
                dicIteSl = EvalIte(valEqs, currentBV, currentSolution);

                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;

                //System.out.println("dicITESl: Execution time in milliseconds: "+            timeElapsed / 1000000);
                //for (Set<LinearSet> list : dicIteSl) {
                 //   System.out.print(list.size() +"  ");
                //}


                // TODO check if the current solution reach a fixed point
            }

            currentEq = dag.popRoot();
        }
        return finalSolution;
    }

    private static List<Equation> expandIte(List<Equation> oriEqs){
        for(Equation eq: oriEqs){

        }
    }
    private static Pair<Set<Pair<String,Vector<Boolean>>>,Expression> expandIte(Expression exp){
        Expression resultExpr = new Expression();
        Set<Pair<String,Vector<Boolean>>> resultSet = new HashSet<>();
        Pair<Set<Pair<String,Vector<Boolean>>>,Expression> tmpLeft;
        Pair<Set<Pair<String,Vector<Boolean>>>,Expression> tmpRight;
        switch (exp.type){
            case 0:
            case 1:
                resultExpr = exp;
                break;
            case 2:
            case 3:
                resultExpr.type = exp.type;
                tmpLeft = expandIte(exp.left);
                tmpRight = expandIte(exp.right);
                resultExpr.left = tmpLeft.second;
                resultExpr.right = tmpRight.second;
                resultSet.addAll(tmpLeft.first);
                resultSet.addAll(tmpRight.first);
                break;
            case 4:
                resultSet.add(new Pair(exp.left.var,exp.condition.constant));
                resultSet.add(new Pair(exp.right.var,flip((Set<Vector<Boolean>>)exp.condition.constant)));
                resultExpr = constructSum(exp.left.var,exp.right.var,(Set<Vector<Boolean>>)exp.condition.constant);

        }
        Pair<Set<Pair<String,Vector<Boolean>>>,Expression> result = new Pair(resultSet,resultExpr);
        return result;
    }

    private static Expression constructSum(String left, String right, Set<Vector<Boolean>> bvSet) {
        Expression result = new Expression();
        if(bvSet.size() == 1){
            result.type = 2;
            result.left = new Expression();
            result.left.type = 1;
            result.left.var = left + toBitString(bvSet.iterator().next());
            result.right = new Expression();
            result.right.type = 1;
            result.right.var = right + toBitString(bvSet.iterator().next());
            return  result;
        }

        result.type = 3;
        Iterator<Vector<Boolean>> iterator = bvSet.iterator();
        Vector<Boolean> bv = iterator.next();
        iterator.remove();
        result.right = constructSum(left, right, bvSet);

        Expression leftExpr = new Expression();
        leftExpr.type = 2;
        leftExpr.left = new Expression();
        leftExpr.left.type = 1;
        leftExpr.left.var = left + toBitString(bv);
        leftExpr.right = new Expression();
        leftExpr.right.type = 1;
        leftExpr.right.var = right + toBitString(bv);
        result.left = leftExpr;
        return result;
    }

    private static String toBitString(Vector<Boolean> bv){
        String result = "";
        for(Boolean b:bv){
            if (b)
                result += "1";
            else
                result += "0";
        }
        return result;
    }

    private static Set<String> find_expr_vars(Expression expr) {
        Set<String> result = new HashSet<>();
        switch (expr.type){
            case 0:
                return result;
            case 1:
                result.add(expr.var);
                return result;
            case 2:
            case 3:
                result.addAll(find_expr_vars(expr.left));
                result.addAll(find_expr_vars(expr.right));

        }
        return result;

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
    public static Expression ExpressionEvalIte(Expression exp){

        Expression result = new Expression();
        switch (exp.type){
            case 0:
            case 5:
            case 6:
            case 1:
                return exp;
            case 2:
            case 3:
                result.type = exp.type;
                result.left = (ExpressionEvalIte(exp.left));
                result.right = (ExpressionEvalIte(exp.right));
                return result;
            case 4:
                if(exp.condition.type != 0 || exp.left.type!=0 || exp.right.type!=0)return exp;
                result.type = 0;
                result.constant = projection_sls_vs((Set<LinearSet>)exp.left.constant,(Set<LinearSet>)exp.right.constant,(Set<Vector<Boolean>>)exp.condition.constant);
                return result;

        }
        return  null;
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
                if(exp.condition.type == 1)
                    result.add(projection_sls_vs(ExpressionApplication.ExpressionEval_SemilinearSet(exp.left,assignment),ExpressionApplication.ExpressionEval_SemilinearSet(exp.right,assignment),bvSet.get(exp.condition.var)));
                else
                    result.add(projection_sls_vs(ExpressionApplication.ExpressionEval_SemilinearSet(exp.left,assignment),ExpressionApplication.ExpressionEval_SemilinearSet(exp.right,assignment),(Set<Vector<Boolean>>)exp.condition.constant));

                count ++;
                return result;

        }
        return  null;
    }

    private static boolean checkBVFixedPoint(Map<String, Set<Vector<Boolean>>> currentBV, Map<String, Set<Vector<Boolean>>> previousBV) {
        for(String var:currentBV.keySet()){
            if(!currentBV.get(var).equals(previousBV.get(var)))
                return  false;
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
        Set<LinearSet> result = new HashSet<>();
        for(Vector<Boolean> bv: bvSet) {
            Set<LinearSet> result_T = projection_sl_vector(sl_T, bv);
            Set<LinearSet> result_F = projection_sl_vector(sl_F, flip(bv));
            result.addAll(SemilinearFactory.dot(result_T, result_F));
        }
        return  result;
    }


    private static Set<Vector<Boolean>> flip(Set<Vector<Boolean>> bvSet) {
        Set<Vector<Boolean>> result = new HashSet<>();
        for(Vector<Boolean> bv: bvSet){
            result.add(flip(bv));
        }
        return result;
    }

    private static Vector<Boolean> flip(Vector<Boolean> bv) {

        int dim = bv.size();
            Vector<Boolean> newBv = new Vector<>();
            for(int i = 0; i < dim; i++){
                newBv.add(!bv.get(i));
            }
        return newBv;
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
