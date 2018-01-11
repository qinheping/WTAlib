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
    private Semiring<R> sr;
    private Map<Integer, Map<R,Integer>> newIdDic;
    private Integer maxNewId;

    public GrammarReduction(Semiring<R> sr){
        this.sr = sr;
        this.newIdDic = new HashMap<Integer, Map<R, Integer>>();
        this.maxNewId = 0;
    }

    public FTA<S> mkFTALessThanC(WTA<S,R> wAut, R c){
        Collection<FTAMove<S>> ftaMoves = new HashSet<FTAMove<S>>();
        Collection<WTAMove<S,R>> leafTransitions = wAut.getLeafTransitions();
        Map<Integer,List<R>> reachedWeight = new HashMap<Integer, List<R>>();
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

    private Collection<Tuple<FTAMove<S>,R>> getNewMoves(WTAMove<S,R> transition, Map<Integer,List<R>> reachedWeight, R c){
        Integer oldId = transition.from;
        Collection<Tuple<FTAMove<S>,R>> result = new ArrayList<Tuple<FTAMove<S>, R>>();
        List<Integer> indexes = new ArrayList<Integer>();
        // initial indexes
        for(int i = 0; i < transition.to.size(); i++){
            indexes.add(1);
        }

        // caculate moveCount
        Integer moveBound = 1;
        for(Integer state: transition.to){
            moveBound *= reachedWeight.get(state).size();
        }

        // fill moves
        while(result.size() < moveBound){
            List<R> childrenWeight = new ArrayList<R>();
            List<Integer> newIdChildren = new ArrayList<Integer>();
            for(int i = 0; i < transition.to.size(); i++) {
                childrenWeight.add(reachedWeight.get(transition.to.get(i)).get(indexes.get(i)));
                newIdChildren.add(accessNewId(transition.to.get(i),childrenWeight.get(i)));
            }
            R weight = this.sr.times(childrenWeight);
            FTAMove<S> newMove = new FTAMove<S>(accessNewId(transition.from,weight), newIdChildren, transition.symbol);
            result.add(new Tuple<FTAMove<S>, R>(newMove, weight));

            // TODO update indexes

        }
        return result;
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


    public class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

}