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




    public void addNode(DAGNode newNode){
        // check if dag is empty
        if(this.roots.size() == 0){
            this.roots.add(newNode);
            return;
        }
        for(DAGNode root: roots) {
            propagateNewRoot(newNode,root);
        }

    }

    // return true if curNode = root
    private boolean propagateNewRoot(DAGNode newNode, DAGNode curNode) {
            Boolean curToNew = intersetionEmpty(curNode.reached_strs,newNode.value);
            Boolean newToCur = intersetionEmpty(newNode.reached_strs,curNode.value);
            if(newToCur&&!curToNew){
                this.roots.remove(curNode);
                this.roots.add(newNode);
                newNode.addSuccessor(curNode);
                newNode.addReached(curNode.reached_strs);
                newNode.addReached(curNode.value);
                curNode.predecessor.add(newNode);
                continue;
            }
            if(newToCur&&curToNew){
                curNode.addReached(newNode.reached_strs);
                curNode.addValues(newNode.value);
                newNode = curNode;
                propagateNewRoot(newNode,curNode);
            }
            if(!newToCur&&curToNew){
                curNode.addSuccessor(newNode);
                findPath()
            }

        boolean childToRoot = false;
        for(DAGNode child:curNnode.successors){
            if(propagateNewRoot(root, child)) {
                curNnode.successors.remove(child);
                childToRoot = true;
            }
        }
        if(childToRoot){
            root.combineNode(curNnode);
        return true;}


        Boolean curToRoot = intersetionEmpty(curNnode.reached_strs,root.value);
        if(curToRoot) {
            root.combineNode(curNnode);
            return true;
        }
        return false;
    }

    public boolean intersetionEmpty(Set s1, Set s2){
        Set<String> intersection = new HashSet<String>(s1); // use the copy constructor
        intersection.retainAll(s2);
        return intersection.isEmpty();
    }
    public DAG(List<Equation> eqs){
        this.roots = new HashSet<>();
        for(Equation eq: eqs){
            addNode(new DAGNode(getReachedInExpression(eq.right),eq.left,eq.type));
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
        return null;
    }

    // -------------------------------
    // -------------------------------
    // -------------------------------

    public class DAGNode{
        private Set<DAGNode> successors;
        private Set<DAGNode> predecessor;
        private Set<String> reached_strs;
        private Set<String> value;
        // 0 = bool
        // 1 = int
        private int type;

        public void addSuccessor(DAGNode node){
            this.successors.add(node);
        }
        public void addSuccessors(Set<DAGNode> nodes){
            this.successors.addAll(nodes);
        }

        public DAGNode(Set<String> reached, String val, int type){
            Set<String> valSet = new HashSet<>();
            valSet.add(val);
            this.addReached(valSet);
            this.reached_strs = reached;
            this.value = valSet;
            this.type = type;
            this.successors = new HashSet<>();
            this.predecessor = new HashSet<>();
        }
        public void addValues(Set<String> strs){
            this.value.addAll(strs);
        }
        public void addReached(Set<String> strs){
            this.reached_strs.addAll(strs);
        }

        public void combineNode(DAGNode node){
            addValues(node.value);
            addReached(node.reached_strs);
            addSuccessors(node.successors);
        }
    }

    // -------------------------------
    // -------------------------------
    // -------------------------------
}
