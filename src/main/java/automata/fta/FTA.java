package automata.fta;

import automata.Automaton;
import automata.Move;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.antlr.v4.runtime.ParserRuleContext;

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
        if (movesFrom.get(transition.from) != null)
            movesFrom.get(transition.from).add((FTAMove<S>) transition);
        else{
            Collection<Move<S>> transitions = new LinkedList<Move<S>>();
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
        //TODO
        return null;
    }

    public FTA<S> complement(FTA<S> aut){
        //TODO
        return null;
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
        String result = "Initial State: " + this.initialState + "\nTransitions: " ;
        for(Move<S> move: getMoves()){
            result += move.toDotString() + "\n";
        }
        return result;
    }
}
