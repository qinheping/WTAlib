package automata.fta;

import automata.Automaton;
import automata.Move;
import automata.wta.WTAMove;
import org.antlr.v4.runtime.ParserRuleContext;

import java.text.CollationElementIterator;
import java.util.*;

public class FTA<S> extends Automaton<S> {
    // ------------------------------------------------------
    // Automata properties
    // ------------------------------------------------------

    private Integer initialState;
    private Collection<Integer> states;

    protected Map<Integer, Collection<Move<S>>> movesFrom;

    private Integer maxStateId;
    private Integer transitionCount;

    private int isEmpty;


    /**
     * @return the maximum state id
     */
    public Integer getMaxStateId() {
        return maxStateId;
    }

    /**
     * @return number of states in the automaton
     */
    public Integer stateCount() {
        return states.size();
    }

    /**
     * @return number of transitions in the automaton
     */
    public Integer getTransitionCount() {
        return transitionCount;
    }

// ------------------------------------------------------
    // Constructors
    // ------------------------------------------------------

    // Initializes all the fields of the automaton
    public FTA() {
        super();
        states = new HashSet<Integer>();
        movesFrom = new HashMap<Integer, Collection<Move<S>>>();
        transitionCount = 0;
        maxStateId = 0;
        isEmpty = -1; // unknown
    }

    /*
     * Create an automaton and removes unreachable states and only removes
     * unreachable states if remUnreachableStates is true and normalizes the
     * automaton if normalize is true
     */
    private static <A> FTA<A> MkSFA(Collection<FTAMove<A>> transitions, Integer initialState){

        FTA<A> aut = new FTA<A>();

        aut.states = new HashSet<Integer>();
        aut.states.add(initialState);

        aut.initialState = initialState;

        for (FTAMove<A> t : transitions)
            aut.addTransition(t);

        return aut;
    }



    // Adds a transition to the SFA
    public void addTransition(FTAMove<S> transition){
        transitionCount++;

        if (transition.from > maxStateId)
            maxStateId = transition.from;
        for(Integer to: transition.to){
            if (to > maxStateId)
                maxStateId = to;
            states.add(to);
        }

        states.add(transition.from);
        if (movesFrom.get(transition.from) != null) {
            if(!movesFrom.get(transition.from).contains(transition)) {
                movesFrom.get(transition.from).add(transition);
            }
        }
        else{
            Collection<Move<S>> transitions = new ArrayList<>();
            transitions.add(transition);
            movesFrom.put(transition.from, transitions);
        }
    }

    public Collection<Move<S>> getLeafTransitions(){
        Collection<Move<S>> leafTransitions = new LinkedList<Move<S>>();
        for(Collection<Move<S>> bucket: movesFrom.values()){
            for(Move<S> transition: bucket){
                if(transition.to.size() == 0)
                    leafTransitions.add(transition);
            }
        }
        return leafTransitions;
    }

    // ------------------------------------------------------
    // Boolean automata operations
    // ------------------------------------------------------

