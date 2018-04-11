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

    public String sort;

    /**
     * Transition from state <code>from</code> to state <code>to</code>
     */
    public Move(Integer from, List<Integer> to, S symbol) {
        this.from = from;
        this.to = to;
        this.symbol = symbol;
    }
    public Move(Integer from, List<Integer> to, S symbol, String sort){
        this(from, to, symbol); this.sort = sort;
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
    @Override
    public int hashCode(){
//        int result = 0;
//        for(Integer toNode : to){
//            result += toNode.hashCode();
//        }
//        return this.from.hashCode() + result;
        return  0 ;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Move<S> move = (Move<S>) o;
        if (move.to.size() != this.to.size())
            return  false;
        // field comparison
        for(int i = 0; i < move.to.size(); i++){
            if(move.to.get(i) != this.to.get(i))
                return false;
        }
        return (move.from == this.from) && (move.symbol.equals(this.symbol));
    }
}