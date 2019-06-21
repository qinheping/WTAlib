package automata;


import java.util.*;

/**
 *  Automata abstract class
 *      Top-Down tree automata
 *
 *  @param <S>
 *      domain of the automaton alphabet
 *
 */

public abstract class Automaton<S> {
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

    // ------------------------------------------------------
    // Accessory functions
    // ------------------------------------------------------

    /**
     * Returns the set of transitions starting set of states
     */
    public Collection<Move<S>> getMoves() {
        return getMovesFrom(getStates());
    }

    /**
     * Set of moves from state
     */
    public abstract Collection<Move<S>> getMovesFrom(Integer state);

    /**
     * Set of moves from set of states
     */
    public Collection<Move<S>> getMovesFrom(Collection<Integer> states) {
        Collection<Move<S>> transitions = new LinkedList<Move<S>>();
        for (Integer state : states)
            transitions.addAll(getMovesFrom(state));
        return transitions;
    }

    /**
     * Set of moves to list of state
     */
    public abstract Collection<Move<S>> getMovesTo(List<Integer> states);

    /**
     * Returns the set of states
     */
    public abstract Collection<Integer> getStates();

    /**
     * Returns initial state
     */
    public abstract Integer getInitialState();

    /**
     * @return true if <code>state</code> is an initial state
     */
    public boolean isInitialState(Integer state) {
        return getInitialState() == state;
    }

    // ------------------------------------------------------
    // Auxiliary protected functions
    // ------------------------------------------------------

    protected Collection<Tree<Integer>> getRuns(Integer currState, Tree<S> inputTree){
        Collection<Tree<Integer>> runs = new HashSet<Tree<Integer>>();
        for (Move<S> t : getMovesFrom(currState)) {
            if(!inputTree.getChildrenData().equals(t.to))
                continue;

            if(t.getRank() == 0)
                runs.add(new Tree<Integer>(currState));
            else {
                Iterator<Tree<S>> subTreeItr = inputTree.getSubTrees().iterator();
                Collection<Tree<Integer>> runs_move = new HashSet<Tree<Integer>>();
                for(Integer subState: t.to){
                    Collection<Tree<Integer>> subRuns = getRuns(subState,subTreeItr.next());
                    Collection<Tree<Integer>> runs_temp = new HashSet<Tree<Integer>>();
                    for(Tree<Integer> subRun:subRuns){
                        if(runs_move.size() ==0)
                            runs_temp.add(new Tree<Integer>(currState, subRun));
                        else {
                            for(Tree<Integer> partial: runs_move){
                                Tree<Integer> partial_temp = new Tree<Integer>(partial);
                                partial_temp.addChild(subRun);
                                runs_temp.add(partial_temp);
                            }
                        }
                    }
                    runs_move.addAll(runs_temp);
                }
                runs.addAll(runs_move);
            }
        }

        return runs;
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
