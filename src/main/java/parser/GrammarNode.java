package parser;

import automata.Move;
import automata.fta.FTA;
import automata.fta.FTAMove;
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
        String result = "( synth-fun " + funName + ' ' +argList + ' ' + sort + " (\n";
        for(NTNode node: ntNodes){
            result = result  + node.toString() + "\n";
        }
        return result + "))";
    }

    String toString(FTA fta){
        String result = "( synth-fun " + funName + ' ' +argList + ' ' + sort + " (\n";
        for(Object from : fta.getStates()){
            if(from == fta.getInitialState()) {
                result += "\t(Start" + " " + ((Move) fta.getMovesFrom((Integer) from).iterator().next()).sort + " (";
                for(Object moveO: fta.getMovesFrom((Integer) from)){
                    Move move = (Move) moveO;
                    if(((String)move.symbol).length()==0){
                        result += "\t\tNT"+move.to.get(0) + "\n";
                        continue;
                    }
                    if(move.to.size() == 0){
                        result += "\t\t"+move.symbol +"\n";
                        continue;
                    }
                    result+="\t\t("+move.symbol;
                    for(Object to: move.to){
                        if(to.equals(fta.getInitialState()))
                            result+=" Start";
                        else
                            result+=" NT"+to.toString();
                    }
                    result +=")\n";
                }
                result+= "))\n";
            }
        }
        for(Object from : fta.getStates()){
            if(fta.getMovesFrom((Integer) from) == null || fta.getMovesFrom((Integer) from).size() == 0)
                continue;
            if(from == fta.getInitialState()){
            }else{
                result += "\t(NT"+from +" "+((Move)fta.getMovesFrom((Integer)from).iterator().next()).sort+" (";
            for(Object moveO: fta.getMovesFrom((Integer) from)){
                Move move = (Move) moveO;
                if(((String)move.symbol).length()==0){
                    result += "\t\tNT"+move.to.get(0) + "\n";
                    continue;
                }
                if(move.to.size() == 0){
                    result += "\t\t"+move.symbol +"\n";
                    continue;
                }
                result+="\t\t("+move.symbol;
                for(Object to: move.to){
                    if(to.equals(fta.getInitialState()))
                        result+=" Start";
                    else
                        result+=" NT"+to.toString();
                }
                result +=")\n";
            }
            result+= "))\n";}
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
            for(RuleNode rule: ntNode.rules){
                WTAMove toAdd = rule.toMove(idDic,sr, index, idDic.get(ntNode.ntName));
                toAdd.sort = ntNode.ntSort;
                wta.addTransition(toAdd);
            }
        }
        wta.setInitialState(0);
        wta.addTransition(new WTAMove<String, Float>(1, new ArrayList<Integer>(),"", (Float) sr.one(), this.sort));
        return wta;
    }

    public FTA toFTA(){
        FTA fta = new FTA<String>();
        for(NTNode ntNode : ntNodes){
            if(idDic.get(ntNode.ntName)==null) {
                idDic.put(ntNode.ntName, maxId);
                maxId++;
            }
        }
        for(NTNode ntNode : ntNodes){
            for(RuleNode rule: ntNode.rules){
                FTAMove toAdd = rule.toFTAMove(idDic,  idDic.get(ntNode.ntName));
                toAdd.sort = ntNode.ntSort;
                // leaf
                if(toAdd.to.size() == 1 && toAdd.to.get(0).equals(1)){
                    toAdd.to = new ArrayList();
                }
                fta.addTransition(toAdd);
            }
        }
        fta.setInitialState(0);
        System.out.println(fta.toString());
        return fta;
    }

}