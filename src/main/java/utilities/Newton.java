package utilities;

import semirings.LinearSet;

import javax.sound.sampled.Line;
import java.util.*;

public class Newton {

    public static Map<String, Set<LinearSet>> SolveSlEq(List<Equation> SlEqs, int dim){
        int varCount = SlEqs.size();
        List<String> varList = getVarList(SlEqs);
        List<Expression> diffList = getDiffListFromEqs(SlEqs, dim);
        //SlEqs.forEach(System.out::println);
        //System.out.println("diff");
        System.out.println(varList);        diffList.forEach(System.out::println);

        Map<String, Set<LinearSet>> result = new HashMap<>();
        // initialize result
        for(String var: varList){
            result.put(var,new HashSet<>());
        }
        Map<String, Set<LinearSet>> tmp_result = new HashMap<>();
        for(int i = 0; i < varList.size(); i++){
            tmp_result.put(varList.get(i),ExpressionApplication.ExpresionApplication_SemilinearSet(SlEqs.get(i).right,result));
        }
        result = tmp_result;
        System.out.println("result:" +result);

        for(int k = 0; k < varCount; k++){
            Map<String,Set<LinearSet>> newResult = new HashMap<>();
            for(int i = 0; i < varCount; i++){
                // f'(vi)
                Set<LinearSet> SL_diff_i = ExpressionApplication.ExpresionApplication_SemilinearSet(diffList.get(i),result);
                //System.out.println(varList.get(i)+" diff: "+SL_diff_i);
                Set<LinearSet> Sl_diff_i_star = SemilinearFactory.star(SL_diff_i,dim);
                //System.out.println("star: "+SL_diff_i);
                // f(vi)
                Set<LinearSet> SL_exp_i = ExpressionApplication.ExpresionApplication_SemilinearSet(SlEqs.get(i).right,result);
                //System.out.println("f: "+SL_diff_i);
                // (f'(vi))^**f(vi)
                newResult.put(varList.get(i),SemilinearFactory.dot(Sl_diff_i_star,SL_exp_i));
            }
            //if(checkEquality_SLs(result,newResult)){
             //   System.out.println(result);
             //   System.out.println(newResult);
             //   break;
           // }
            result = newResult;
        }
        return  result;
    }

    private static boolean checkEquality_SLs(Map<String,Set<LinearSet>> Sls, Map<String,Set<LinearSet>> newSls) {

        if(Sls.size() == 0 && newSls.size() == 0)
            return  true;
        if(Sls.size() *newSls.size()==0)
            return  false;
        return SMTQGenerator.checkSLEQ(Sls,newSls);

    }


    private static List<Expression> getDiffListFromEqs(List<Equation> SlEqs, int dim){
        int varCount = SlEqs.size();
        List<String> varList = getVarList(SlEqs);
        List<Expression> result = new ArrayList<>();
        for(int i = 0; i < varCount; i++){
            Expression currentExpr = SlEqs.get(i).right;
            String currentVar = varList.get(i);
                // currentDiff = D_{currentVar}(currentExpr)
            Expression currentDiff = Differential(currentExpr,currentVar,dim);


            result.add(currentDiff);
        }
        return  result;

    }

    private static List<String> getVarList(List<Equation> SlEqs){
        List<String> result = new ArrayList<>();
        for(Equation eq : SlEqs){
            result.add(eq.left);
        }
        return result;
    }

    public static Map<String,Set<LinearSet>> SolveSimpleSlEq(List<Equation> SlEqs){
        int varCount = SlEqs.size();
        Map<String,Set<LinearSet>> result = new HashMap<>();
        while(result.size() < varCount){
            for(Equation currentEq: SlEqs){
                if(result.keySet().contains(currentEq.left))
                    continue;
                Set<LinearSet> currentSolution = SolveSimpleEq(currentEq,result);
                if(currentSolution!= null){
                    result.put(currentEq.left,currentSolution);
                }

            }
        }
        return result;
    }

    private static Set<LinearSet> SolveSimpleEq(Equation currentEq, Map<String, Set<LinearSet>> assignment) {
        Set<LinearSet> solution = evalExpression(currentEq.right,assignment);
        return solution;
    }

    private static Set<LinearSet> evalExpression(Expression<Set<LinearSet>> exp, Map<String, Set<LinearSet>> assignment) {
        Set<LinearSet> left;
        Set<LinearSet> right;
        switch (exp.type){
            case 0: return exp.constant;
            case 1:
                if (assignment.containsKey(exp.var)){
                    return assignment.get(exp.var);
                }
                return  null;
            case 2:
                left =  evalExpression(exp.left,assignment);
                right =  evalExpression(exp.right,assignment);
                if(left == null || right == null)
                    return null;
                return SemilinearFactory.dot(left,right);
            case 3:
                left =  evalExpression(exp.left,assignment);
                right =  evalExpression(exp.right,assignment);
                if(left == null || right == null)
                    return null;
                return SemilinearFactory.union(left,right);
        }
        System.out.println("ERROR: wrong expression type: "+exp.type.toString());
        return  null;
    }

    private static Expression<Set<LinearSet>> Differential(Expression<Set<LinearSet>> e, String dx, int dim){
        Expression result = new Expression();
        switch (e.type){
            case 0:
                result.type = 0;
                result.constant = new HashSet<>();
                return result;
            case 1:
                result.type = 0;
                HashSet constSL = new HashSet();
                if(e.var.equals(dx)){
                    constSL.add(new LinearSet(0,dim));
                    result.constant = constSL;
                    return result;
                }
                result.constant = constSL;
                return result;
            case 2:
                // (L*R)' = L'*R + L*R'
                result.type = 3;
                result.left = new Expression();
                result.left.type = 2;
                result.left.left = Differential(e.left,dx,dim);
                result.left.right = e.right;
                result.right = new Expression();
                result.right.type = 2;
                result.right.left = e.left;
                result.right.right =  Differential(e.right,dx,dim);
                return result;
            case 3:
                // (L+R)' = L' + R'
                result.type = 3;
                result.left = Differential(e.left,dx,dim);
                result.right = Differential(e.right,dx,dim);
                return  result;
        }
        System.out.println("ERROR: wrong type while compute differential of "+ e.toString());
        return null;
    }
}
