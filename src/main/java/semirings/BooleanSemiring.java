package semirings;

/**
 * Boolean semiring implementation.
 *
 * @author "Qinheping Hu"
 *
 */
public class BooleanSemiring extends Semiring<Float>{
    // zero value
    private static Float zero = 0.f;

    // one value
    private static Float one = 1.f;

    /*
     * (non-Javadoc)
     *
     * @see
     * edu.cmu.sphinx.fst.weight.AbstractSemiring#Plus(edu.cmu.sphinx.fst.weight
     * .Float, edu.cmu.sphinx.fst.weight.Float)
     */
    @Override
    public Float plus(Float w1, Float w2) {
        if (!isMember(w1) || !isMember(w2)) {
            return Float.NEGATIVE_INFINITY;
        }

        return w1 + w2;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * edu.cmu.sphinx.fst.weight.AbstractSemiring#Times(edu.cmu.sphinx.fst.weight
     * .Float, edu.cmu.sphinx.fst.weight.Float)
     */
    @Override
    public Float times(Float w1, Float w2) {
        if (!isMember(w1) || !isMember(w2)) {
            return Float.NEGATIVE_INFINITY;
        }

        return w1 * w2;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * edu.cmu.sphinx.fst.weight.AbstractSemiring#Divide(edu.cmu.sphinx.fst.
     * weight.Float, edu.cmu.sphinx.fst.weight.Float)
     */
    @Override
    public Float divide(Float w1, Float w2) {
        // TODO Auto-generated method stub
        return Float.NEGATIVE_INFINITY;
    }

    /*
     * (non-Javadoc)
     *
     * @see edu.cmu.sphinx.fst.weight.AbstractSemiring#zero()
     */
    @Override
    public Float zero() {
        return zero;
    }

    /*
     * (non-Javadoc)
     *
     * @see edu.cmu.sphinx.fst.weight.AbstractSemiring#one()
     */
    @Override
    public Float one() {
        return one;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * edu.cmu.sphinx.fst.weight.Semiring#isMember(edu.cmu.sphinx.fst.weight
     * .Float)
     */
    @Override
    public boolean isMember(Float w) {
        return !Float.isNaN(w) // not a NaN,
                && (w >= 0); // and positive
    }

    /*
     * (non-Javadoc)
     *
     * @see edu.cmu.sphinx.fst.semiring.Semiring#reverse(Float)
     */
    @Override
    public Float reverse(Float w1) {
        // TODO: ???
        System.out.println("Not Implemented");
        return Float.NEGATIVE_INFINITY;
    }
}
