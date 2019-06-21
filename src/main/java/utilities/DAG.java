package utilities;

import java.util.List;
import java.util.Set;

public class DAG {
    Set<DAGNode> roots;
    public static class DAGNode{
        List<DAGNode> successors;
        Set<Set<String>> reched_nodes;
        Set<String> value;
    }
}
