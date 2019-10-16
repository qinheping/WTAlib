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
        return content.symbol;
    }


    public List<GTermNode> getChildren() {
        return content.children;
    }

    public GTermNode getContent() {
        return content;
    }

    public void setContent(GTermNode content) {
        this.content = content;
    }

    GTermNode content;

    public RuleNode(List<String> weight, GTermNode gterm){
        this.weight = weight;
        if(weight == null)
            this.weight = new ArrayList<String>();
        content = new GTermNode(gterm.getSymbol(),gterm.getChildren());
    }

    public RuleNode( GTermNode gterm){
        this(new ArrayList<>(),gterm);
    }
    @Override
    public String toString(){
        if (content.children == null)
            return content.symbol;
        String result = "( " + content.symbol + " ";
        for(GTermNode node: content.children)
            result = result + node.toString() + " ";
        return result + ")";
    }

    public <S,R> WTAMove<S,R> toMove(Map<String, Integer> idDic, Semiring<R> sr, int index, Integer from){
        R w = sr.one();
        if(weight.size() > index)
            w=sr.parse(weight.get(index));
        List<Integer> to = new ArrayList<Integer>();
        if(content.children != null){
            for(GTermNode child: content.children) {
                if (idDic.get(child.symbol) != null) {
                    to.add(idDic.get(child.symbol));
                }
                else
                    to.add(1);
            }
        }else
            to.add(1);
        return new WTAMove<S,R>(from,to, (S)content.symbol, w);
    }

    public <S>FTAMove<S> toFTAMove(Map<String, Integer> idDic, Integer from){
        List<Integer> to = new ArrayList<Integer>();
        if(this.content.children != null){
            for(GTermNode child: content.children) {
                if (idDic.get(child.symbol) != null) {
                    to.add(idDic.get(child.symbol));
                }
                else
                    to.add(1);
            }
        }else
            to.add(1);
        return new FTAMove<S>(from,to,(S)content.symbol);

    }
}
