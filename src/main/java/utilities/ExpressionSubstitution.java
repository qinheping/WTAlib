package utilities;

import semirings.LinearSet;

import java.util.*;

public  class ExpressionSubstitution {

    public static List<Equation> EquationSubst(List<Equation> Eqs, Map<String,Vector<Integer>> map){
        List<Equation> result = new ArrayList<Equation>();
        for(Equation currecntEq : Eqs){
            Equation toAdd = new Equation(currecntEq.left,ExpressionSubst(currecntEq.right,map));
            toAdd.type = currecntEq.type;
            result.add(toAdd);
        }
        return  result;
    }
    public static Expression<Set<LinearSet>> ExpressionSubst(Expression<Integer> exp, Map<String,Vector<Integer>> map){
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
            result.left = ExpressionSubst(exp.left,map);
            result.right = ExpressionSubst(exp.right,map);
            return  result;
        }

        if(exp.type == 4){
            result.type = 4;
            result.condition = ExpressionSubst(exp.condition,map);
            result.left = ExpressionSubst(exp.left,map);
            result.right = ExpressionSubst(exp.right,map);
            return  result;
        }

        if(exp.type == 5){
            result.type = 5;
            result.bop = exp.bop;
            result.left = ExpressionSubst(exp.left,map);
            result.right = ExpressionSubst(exp.right,map);
            return  result;
        }
        if(exp.type == 6){
            result.type = 6;
            result.bop = exp.bop;
            result.left = ExpressionSubst(exp.left,map);
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

    public static Expression ExpressionSubstIte(Expression exp, List<Set<LinearSet>> dicIteSl){
        Expression result = new Expression();
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
}
