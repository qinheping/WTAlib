package utilities;

import semirings.LinearSet;

import java.util.*;

public  class ExpressionApplication {


    public static Set<LinearSet> ExpressionEval_SemilinearSet(Expression<Set<LinearSet>> exp, Map<String,Set<LinearSet>> assignment){
        switch (exp.type){
            case 0:
                return  exp.constant;
            case 1:
                return assignment.get(exp.var);

            case 2:
                return SemilinearFactory.dot(ExpressionEval_SemilinearSet(exp.left,assignment), ExpressionEval_SemilinearSet(exp.right,assignment));
            case 3:
                return SemilinearFactory.union(ExpressionEval_SemilinearSet(exp.left,assignment), ExpressionEval_SemilinearSet(exp.right,assignment));
        }
        System.out.println("ERROR: wrong type while ExpressionApplication_SemilinearSet "+exp.toString());
        return null;
    }

    public static Expression ExpressionApplication_SemilinearSet(Expression exp,  Map<String,Set<LinearSet>> assignment){
        Expression result = new Expression();
        switch (exp.type){
            case 0:
                return  exp;
            case 1:
                if(assignment.keySet().contains(exp.var)){

                    result.type = 0;
                    result.constant = assignment.get(exp.var);
                    return result;
                }
                return exp;
            case 2:
                result.type = 2;
                result.left = ExpressionApplication_SemilinearSet(exp.left,assignment);
                result.right = ExpressionApplication_SemilinearSet(exp.right,assignment);
                return result;
            case 3:
                result.type = 3;
                result.left = ExpressionApplication_SemilinearSet(exp.left,assignment);
                result.right = ExpressionApplication_SemilinearSet(exp.right,assignment);
                return result;
            case 4:
                result.type = 4;
                result.left = ExpressionApplication_SemilinearSet(exp.left,assignment);
                result.right = ExpressionApplication_SemilinearSet(exp.right,assignment);
                result.condition = ExpressionApplication_SemilinearSet(exp.condition,assignment);
                return result;
            case 5:
                result.type = 5;
                result.bop = exp.bop;
                result.left = ExpressionApplication_SemilinearSet(exp.left,assignment);
                result.right = ExpressionApplication_SemilinearSet(exp.right,assignment);
                return result;
            case 6:
                result.type = 6;
                result.bop = exp.bop;
                result.left = ExpressionApplication_SemilinearSet(exp.left,assignment);
                return result;
        }
        return null;
    }

    public static List<Equation> EquationEval_LinearSet(List<Equation> Eqs, Map<String,Vector<Integer>> map){
        List<Equation> result = new ArrayList<Equation>();
        for(Equation currentEq : Eqs){
            Equation toAdd = new Equation(currentEq.left, ExpressionApplication_LinearSet(currentEq.right,map));
            toAdd.type = currentEq.type;
            result.add(toAdd);
        }
        return  result;
    }


