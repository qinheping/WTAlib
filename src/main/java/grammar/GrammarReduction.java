package grammar;

import automata.fta.FTA;
import automata.fta.FTAMove;
import automata.Move;
import automata.wta.WTA;
import automata.wta.WTAMove;
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
        // fta moves we need to produce for the result fta
        Collection<FTAMove<S>> ftaMoves = new HashSet<FTAMove<S>>();
        // leaf transitions in the input WTA
        Collection<Move<S>> leafTransitions = wAut.getLeafTransitions();
        // <oldId, weight> tuple
        Map<Integer,List<R>> reachedWeight = new HashMap<Integer, List<R>>();

        // initial reachedWeight as leaf
        for(Move<S> leafTransition: leafTransitions){
            List<R> leafWeight = new ArrayList<R>();
            leafWeight.add(((WTAMove<S,R>)leafTransition).weight);
            reachedWeight.put(leafTransition.from, leafWeight);
        }

        // flag for termination
        Boolean reachedWeightChanged = true;
        // state having new weight in last iteration
        Map<Integer,List<R>> newWeight = new HashMap<Integer, List<R>>();
        for(Integer oldId : reachedWeight.keySet()){
            List<R> bucket = new ArrayList<R>();
            bucket.addAll(reachedWeight.get(oldId));
            newWeight.put(oldId, )
        }

        // terminate when reach fixed point
        while(reachedWeightChanged){
            reachedWeightChanged = false;
            // transitions involve states updated in last iteration
            Collection<WTAMove<S,R>> applicableTransitions = findApplicableTransitions(wAut, updatedStateIds, reachedWeight.keySet());

            // find moves base on applicable transitions
            for(WTAMove<S,R> transition: applicableTransitions){
                // find new moves and their weights
                Collection<Tuple<FTAMove<S>,R>> newTuples = getNewMoves(transition, reachedWeight, c);

                // check if fixed point
                if(newTuples.size() != 0)
                    reachedWeightChanged = true;

                updatedStateIds.clear();
                // update moves and updatedWeights
                for(Tuple<FTAMove<S>, R> newTuple: newTuples) {
                    System.out.println(newTuple.x);
                    ftaMoves.add(newTuple.x);
                    reachedWeight.get(newTuple.x.from).add(newTuple.y);
                }
            }
        }

        return null;
    }

    private Collection<Tuple<FTAMove<S>,R>> getNewMoves(WTAMove<S,R> transition, Map<Integer,List<R>> weightBuckets, R c){
        Collection<Tuple<FTAMove<S>,R>> result = new ArrayList<Tuple<FTAMove<S>, R>>();
        List<Integer> indexes = new ArrayList<Integer>();
        // initial indexes
        for(int i = 0; i < transition.to.size(); i++){
            indexes.add(0);
        }

        // calculate moveCount
        Integer moveBound = 1;
        for(Integer state: transition.to){
            moveBound *= weightBuckets.get(state).size();
        }

        // fill moves
        while(result.size() < moveBound){
            List<R> childrenWeight = new ArrayList<R>();
            List<Integer> newIdChildren = new ArrayList<Integer>();

            // fill children list
            for(int i = 0; i < transition.to.size(); i++) {
                childrenWeight.add(weightBuckets.get(transition.to.get(i)).get(indexes.get(i)));
                newIdChildren.add(accessNewId(transition.to.get(i),childrenWeight.get(i)));
            }

            // calculate weight
            R weight = this.sr.times(childrenWeight);

            // put tuple to result
            if(sr.lessThan(weight, c)) {
                FTAMove<S> newMove = new FTAMove<S>(accessNewId(transition.from, weight), newIdChildren, transition.symbol);
                result.add(new Tuple<FTAMove<S>, R>(newMove, weight));
            }

            // update indexes
            int currentPos = 0;
            while(currentPos < transition.to.size()){
                if(indexes.get(currentPos) == weightBuckets.get(currentPos).size()-1){
                    indexes.set(currentPos, 0);
                    currentPos++;
                }else{
                    indexes.set(currentPos, indexes.get(currentPos)+1);
                }
            }

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