package automata;


import utilities.Tree;
import java.util.Collection;
import java.util.LinkedList;

/**
 *  Automata abstract class
 *      Top-Down tree automata
 *
 *  @param <S>
 *      domain of the automaton alphabet
 *
 *  @param <R>
 *      semiring
 */

public abstract class Automaton<S, R> {
    // ------------------------------------------------------
    // Automata properties
    // ------------------------------------------------------
    protected boolean isEmpty;
    protected boolean isDeterministic;
    protected boolean isTotal;

    public Automaton() {
        isEmpty = false;
        isDeterministic = false;
        isTotal = false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString(){
        //TODO: implement this
        return null;
    }

    /**
     * Returns true if the machine accepts the input tree, that is, evaluation not zero
     *
     * @param input
     * @return true if accepted false otherwise
     */
    public boolean accepts(Tree<S> input){
        Collection<Integer> currConf = getEpsClosure(getInitialState(), ba);
        for (S el : input) {
            currConf = getNextState(currConf, el, ba);
            currConf = getEpsClosure(currConf, ba);
            if (currConf.isEmpty())
                return false;
        }

        return isFinalConfiguration(currConf);
    }

    // ------------------------------------------------------
    // Accessory functions
    // ------------------------------------------------------

    /**
     * Returns the set of transitions starting set of states
     */
    public Collection<Move<S, R>> getMoves() {
        return getMovesFrom(getStates());
    }

    /**
     * Set of moves from state
     */
    public abstract Collection<Move<S, R>> getMovesFrom(Integer state);

    /**
     * Set of moves from set of states
     */
    public Collection<Move<S, R>> getMovesFrom(Collection<Integer> states) {
        Collection<Move<S, R>> transitions = new LinkedList<Move<S, R>>();
        for (Integer state : states)
            transitions.addAll(getMovesFrom(state));
        return transitions;
    }

    /**
     * Set of moves to <code>state</code>
     */
    public abstract Collection<Move<S, R>> getMovesTo(Integer state);

    /**
     * Set of moves to a set of states <code>states</code>
     */
    public Collection<Move<S, R>> getMovesTo(Collection<Integer> states) {
        Collection<Move<S, R>> transitions = new LinkedList<Move<S, R>>();
        for (Integer state : states)
            transitions.addAll(getMovesTo(state));
        return transitions;
    }

    /**
     * Returns the set of states
     */
    public abstract Collection<Integer> getStates();

    /**
     * Returns initial state
     */
    public abstract Integer getInitialState();

    /**
     * @return true if the set <code>conf</code> contains an initial state
     */
    public boolean isInitialConfiguration(Collection<Integer> conf) {
        for (Integer state : conf)
            if (isInitialState(state))
                return true;
        return false;
    }

    /**
     * @return true if <code>state</code> is an initial state
     */
    public boolean isInitialState(Integer state) {
        return getInitialState() == state;
    }

    // ------------------------------------------------------
    // Auxiliary protected functions
    // ------------------------------------------------------

    protected Collection<Integer> getNextState(Collection<Integer> currState, S inputElement, BooleanAlgebra<P, S> ba) throws TimeoutException {
        Collection<Integer> nextState = new HashSet<Integer>();
        for (Move<P, S> t : getMovesFrom(currState)) {
            if (!t.isEpsilonTransition()) {
                if (t.hasModel(inputElement, ba))
                    nextState.add(t.to);
            }
        }

        return nextState;
    }

    /**
     * If <code>state<code> belongs to reached returns reached(state) otherwise
     * add state to reached and to toVisit and return corresponding id
     */
    public static <A, B> int getStateId(A state, Map<A, Integer> reached, LinkedList<A> toVisit) {
        if (!reached.containsKey(state)) {
            int newId = reached.size();
            reached.put(state, newId);
            toVisit.add(state);
            return newId;
        } else
            return reached.get(state);
    }

    // ------------------------------------------------------
    // Getters
    // ------------------------------------------------------

    /**
     * @return the isEmpty
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * @return the isDeterministic
     */
    public boolean isDeterministic() {
        return isDeterministic;
    }

    /**
     * @return the isTotal
     */
    public boolean isTotal() {
        return isTotal;
    }

}