    public FTA<S> intersectionWith(FTA<S> aut){
        FTA<S> result = new FTA<S>();

        // reached and tovisit
        HashMap<Collection<Integer>, Integer> reachedStates = new HashMap<>();
        LinkedList<Collection<Integer>> toVisitStates = new LinkedList<>();

        // find leafs
        for(Move move_0 : this.getMoves()){
            if(move_0.to.size() != 0)
                continue;
            for(Move move_1 : aut.getMoves()){
                if(move_1.to.size() != 0)
                    continue;
                if(move_0.symbol.equals(move_1.symbol)){
                    LinkedList<Integer> newState = new LinkedList<>();
                    newState.add(move_0.from);
                    newState.add(move_1.from);
                    reachedStates.put(newState, getSubsetId(newState, reachedStates));
                    toVisitStates.add(newState);
                    result.addTransition(new FTAMove<S>(getSubsetId(newState, reachedStates),new ArrayList<>(),(S) move_0.symbol,move_0.sort));
                }
            }
        }

        // explore
        while(!toVisitStates.isEmpty()){
            List<Integer> currentState = (List<Integer>)toVisitStates.removeFirst();

            for(Move move_0 : getMovesToContaints(currentState.get(0))){
                for(Move move_1 : aut.getMovesToContaints(currentState.get(1))){
                    if(!move_0.symbol.equals(move_1.symbol))
                        continue;
                    if(move_0.to.size()!=move_1.to.size())
                        continue;
                    boolean isNewTransition = true;
                    for(int i = 0; i < move_0.to.size(); i++){
                        LinkedList<Integer> lookUpState = new LinkedList<>();
                        lookUpState.add((Integer)move_0.to.get(i));
                        lookUpState.add((Integer)move_1.to.get(i));
                        if(reachedStates.get(lookUpState) == null) {
                            isNewTransition = false;
                            break;
                        }
                    }

                    if(isNewTransition){
                        Collection<Integer> newFromState = new LinkedList();
                        newFromState.add(move_0.from);
                        newFromState.add(move_1.from);
                        Integer newFrom = getSubsetId(newFromState, reachedStates);
                        if(!reachedStates.containsValue(newFrom)){
                            reachedStates.put(newFromState, newFrom);
                            toVisitStates.add(newFromState);
                        }

                        List<Integer> newTo = new ArrayList<>();
                        for(int i = 0; i < move_0.to.size(); i++){
                            Collection<Integer> newToState = new LinkedList();
                            newToState.add((Integer)move_0.to.get(i));
                            newToState.add((Integer)move_1.to.get(i));
                            newTo.add(getSubsetId(newToState,reachedStates));
                        }

                        result.addTransition(new FTAMove<S>(newFrom,newTo,(S)move_0.symbol,move_0.sort));
                    }
                }
            }

        }

        Collection<Integer> newInitial = new LinkedList();
        newInitial.add(this.initialState);
        newInitial.add(aut.initialState);
        result.setInitialState(getSubsetId(newInitial,reachedStates));
        result.clean();
        return result;
    }

    public FTA<S> union(FTA<S> aut){
        FTA<S> result = new FTA<S>();
        result.setInitialState(0);
        this.stateShift(this.maxStateId);

        aut.stateShift(this.maxStateId +aut.maxStateId);
        for(Move<S> move: getMovesFrom(this.initialState)){
            result.addTransition(new FTAMove<S>(result.initialState,move.to,move.symbol,move.sort));
        }
        for(Move<S> move: aut.getMovesFrom(aut.initialState)){
            result.addTransition(new FTAMove<S>(result.initialState,move.to,move.symbol,move.sort));
        }
        for(Move<S> move: getMoves()){
            result.addTransition((FTAMove<S>) move);
        }
        for(Move<S> move: aut.getMoves()){
            result.addTransition((FTAMove<S>) move);
        }
        result.clean();
        return result;
    }

    public FTA<S> complement(){
        FTA<S> result = this.determinization();
        result.complete();

        Integer newInitial = maxStateId + 1;

        for(Integer state: states){
            this.addTransition(new FTAMove<S>(newInitial, Arrays.asList(state), null,getMovesFrom(initialState).iterator().next().sort));
        }


        result.clean();
        return result;
    }

    public void complete(){
        Integer sink = maxStateId +1;
        List<FTAMove<S>> toAdd = new ArrayList<>();
        Set<String> visitedSymbols = new HashSet<>();
        for(Move<S> move : getMoves()){
            if(visitedSymbols.contains(move.symbol))
                continue;
            int arity = move.to.size();
            visitedSymbols.add((String)move.symbol);

            Map<Integer,List<Integer>> buckets = new HashMap<>();
            for(int i = 0; i < arity; i++){
                buckets.put(i,new ArrayList<>(states));
            }
            Collection<List<Integer>> patterns = bucketToPatterns(buckets);
            for(List<Integer> pattern : patterns){
                boolean exists = false;
                for(Move toCheck: getMovesTo(pattern)){
                    if(toCheck.symbol.equals(move.symbol)) {
                        exists = true;
                        break;
                    }
                }
                if(!exists){
                    this.addTransition(new FTAMove<>(sink,pattern,move.symbol,move.sort));
                }
            }
        }
    }

