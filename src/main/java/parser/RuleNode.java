package parser;

import automata.fta.FTAMove;
import automata.wta.WTAMove;
import semirings.Semiring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RuleNode extends ProgramNode {
    List<String> weight;

    public String getSymbol() {
        return symbol;
    }

    String symbol;

    public List<GTermNode> getChildren() {
        return children;
    }

    List<GTermNode> children;

    public RuleNode(List<String> weight, GTermNode gterm){
        this.weight = weight;
        if(weight == null)
            this.weight = new ArrayList<String>();
        this.symbol = gterm.symbol;
        this.children = gterm.children;
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

    public <S,R> WTAMove<S,R> toMove(Map<String, Integer> idDic, Semiring<R> sr, int index, Integer from){
        R w = sr.one();
        if(weight.size() > index)
            w=sr.parse(weight.get(index));
        List<Integer> to = new ArrayList<Integer>();
        if(children != null){
            for(GTermNode child: children) {
                if (idDic.get(child.symbol) != null) {
                    to.add(idDic.get(child.symbol));
                }
                else
                    to.add(1);
            }
        }else
            to.add(1);
        return new WTAMove<S,R>(from,to, (S)symbol, w);
    }

    public <S>FTAMove<S> toFTAMove(Map<String, Integer> idDic, Integer from){
        List<Integer> to = new ArrayList<Integer>();
        if(this.children != null){
            for(GTermNode child: children) {
                if (idDic.get(child.symbol) != null) {
                    to.add(idDic.get(child.symbol));
                }
                else
                    to.add(1);
            }
        }else
            to.add(1);
        return new FTAMove<S>(from,to,(S)symbol);

    }
}
