package automata;

import java.util.List;

/**
 * Abstract automaton move
 *
 *  @param <S>
 *      domain of the automaton alphabet
 *
 *  @param <R>
 *      semiring
 */

public abstract class Move<S> {
    // Source state
    public Integer from;
    // Target state
    public List<Integer> to;
    // Consumed symbol
    public S symbol;

    /**
     * Transition from state <code>from</code> to state <code>to</code>
     */
    public Move(Integer from, List<Integer> to, S symbol) {
        this.from = from;
        this.to = to;
        this.symbol = symbol;
    }

    /**
     * Create the dot representation of the move
     */
    public abstract String toDotString();

    /**
     *  @return the arity of this move
     */
    public Integer getRank(){
        if(to == null)
            return 0;
        return to.size();
    }
}
