package parser;

import automata.wta.WTA;
import automata.wta.WTAMove;
import semirings.Semiring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrammarNode extends ProgramNode {
    List<NTNode> ntNodes;
    String funName;
    String argList;
    String sort;

    Map<String, Integer> idDic;
    Integer maxId;

    public GrammarNode(String funName, String argList, String sort, List<NTNode> ntNodes){
        this.funName = funName;
        this.argList = argList;
        this.sort = sort;
        this.ntNodes = ntNodes;
    }

    @Override
    public  String toString(){
        String result = "( synth-fun" + funName + ' ' +argList + ' ' + sort + " (\n";
        for(NTNode node: ntNodes){
            result = result  + node.toString() + "\n";
        }
        return result + "))";
    }

    public WTA toWTA(Semiring sr, Integer index){
        idDic = new HashMap<String, Integer>();
        maxId = 2; // 0 for Start 1 for leaf
        idDic.put("Start",  0);

        WTA wta = new WTA<String, Float>();
        if(sr.one() instanceof Float)
            wta = new WTA<String, Float>();
        for(NTNode ntNode : ntNodes){
            if(idDic.get(ntNode.ntName)==null) {
                idDic.put(ntNode.ntName, maxId);
                maxId++;
            }
        }
        for(NTNode ntNode : ntNodes){
            for(RuleNode rule: ntNode.rules)
                wta.addTransition(rule.toMove(idDic,sr, index, idDic.get(ntNode.ntName)));
        }
        wta.setInitialState(0);
        wta.addTransition(new WTAMove<String, Float>(1, new ArrayList<Integer>(),"", (Float) sr.one()));
        return wta;
    }

}
