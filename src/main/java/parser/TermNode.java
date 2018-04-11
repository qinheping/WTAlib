package parser;

import java.util.List;

public class TermNode extends ProgramNode {
    public String getSymbol() {
        return symbol;
    }

    public List<TermNode> getChildren() {
        return children;
    }

    String symbol;
    List<TermNode> children;

    public TermNode(String symbol, List<TermNode> children){
        this.symbol = symbol;
        this.children = children;
    }
}
