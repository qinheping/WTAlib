package automata;

/**
 *  Automata abstract class
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
    protected boolean isEpsilonFree;
    protected boolean isTotal;

    public Automaton() {
        isEmpty = false;
        isDeterministic = false;
        isEpsilonFree = true;
        isTotal = false;
    }

    public String toString(){
        //TODO: implement this
        return null;
    }


}