    public FTA<S> determinization(){
        //this.compressState();

        // component of new FTA
        FTA<S> result = new FTA<S>();
        Integer leafState = 0;

        // reached and tovisit
        HashMap<Collection<Integer>, Integer> reachedStates = new HashMap<>();
        LinkedList<Collection<Integer>> toVisitStates = new LinkedList<>();

        // empty state for leaf
        Collection<Integer> detLeafState = new HashSet<>();
        reachedStates.put(detLeafState, leafState);
        toVisitStates.add(detLeafState);

        // Explore the automaton until no new subset states can be reached
        while(!toVisitStates.isEmpty()){
            String sort =null;
            Collection<Integer> curentState = toVisitStates.removeFirst();
            int currentStateId = reachedStates.get(curentState);

            // TODO check if initial

            // get all the moves out of the states in the current subset
            LinkedList<FTAMove<S>> movesToAdd = new LinkedList<FTAMove<S>>(
                    this.getMovesToContaints(curentState));

            Set<List<Integer>> reachedPatterns = new HashSet<List<Integer>>();
            Map<List<Integer>,Map<String, Collection<Integer>>> newTransitions = new HashMap<>();
            for(FTAMove move : movesToAdd){
                for(int i = 0; i < move.to.size() ;i++){
                    // the i-th state is contained in currentstate
                    if(curentState.contains(move.to.get(i))){
                        boolean validMove = true;
                        Map<Integer,List<Integer>> toPatterns = new HashMap<>();
                        toPatterns.put(i, Arrays.asList(reachedStates.get(curentState)));
                        for(int j = 0; j < move.to.size(); j++){
                            List<Integer> newTo = new ArrayList<>();
                            if(i == j)
                                continue;
                            for(Collection<Integer> subSet: reachedStates.keySet()){
                                if(subSet.contains(move.to.get(j)))
                                    newTo.add(reachedStates.get(subSet));
                            }
                            if(newTo.size()==0) {
                                validMove = false;
                                break;
                            }
                            toPatterns.put(j,newTo);
                        }
                        if(validMove){
                            sort = move.sort;
                            Collection<List<Integer>> patterns = bucketToPatterns(toPatterns);
                            //result.addTransition(new FTAMove<S>());
                            for(List<Integer> pattern: patterns){
                                if(newTransitions.get(pattern) == null){
                                    HashSet<Integer> newState = new HashSet<>();
                                    Map<String,Collection<Integer>> newMap = new HashMap<>();
                                    newState.add(move.from);
                                    newMap.put((String)move.symbol,newState);
                                }else if(newTransitions.get(pattern).get(move.symbol)==null){
                                    newTransitions.get(pattern).put((String)move.symbol,pattern);
                                }else {

                                    newTransitions.get(pattern).get(move.symbol).add(move.from);
                                }
                            }
                        }

                    }
                }
            }

            for(List<Integer> to: newTransitions.keySet()){
                for(String symbol : newTransitions.get(to).keySet()){
                    if(reachedStates.get(newTransitions.get(to).get(symbol))==null){
                        reachedStates.put(newTransitions.get(to).get(symbol), getSubsetId(newTransitions.get(to).get(symbol),reachedStates));
                        toVisitStates.add(newTransitions.get(to).get(symbol));
                    }
                    result.addTransition(new FTAMove<S>(reachedStates.get(newTransitions.get(to).get(symbol)),to,(S)symbol,sort));
                }
            }

        }
        result.clean();
        return result;
    }

