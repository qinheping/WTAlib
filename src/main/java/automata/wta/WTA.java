package automata.wta;

import automata.Automaton;
import automata.Move;

import java.util.*;

public class WTA<S,R> extends Automaton<S> {
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
    public WTA() {
        super();
        states = new HashSet<Integer>();
        movesFrom = new HashMap<Integer, Collection<Move<S>>>();
        transitionCount = 0;
        maxStateId = 0;
    }

    // Adds a transition to the WFA
    public void addTransition(WTAMove<S, R> transition){
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
            movesFrom.get(transition.from).add(transition);
        else{
            Collection<Move<S>> transitions = new LinkedList<Move<S>>();
            transitions.add(transition);
            movesFrom.put(transition.from, transitions);
        }
    }


    // ------------------------------------------------------
    // Boolean automata operations
    // ------------------------------------------------------

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

    public void setInitialState(Integer init) { this.initialState = init;}

    public String toString(){
        return states.toString() + movesFrom.toString();
    }
}
