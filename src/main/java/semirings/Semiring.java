package semirings;

import java.util.List;

/**
 * Abstract semiring class.
 *
 * @author "John Salatas"
 *
 */
public abstract class Semiring<R>{
    // significant decimal digits in Ring point numbers
    protected static final int accuracy = 5;


    public abstract R plus(R w1, R w2);

    public abstract R reverse(R w1);

    public abstract R times(R w1, R w2);


    public abstract R divide(R w1, R w2);

    public abstract R zero();

    public abstract R one();

    public abstract boolean isMember(R w);

    public abstract boolean lessThan(R w1, R w2);

    public boolean lessOrEqual(R w1, R w2){
        if (w1==w2 || lessThan(w1, w2))
            return true;
        else
            return false;
    }

    public R times(List<R> wList){
        R result = this.one();
        for(R w: wList){
            result = this.times(result, w);
        }
        return result;
    }



    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().toString();
    }

    /**
     * NATURAL ORDER
     *
     * By definition: a &lt;= b iff a + b = a
     *
     * The natural order is a negative partial order iff the semiring is
     * idempotent. It is trivially monotonic for plus. It is left (resp. right)
     * monotonic for times iff the semiring is left (resp. right) distributive.
     * It is a total order iff the semiring has the path property.
     *
     * See Mohri,
     * "Semiring Framework and Algorithms for Shortest-Distance Problems",
     * Journal of Automata, Languages and Combinatorics 7(3):321-350, 2002.
     *
     * We define the strict version of this order below.
     *
     * @param w1 first operand
     * @param w2 second operand
     * @return less or more
     */
    public boolean naturalLess(R w1, R w2) {
        return (plus(w1, w2) == w1) && (w1 != w2);
    }

}