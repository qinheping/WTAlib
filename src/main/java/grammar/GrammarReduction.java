package grammar;

import automata.fta.FTA;
import automata.fta.FTAMove;
import automata.Move;
import automata.wta.WTA;
import automata.wta.WTAMove;
import semirings.Semiring;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrammarReduction<S,R>{
    public Semiring<R> sr;
    private Map<Integer, Map<R,Integer>> newIdDic;
    private Integer maxNewId;
    private Logger logger = Logger.getLogger("Reduction");

    public GrammarReduction(Semiring<R> sr){
        this.sr = sr;
        this.newIdDic = new HashMap<Integer, Map<R, Integer>>();
        this.maxNewId = 0;
    }

    public FTA<S> mkFTALessThanC(WTA<S,R> wAut, R c){
        return this.mkFTAInRange(wAut, sr.one(), true, c,false);
    }

    public FTA<S> mkFTAInRange(WTA<S,R> wAut, R l, boolean infclosed, R h, boolean supclosed){
        logger.setUseParentHandlers(false);

        // fta moves we need to produce for the result fta
        Collection<FTAMove<S>> ftaMoves = new HashSet<FTAMove<S>>();
        // leaf transitions in the input WTA
        Collection<Move<S>> leafTransitions = wAut.getLeafTransitions();
        // <oldId, weight> tuple
        Map<Integer,List<R>> reachedWeight = new HashMap<Integer, List<R>>();

        // initial reachedWeight as leaf
        for(Move<S> leafTransition: leafTransitions){
            if(reachedWeight.get(leafTransition.from) == null) {
                List<R> leafWeight = new ArrayList<R>();
                reachedWeight.put(leafTransition.from, leafWeight);
            }
            reachedWeight.get(leafTransition.from).add(((WTAMove<S,R>)leafTransition).weight);
        }

        // flag for termination
        Boolean reachedWeightChanged = true;
        // state having new weight in last iteration
        Map<Integer,List<R>> newWeight = new HashMap<Integer, List<R>>();
        for(Integer oldId : reachedWeight.keySet()){
            List<R> bucket = new ArrayList<R>();
            bucket.addAll(reachedWeight.get(oldId));
            newWeight.put(oldId, bucket);
        }

        reachedWeight.clear();

        // terminate when reach fixed point
        while(reachedWeightChanged){
            reachedWeightChanged = false;
            // transitions involve states updated in last iteration
            Collection<WTAMove<S,R>> applicableTransitions = findApplicableTransitions(wAut, newWeight.keySet(), reachedWeight.keySet());

            Collection<Tuple<FTAMove<S>,R>> tmpTuples = new ArrayList<Tuple<FTAMove<S>, R>>();

            // find moves base on applicable transitions
            for(WTAMove<S,R> transition: applicableTransitions){
                // find new moves and their weights

                logger.log(Level.INFO,"Transition: " + transition.toDotString());
                Collection<Tuple<FTAMove<S>,R>> newTuples = getNewMoves(transition, newWeight, reachedWeight, h, supclosed);


                // check if fixed point
                if(newTuples.size() != 0)
                    reachedWeightChanged = true;
                tmpTuples.addAll(newTuples);
            }

            // add all new weight to old
            for(Integer key : newWeight.keySet()){
                if(reachedWeight.get(key) == null)
                    reachedWeight.put(key,newWeight.get(key));
                else
                    reachedWeight.get(key).addAll(newWeight.get(key));
            }
            newWeight = new HashMap<Integer, List<R>>();

            // update new weight
            for(Tuple<FTAMove<S>, R> newTuple: tmpTuples) {
                    ftaMoves.add(newTuple.x);
                Integer oldState = accessOldId(newTuple.x.from, newTuple.y);
                if(reachedWeight.get(oldState)!=null && reachedWeight.get(oldState).contains(newTuple.y))
                    continue;
                if(newWeight.get(oldState) == null){
                    List<R> newWeightList = new ArrayList<R>();
                    newWeightList.add(newTuple.y);
                    newWeight.put(oldState,newWeightList);
                }
                else {
                    if(!newWeight.get(oldState).contains(newTuple.y))
                        newWeight.get(oldState).add(newTuple.y);
                }
            }
            logger.log(Level.INFO,"# of new weights: "+ newWeight.size());
        }


        logger.log(Level.INFO,"Start to construct FTA");
        // construct result fta
        FTA<S> fta = new FTA<S>();
        // add all constrcuted transitions
        for(FTAMove<S> move: ftaMoves){
            fta.addTransition(move);
        }
        // add a new axiom state
        for(Integer initNewId : newIdDic.get(wAut.getInitialState()).values()){
            if(!((sr.lessThan(accessWeight(initNewId),h)|| supclosed) && (sr.lessOrEqual(accessWeight(initNewId),h)|| !supclosed)
                    && (sr.lessThan(l, accessWeight(initNewId)) || infclosed) && (sr.lessOrEqual(l, accessWeight(initNewId)) || !infclosed))) {
                continue;
            }
            String initSort = fta.getMovesFrom(initNewId).iterator().next().sort;
            List<Integer> singletonTo = new ArrayList<Integer>();
            singletonTo.add(initNewId);
            fta.addTransition(new FTAMove<S>(this.maxNewId, singletonTo, (S)"",initSort));
        }
        fta.setInitialState(this.maxNewId);
        fta.clean();
        return fta;
    }

    private Collection<Tuple<FTAMove<S>,R>> getNewMoves(WTAMove<S,R> transition, Map<Integer,List<R>> newWeightBuckets, Map<Integer,List<R>> weightBuckets, R c, boolean supclosed){
        Collection<Tuple<FTAMove<S>,R>> result = new ArrayList<Tuple<FTAMove<S>, R>>() ;
        List<Integer> indexes = new ArrayList<Integer>();
        logger.log(Level.INFO,"Transition: " + transition.toDotString());

        for(int newWeightUsed = 1; newWeightUsed <= transition.to.size(); newWeightUsed++) {

            Boolean noMoreNew = false;
            // positions using new weight
            List<Integer> posNew = new ArrayList<Integer>();
            for(int i = 0; i < newWeightUsed; i++){
                posNew.add(i);
            }
            while(!noMoreNew){

                logger.log(Level.INFO,"Position of new weight: " + posNew);
                Collection<Tuple<FTAMove<S>,R>> temResult = new ArrayList<Tuple<FTAMove<S>, R>>() ;
                Integer temMoveCount = 0;
                List<Integer> indexes_new = new ArrayList<Integer>();

                for(int i = 0; i < transition.to.size(); i++){
                    indexes_new.add(0);
                }

                // initial indexes
                for (int i = 0; i < transition.to.size(); i++) {
                    indexes.add(0);
                }

                // calculate moveCount
                Integer moveBound = 1;
                for (int i = 0; i < transition.to.size(); i++) {
                    Integer state = transition.to.get(i);
                    if(posNew.contains(i)){
                        if(newWeightBuckets.get(state) == null)
                            moveBound = 0;
                        else
                            moveBound *= newWeightBuckets.get(state).size();
                    }else {
                        if(weightBuckets.get(state) == null)
                            moveBound = 0;
                        else
                            moveBound *= weightBuckets.get(state).size();
                    }
                }

                logger.log(Level.INFO,"moveBound: " + moveBound);
                // fill moves
                while (temMoveCount < moveBound) {
                    Collection<Tuple<FTAMove<S>,R>> temTemResult = new ArrayList<Tuple<FTAMove<S>, R>>() ;
                    Integer temTemMoveCount = 0;

                    Integer oldMoveBound = 1;
                    for (int i = 0; i < transition.to.size(); i++) {
                        Integer state = transition.to.get(i);
                        if(posNew.contains(i)){
                            if(newWeightBuckets.get(state) == null)
                                oldMoveBound = 0;
                            else
                                oldMoveBound *= 1;
                        }else
                            oldMoveBound *= weightBuckets.get(state).size();
                    }

                    logger.log(Level.INFO,"oldMoveBound: " + oldMoveBound);
                    while(temTemMoveCount < oldMoveBound) {
                        // fill children list
                        List<Integer> childrenNewId = new ArrayList<Integer>();
                        List<R> childrenWeight = new ArrayList<R>();
                        for (int i = 0; i < transition.to.size(); i++) {
                            // use old weight
                            if (!posNew.contains(i)) {
                                childrenWeight.add(weightBuckets.get(transition.to.get(i)).get(indexes.get(i)));
                                if(!(transition.to.size() == 1 && accessNewId(transition.to.get(i), childrenWeight.get(i)) == 0))
                                    childrenNewId.add(accessNewId(transition.to.get(i), childrenWeight.get(i)));
                            } else {
                                childrenWeight.add(newWeightBuckets.get(transition.to.get(i)).get(indexes_new.get(i)));
                                if(!(transition.to.size() == 1 && accessNewId(transition.to.get(i), childrenWeight.get(i)) == 0))
                                    childrenNewId.add(accessNewId(transition.to.get(i), childrenWeight.get(i)));
                            }
                        }

                        childrenWeight.add(transition.weight);
                        // calculate weight
                        R weight = this.sr.times(childrenWeight);
                        // put tuple to temTemResult
                        if ((sr.lessThan(weight, c) || supclosed) && (sr.lessOrEqual(weight, c) || !supclosed)) {
                            FTAMove<S> newMove = new FTAMove<S>(accessNewId(transition.from, weight), childrenNewId, transition.symbol);
                            newMove.sort = transition.sort;
                            temTemResult.add(new Tuple<FTAMove<S>, R>(newMove, weight));
                            logger.log(Level.INFO,"new move added: " + newMove.toDotString());
                        }
                        temTemMoveCount++;

                        // update indexes
                        int currentPos = 0;
                        while (currentPos < transition.to.size()) {
                            if(posNew.contains(currentPos)){
                                currentPos++;
                                break;
                            }
                            if (indexes.get(currentPos) == weightBuckets.get(transition.to.get(currentPos)).size() - 1) {
                                indexes.set(currentPos, 0);
                                currentPos++;
                            } else {
                                indexes.set(currentPos, indexes.get(currentPos) + 1);
                                break;
                            }
                        }
                    }
                    temResult.addAll(temTemResult);
                    temMoveCount += temTemMoveCount;
                    // update indexes new
                    for(Integer pos: posNew){
                        if(indexes_new.get(pos) == newWeightBuckets.get(transition.to.get(pos)).size()-1){
                            indexes_new.set(pos,0);
                        }else {
                            indexes_new.set(pos,indexes_new.get(pos)+1);
                        }
                    }

                }
                // update positions
                posNew = updatePos(posNew, transition.to.size());

                result.addAll(temResult);
                if(posNew.get(0) == transition.to.size()-newWeightUsed)
                    noMoreNew = true;
            }
        }

        logger.log(Level.INFO, "we added " +result.size()+" new moves in this call");
        return result;
    }

    private Collection<WTAMove<S,R>> findApplicableTransitions(WTA<S,R> wAut, Collection<Integer> checkedSet, Collection<Integer>machedSet){
        Collection<WTAMove<S,R>> result = new ArrayList<WTAMove<S, R>>();
        for(Move<S> transition: wAut.getMoves()){
            Boolean matched = true;
            Boolean checked = false;
            for(Integer toState: transition.to){
                if(!machedSet.contains(toState) && !checkedSet.contains(toState)){
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

    public List<Integer> updatePos(List<Integer> posNew, Integer bound){
        Integer intRepresent = 0;
        for(int i = 0; i < posNew.size(); i++){
            if(i == posNew.size()-1) {
                if (bound - posNew.get(i) > 1)
                    posNew.set(i,posNew.get(i)+1);
                break;
            }

            if(posNew.get(i+1)-posNew.get(i) > 1){
                posNew.set(i,posNew.get(i)+1);
                break;
            }
        }
        return posNew;
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
        logger.log(Level.INFO, "Dic update: (" +  oldId +","+weight+") = " +(maxNewId-1));
        return maxNewId-1;
    }

    public Integer accessOldId(Integer newId, R weight){
        for(Integer oldId : this.newIdDic.keySet()){
            if(newIdDic.get(oldId).get(weight) == newId)
                return oldId;
        }
        return -1;
    }

    public R accessWeight(Integer newId){
        for(Integer oldId : this.newIdDic.keySet()){
            for (R weight : this.newIdDic.get(oldId).keySet()){
                if(this.newIdDic.get(oldId).get(weight) == newId)
                    return weight;
            }
        }
        return null;
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