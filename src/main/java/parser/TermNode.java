package parser;

import java.util.List;

public class TermNode extends ProgramNode {
    public String getSymbol() {
        return symbol;
    }

    public List<TermNode> getChildren() {
        return children;
    }

    public void setSymbol(String symbol){this.symbol = symbol;}
    String symbol;
    List<TermNode> children;

    public TermNode(String symbol, List<TermNode> children){
        this.symbol = symbol;
        this.children = children;
    }

    public boolean hasChild(){
        if(children == null || children.size() == 0)
            return false;
        return true;
    }
    @Override
    public String toString(){
        String result = this.symbol+"(";
        for(TermNode child: this.children){
            result+= child.toString();
        }
        return result+")";
    }
}
