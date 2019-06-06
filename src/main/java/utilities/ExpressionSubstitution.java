package utilities;

import java.util.Map;
import java.util.Vector;

public  class ExpressionSubstitution {
    public static Expression<Vector<Integer>> ExpressionSubst(Expression<Integer> exp, Map<String,Vector<Integer>> map){
        int dim = map.values().iterator().next().size();
        Expression<Vector<Integer>> result = new Expression();
        if(exp.type == 0){
            Vector<Integer> constVec = new Vector<>();
            for(int i = 0; i < dim; i++){
                constVec.add(exp.constant);
            }
            result.type = 0;
            result.constant =constVec;
            return result;
        }
        if(exp.type == 1){
            if(map.containsKey(exp.var)){
                result.type = 0;
                result.constant = map.get(exp.var);
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

        //TODO: type 4 5 6

    }
}
