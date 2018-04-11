package automata.fta;

import automata.Automaton;
import automata.Move;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.antlr.v4.runtime.ParserRuleContext;

import java.math.BigInteger;
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
            movesFrom.get(transition.from).add(transition);
        }
        else{
            Collection<Move<S>> transitions = new HashSet<Move<S>>();
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
        //TODO
        return null;
    }

    public FTA<S> union(FTA<S> aut){
        FTA<S> result = new FTA<S>();
        result.setInitialState(0);
        this.statShift(1);
        aut.statShift(this.maxStateId);
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
        return result;
    }

    public FTA<S> complement(FTA<S> aut){
        //TODO
        return null;
    }

    public FTA<S> determinization(){
        this.compressState();
        if(states.size()>30) {
            System.out.println("error: too much state to determinze");
            return null;
        }
        FTA<S> result = new FTA<S>();
        for(int i = 0; i < Math.pow(2,states.size()); i++){
            List<Integer> states = powerToSet(i);
            result.addTransition();
        }
        return null;
    }

    public Integer powerOfTwo(List<Integer> list){
        Integer result = 0;
        for (Integer num: list){
            result += (int) Math.pow(2,num);
        }
        return result;
    }

    public List<Integer> powerToSet(Integer pow){
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        while(pow>0){
            if(pow%2 == 1) {
                result.add(i);
                pow --;
            }
            pow = pow/2;
            i++;
        }
        return result;
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
                if(!groundable.contains(move.from)){
                    fixpointReached = false;
                    groundable.add(move.from);
                }
            }
        }

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
        this.compressState();
    }

    public void statShift(Integer shift){
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
        String result = "Initial State: " + this.initialState + ", maxState:" + this.maxStateId + ", states: " + this.states +  "\nTransitions: " ;
        for(Move<S> move: getMoves()){
            result += move.toDotString() + "\n";
        }
        return result;
    }
}