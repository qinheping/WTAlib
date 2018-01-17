package parser;

import java.util.List;

public class TermNode extends ProgramNode {
    String symbol;
    List<TermNode> children;

    public TermNode(String symbol, List<TermNode> children){
        this.symbol = symbol;
        this.children = children;
    }
}