    public Collection<List<Integer>> bucketToPatterns(Map<Integer,List<Integer>> buckets){
        int countAll = 1;
        Collection<List<Integer>> result = new ArrayList();
        for(Collection<Integer> bucket : buckets.values()){
            countAll = countAll*bucket.size();
        }
        for(int i = 0; i < buckets.keySet().size(); i++){
            if(result.size() == 0){
                for(int j = 0; j < buckets.get(i).size(); j++){
                    List newlist = new ArrayList();
                    newlist.add(buckets.get(i));
                }
            }else {
                Collection<List<Integer>> toAdd = new ArrayList<>();
                for(List<Integer> partialTo : result) {
                    for (int j = 1; j < buckets.get(i).size(); j++) {
                        List<Integer> copy = new ArrayList<>(partialTo);
                        copy.add(buckets.get(i).get(j));
                        toAdd.add(copy);
                    }
                    partialTo.add(buckets.get(i).get(0));
                }
                result.addAll(toAdd);
            }
        }
        assert(countAll == result.size());
        return  result;
    }

    public void compressState(){
        while(this.maxStateId > this.states.size()-1){
            for(int i = 0; i < states.size(); i++){
                if(!states.contains(i)){
                    this.replaceState(maxStateId,i);
                    break;
                }
            }
            maxStateId = 0;
            for(int state : states){
                if(maxStateId < state)
                    maxStateId = state;
            }
        }
    }

    public void replaceState(int oldState, int newState){
        if(oldState == this.initialState){
            this.initialState = newState;
        }
        for(Move<S> move : getMoves()){
            move.replaceState(oldState,newState);
        }

        movesFrom.put(newState,movesFrom.get(oldState));
        movesFrom.remove(oldState);
        states.remove(oldState);
        states.add(newState);

        maxStateId = 0;
        for(int state : states){
            if(maxStateId < state)
                maxStateId = state;
        }

    }

    public void clean(){

        Set<Integer> reachable = new HashSet<Integer>();
        reachable.add(this.initialState);

        // emptygrammar
        if(getMovesFrom(this.initialState).size() == 0){
            isEmpty = 1;
        }

        removeEpsilon();

        // check reachable
        Stack<Integer> toCheck = new Stack<Integer>();
        toCheck.push(initialState);
        while(!toCheck.empty()){
            Integer from = toCheck.pop();
            for(Move<S> move: getMovesFrom(from)){
                for(Integer to: move.to){
                    if(!reachable.contains(to)){
                        toCheck.push(to);
                        reachable.add(to);
                    }
                }
            }
        }



        // check groundable
        Set<Integer> groundable = new HashSet<Integer>();
        for(Move leafMove : getLeafTransitions()){
            groundable.add(leafMove.from);
        }
        Boolean fixpointReached = false;
        while(!fixpointReached){
            fixpointReached = true;
            for(Move<S> move: getMoves()){
                Boolean moveGroundable = true;
                for(Integer to : move.to){
                    if(!groundable.contains(to))
                        moveGroundable  = false;
                }
                if(!moveGroundable)
                    continue;
                if(!groundable.contains(move.from)){
                    fixpointReached = false;
                    groundable.add(move.from);
                }
            }
        }

        System.out.println("REACHABLE: "+reachable);

        List<Integer> toRemove = new ArrayList<Integer>();
        for(Integer state: this.states){
            if((!reachable.contains(state)) || (!groundable.contains(state))){
                toRemove.add(state);
                for(Move move: getMoves()){
                    if(move.from == state || move.to.contains(state)){
                        movesFrom.get(move.from).remove(move);
                    }
                }
            }
        }

        for(Integer state: toRemove){
            this.states.remove(state);
        }
        //this.compressState();


        if(getMovesFrom(this.initialState).size() == 0){
            isEmpty = 1;
            return;
        }
    }

