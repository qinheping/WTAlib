package automata.wta;

import automata.Automaton;
import automata.FTA.FTAMove;
import automata.Move;

import java.util.*;

public class WTA<S,R> extends Automaton<S> {
    // ------------------------------------------------------
    // Automata properties
    // ------------------------------------------------------

    private Integer initialState;
    private Collection<Integer> states;

    protected Map<Integer, Collection<WTAMove<S, R>>> movesFrom;

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
    private WTA() {
        super();
        states = new HashSet<Integer>();
        movesFrom = new HashMap<Integer, Collection<WTAMove<S, R>>>();
        transitionCount = 0;
        maxStateId = 0;
    }

    // Adds a transition to the WFA
    private void addTransition(WTAMove<S, R> transition){
        transitionCount++;

        if (transition.from > maxStateId)
            maxStateId = transition.from;
        for(Integer to: transition.to){
            if (to > maxStateId)
                maxStateId = to;
            states.add(to);
        }

        states.add(transition.from);

        getMovesFrom(transition.from).add((WTAMove<S, R>) transition);
    }


    // ------------------------------------------------------
    // Boolean automata operations
    // ------------------------------------------------------

    public Collection<WTAMove<S,R>> getLeafTransitions(){
        Collection<WTAMove<S,R>> leafTransitions = new LinkedList<WTAMove<S, R>>();
        for(Collection<WTAMove<S,R>> bucket: movesFrom.values()){
            for(WTAMove<S,R> transition: bucket){
                if(transition.to.size() == 0)
                    leafTransitions.add(transition);
            }
        }
        return leafTransitions;
    }

    public Collection<Move<S>> getMovesFrom(Integer state) {
        Collection<Move<S>> transitions = new LinkedList<Move<S>>();
        transitions.addAll(movesFrom.get(state));
        return transitions;
    }

    public Collection<Move<S>> getMovesTo(List<Integer> states) {
        Collection<Move<S>> transitions = new LinkedList<Move<S>>();
        for(Collection<WTAMove<S,R>> bucket: movesFrom.values()){
            for(WTAMove<S,R> transition: bucket){
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
}
