package grammar;

import automata.FTA.FTA;
import automata.FTA.FTAMove;
import automata.Move;
import automata.wta.WTA;
import automata.wta.WTAMove;
import javafx.util.Pair;
import semirings.Semiring;

import java.util.*;

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
        Collection<FTAMove<S>> ftaMoves = new HashSet<FTAMove<S>>();
        Collection<WTAMove<S,R>> leafTransitions = wAut.getLeafTransitions();
        Map<Integer,Collection<R>> reachedWeight = new HashMap<Integer, Collection<R>>();
        for(WTAMove<S,R> leafTransition: leafTransitions){
            List<R> leafWeight = new ArrayList<R>();
            leafWeight.add(leafTransition.weight);
            reachedWeight.put(leafTransition.from, leafWeight);
        }

        Boolean reachedWeightChanged = true;
        Collection<Integer> updatedStateIds = new ArrayList<Integer>(reachedWeight.keySet());

        while(reachedWeightChanged){
            reachedWeightChanged = false;
            Collection<WTAMove<S,R>> applicableTransitions = findApplicableTransitions(wAut, updatedStateIds, reachedWeight.keySet());
            for(WTAMove<S,R> transition: applicableTransitions){
                //TODO sketch
                Collection<FTAMove<S>> newMoves = getNewMoves(transition, reachedWeight, c);
                if(newMoves.size() != 0)
                    reachedWeightChanged = true;
                reachedWeight.get(transition.from).addAll(newReachedWeight);
                ftaMoves.addAll(newMoves);
                //TODO sketch end
            }
        }

        return null;
    }

    private Collection<FTAMove<S>> getNewMoves(WTAMove<S,R> transition, Map<Integer,Collection<R>> reachedWeight, R c){

        return null;
    }

    private Collection<WTAMove<S,R>> findApplicableTransitions(WTA<S,R> wAut, Collection<Integer> checkedSet, Collection<Integer>machedSet){
        Collection<WTAMove<S,R>> result = new ArrayList<WTAMove<S, R>>();
        for(Move<S> transition: wAut.getMoves()){
            Boolean matched = true;
            Boolean checked = false;

            for(Integer toState: transition.to){
                if(!machedSet.contains(toState)){
                    matched = false;
                    break;
                }
                if(checkedSet.contains(toState))
                    checked = true;
            }

            if(matched&&checked){
                result.add((WTAMove<S,R>)transition);
            }
        }
        return result;
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