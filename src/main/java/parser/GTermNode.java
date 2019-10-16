package parser;

import java.util.ArrayList;
import java.util.List;

public class GTermNode extends ProgramNode{
    public String getSymbol() {
        return symbol;
    }

    public String symbol;

    public List<GTermNode> getChildren() {
        return children;
    }

    public List<GTermNode> children;

    public GTermNode (String symbol, List<GTermNode> children){
        this.symbol = symbol;
        this.children = children;
    }
    public GTermNode (String symbol){
        this(symbol,new ArrayList<>());
    }

    @Override
    public String toString(){
        if (children == null)
            return symbol;
        String result = "( " + symbol + " ";
        for(GTermNode node: children)
            result = result + node.toString() + " ";
        return result + ")";
    }
}