    public static Expression<Set<LinearSet>> ExpressionApplication_LinearSet(Expression<Integer> exp, Map<String,Vector<Integer>> map){
        int dim = map.values().iterator().next().size();
        Expression<Set<LinearSet>> result = new Expression();
        if(exp.type == 0){
            Vector<Integer> constVec = new Vector<>();
            for(int i = 0; i < dim; i++){
                constVec.add(exp.constant);
            }
            result.type = 0;
            result.constant = new HashSet<>();
            result.constant.add(new LinearSet(constVec));
            return result;
        }
        if(exp.type == 1){
            if(exp.var.substring(0,1).equals("-")){
                String var = exp.var.substring(1,exp.var.length());
                if(map.containsKey(var)){
                    result.type = 0;
                    result.constant = new HashSet<>();
                    Vector<Integer> toAdd = new Vector<>();
                    for(int i = 0; i < map.get(var).size(); i++){
                        toAdd.add(-map.get(var).get(i));
                    }
                    result.constant.add(new LinearSet(toAdd));
                    return  result;
                }
            }
            if(map.containsKey(exp.var)){
                result.type = 0;
                result.constant = new HashSet<>();
                result.constant.add(new LinearSet(map.get(exp.var)));
                return  result;
            }
            result.type = 1;
            result.var = exp.var;
            return result;
        }

        if(exp.type == 2 || exp.type == 3){
            result.type = exp.type;
            result.left = ExpressionApplication_LinearSet(exp.left,map);
            result.right = ExpressionApplication_LinearSet(exp.right,map);
            return  result;
        }

        if(exp.type == 4){
            result.type = 4;
            result.condition = ExpressionApplication_LinearSet(exp.condition,map);
            result.left = ExpressionApplication_LinearSet(exp.left,map);
            result.right = ExpressionApplication_LinearSet(exp.right,map);
            return  result;
        }

        if(exp.type == 5){
            result.type = 5;
            result.bop = exp.bop;
            result.left = ExpressionApplication_LinearSet(exp.left,map);
            result.right = ExpressionApplication_LinearSet(exp.right,map);
            return  result;
        }
        if(exp.type == 6){
            result.type = 6;
            result.bop = exp.bop;
            result.left = ExpressionApplication_LinearSet(exp.left,map);
            return  result;
        }
        System.out.println("Error: invalid type: "+result.type.toString() );
        return  null;
    }

    private static int count = 0;

    public static List<Equation> EquationSubstIte(List<Equation> valEqs, List<Set<LinearSet>> dicIteSl) {
        List<Equation> result = new ArrayList<>();
        count = 0;
        for(Equation currecntEq : valEqs){
            if(currecntEq.type == 0)
                continue;
            Equation toAdd = new Equation(currecntEq.left,ExpressionSubstIte(currecntEq.right,dicIteSl));
            toAdd.type = currecntEq.type;
            result.add(toAdd);
        }
        return  result;
    }

    public static Expression ExpressionSubstIte(Expression<Set<LinearSet>> exp, List<Set<LinearSet>> dicIteSl){
        Expression<Set<LinearSet>> result = new Expression();
        switch (exp.type){
            case 0:
            case 5:
            case 6:
            case 1: return exp;
            case 2:
            case 3:
                result.type = exp.type;
                result.left = ExpressionSubstIte(exp.left,dicIteSl);
                result.right = ExpressionSubstIte(exp.right,dicIteSl);
                return result;
            case 4:
                result.type = 0;
                result.constant = dicIteSl.get(count);
                count ++;
                return result;

        }
        return  null;
    }

    public static Expression ExpressionApplication_BVSet(Expression exp, Map<String, Set<Vector<Boolean>>> currentBV) {
        Expression result = new Expression();
        switch (exp.type){
            case 0:
                return  exp;
            case 1:
                if(currentBV.keySet().contains(exp.var)){

                    result.type = 0;
                    result.constant = currentBV.get(exp.var);
                    return result;
                }
                return exp;
            case 2:
                result.type = 2;
                result.left = ExpressionApplication_BVSet(exp.left,currentBV);
                result.right = ExpressionApplication_BVSet(exp.right,currentBV);
                return result;
            case 3:
                result.type = 3;
                result.left = ExpressionApplication_BVSet(exp.left,currentBV);
                result.right = ExpressionApplication_BVSet(exp.right,currentBV);
                return result;
            case 4:
                result.type = 4;
                result.left = ExpressionApplication_BVSet(exp.left,currentBV);
                result.right = ExpressionApplication_BVSet(exp.right,currentBV);
                result.condition = ExpressionApplication_BVSet(exp.condition,currentBV);
                return result;
            case 5:
                result.type = 5;
                result.bop = exp.bop;
                result.left = ExpressionApplication_BVSet(exp.left,currentBV);
                result.right = ExpressionApplication_BVSet(exp.right,currentBV);
                return result;
            case 6:
                result.type = 6;
                result.bop = exp.bop;
                result.left = ExpressionApplication_BVSet(exp.left,currentBV);
                return result;
        }
        return null;
    }
}
