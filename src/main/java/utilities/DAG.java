package utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAG {

    private Set<DAGNode> roots;
    public Set<DAGNode> getRoots() {
        return roots;
    }

    public void setRoots(Set<DAGNode> roots) {
        this.roots = roots;
    }

    // -------------------------------
    // -------------------------------
    // -------------------------------

    public class DAGNode{
        private List<DAGNode> successors;
        private Set<Set<String>> reched_str;
        private Set<String> value;
    }

    // -------------------------------
    // -------------------------------
    // -------------------------------


    public void addNode(DAGNode newNode){
        // check if dag is empty
        if(this.roots.size() == 0){
            this.roots.add(newNode);
            return;
        }

        // check if
    }

    public DAG(List<Equation> eqs){
        DAGNode newRoot = new DAGNode();
        this.roots = new HashSet<>();
        for(Equation eq: eqs){
            new
        }
    }

    Set<String> getReachedInExpression(Expression exp){
        Set<String> result = new HashSet<>();
        switch (exp.type){
            case 0: return  result;
            case 1: result.add(exp.var);
                return result;
            case 2:
            case 3:
            case 5:
                result.addAll(getReachedInExpression(exp.left));
                result.addAll(getReachedInExpression(exp.right));
                return result;
            case 4:
                result.addAll(getReachedInExpression(exp.left));
                result.addAll(getReachedInExpression(exp.right));
                result.addAll(getReachedInExpression(exp.condition));
                return result;
            case 6:
                result.addAll(getReachedInExpression(exp.left));
                return result;
        }
        System.out.println("ERROR: wrong type getReachedInExpression: "+exp.toString());
    }
}