    public void removeEpsilon(){
        List<Move> toRemove = new ArrayList<>();
        List<Move> toAdd = new ArrayList<>();
        for(Move move: getMoves()){
            // epsilong transition
            if(move.symbol==null || ((String)move.symbol).length() == 0){
                if(move.to.size() == 1){
                    for(Object moveToCopy : this.getMovesFrom((Integer) move.to.get(0))) {
                        FTAMove fMoveToCopy = new FTAMove(move.from, ((FTAMove) moveToCopy).to, ((FTAMove) moveToCopy).symbol,((FTAMove) moveToCopy).sort);
                        toAdd.add(fMoveToCopy);
                    }
                    toRemove.add(move);
                }
            }
        }
        for(Move move : toAdd){
            this.addTransition((FTAMove<S>) move);
        }
        for(Move move : toRemove){
            this.removeTransition(move);
        }
    }

    public void removeTransition(Move toRemove){
        movesFrom.get(toRemove.from).remove(toRemove);
    }

    public void stateShift(Integer shift){
        Collection<Integer> newStates = new HashSet<Integer>();
        for(Integer state : states){
            this.movesFrom.put(state+shift,this.movesFrom.get(state));
            this.movesFrom.remove(state);
            newStates.add(state+shift);
        }
        states = newStates;
        this.initialState = initialState+shift;
        for(Move<S> move: this.getMoves()){
            move.shift(shift);
        }
        this.maxStateId = this.maxStateId+shift;
    }

    // ------------------------------------------------------
    // Other automata operations
    // ------------------------------------------------------

    public FTA<S> removeUnreachedStates(){

        return null;
    }

    public Integer getSubsetId(Collection<Integer> subSet,HashMap<Collection<Integer>,Integer> dic){
        if(dic.get(subSet) != null)
            return dic.get(subSet);
        Integer maxId = 0;
        for(Integer id : dic.values()){
            if (id >= maxId)
                maxId = id + 1;
        }
        return maxId;
    }

    public ArrayList<FTAMove<S>>  getMovesToContaints(Integer states){
        return getMovesToContaints(Arrays.asList(states));
    }

    public ArrayList<FTAMove<S>>  getMovesToContaints(Collection<Integer> states){
        ArrayList<FTAMove<S>> result = new ArrayList<>();

        for(Move<S> move: getMoves()){
            for(Integer state : states){
                if(move.to.contains(state))
                    result.add((FTAMove<S>) move);
            }
        }
        return result;
    }

    public Collection<Move<S>> getMovesFrom(Integer state) {
        Collection<Move<S>> transitions = new LinkedList<Move<S>>();
        if(movesFrom.get(state) != null)
            transitions.addAll(movesFrom.get(state));
        else
            movesFrom.put(state,transitions);
        return transitions;
    }

    public Collection<Move<S>> getMovesTo(List<Integer> states) {
        Collection<Move<S>> transitions = new LinkedList<Move<S>>();
        for(Collection<Move<S>> bucket: movesFrom.values()){
            for(Move<S> transition: bucket){
                if(states.equals(transition.to))
                    transitions.add(transition);
            }
        }
        return transitions;
    }

    public Collection<Integer> getStates() {
        return states;
    }

    public Integer getInitialState() {
        return initialState;
    }
    public void setInitialState(Integer state){
        this.initialState = state;
    }

    public String toString(){
        String result = "Initial State: " + this.initialState + ", maxState:" + this.maxStateId + ", states: " + this.states + " # of trans: "+ this.getTransitionCount()+  "\nTransitions: " ;
        for(Move<S> move: getMoves()){
            result += move.toDotString() + "\n";
        }
        return result;
    }

    public String toTimbukString(){
        String ops = "Ops";
        Set<String> visited = new HashSet<>();
        for(Move move:this.getMoves()){
            if(visited.contains(move.symbol))
                continue;
            visited.add((String)move.symbol);
            ops += " "+move.symbol+":"+move.to.size();
        }
        String automata = "Automaton A\nStates";
        for(Integer state:this.getStates()){
            automata += " q"+state;
        }
        automata+= "\nFinal States q"+this.initialState+"\nTransitions";
        for(Move move: this.getMoves()){
            automata += "\n" + move.toTimbukString();
        }

        return ops+"\n"+automata;
    }

    public int getIsEmpty(){
        this.clean();
        return isEmpty;
    }
}