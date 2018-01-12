package semirings;

/**
 * Tropical semiring implementation.
 *
 * @author "John Salatas"
 *
 */
public class TropicalSemiring extends Semiring <Float>{

    // zero value
    private static Float zero = Float.POSITIVE_INFINITY;

    // one value
    private static Float one = 0.f;

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

        return w1 < w2 ? w1 : w2;
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

        return w1 + w2;
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
        if (!isMember(w1) || !isMember(w2)) {
            return Float.NEGATIVE_INFINITY;
        }

        if (w2 == zero) {
            return Float.NEGATIVE_INFINITY;
        } else if (w1 == zero) {
            return zero;
        }

        return w1 - w2;
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
     * edu.cmu.sphinx.fst.weight.AbstractSemiring#isMember(edu.cmu.sphinx.fst
     * .weight.Float)
     */
    @Override
    public boolean isMember(Float w) {
        return (!Float.isNaN(w)) // not a NaN
                && (w != Float.NEGATIVE_INFINITY); // and different from -inf
    }

    public boolean lessThan(Float w1, Float w2) {
        return w1 < w2;
    }

    /*
     * (non-Javadoc)
     *
     * @see edu.cmu.sphinx.fst.semiring.Semiring#reverse(Float)
     */
    @Override
    public Float reverse(Float w1) {
        return w1;
    }
}