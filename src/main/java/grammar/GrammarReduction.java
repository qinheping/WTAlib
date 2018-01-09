package grammar;

import automata.FTA.FTA;
import automata.wta.WTA;
import semirings.Semiring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GrammarReduction<S,R>{
    private Semiring sr;
    private Map<Integer, Map<R,Integer>> newIdDic;
    private Integer maxNewId;

    public GrammarReduction(Semiring sr){
        this.sr = sr;
        this.newIdDic = new HashMap<Integer, Map<R, Integer>>();
        this.maxNewId = 0;
    }

    public FTA<S> mkFTALessThanC(WTA<S,R> wAut, R c){
        return null;
    }

    private class CombinedState{
        private Integer newId;
        private R weight;
        private Integer oldId;
        public CombinedState(Integer  oldId, R weight){
            this.oldId = oldId;
            this.weight = weight;
            this.newId = accessNewId(oldId, weight);
        }
    }

    public Integer accessNewId(Integer oldId, R weight){
        Map<R, Integer> subDic = this.newIdDic.get(oldId);
        if(subDic == null){
            subDic = new HashMap<R, Integer>();
        }

        if(subDic.get(weight)!= null)
            return subDic.get(weight);

        subDic.put(weight, maxNewId);
        maxNewId++;
        this.newIdDic.put(oldId, subDic);
        return maxNewId-1;
    }

}