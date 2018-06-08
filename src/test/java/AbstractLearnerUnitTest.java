import com.microsoft.z3.*;
import prover.PredicateSet;

import java.util.HashMap;
import java.util.Map;

public class AbstractLearnerUnitTest {

    @org.junit.Test
    public void testPredicateSet() {
        Context ctx = new Context();
        PredicateSet pSet = new PredicateSet(ctx);
        assert (pSet.getSize() == 0);
        pSet.addPredicate(ctx.mkAdd((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(1)));
        assert (pSet.getSize() == 1);
        pSet.addPredicate(ctx.mkAdd(ctx.mkInt(1),(ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort())));
        assert (pSet.getSize() == 1);
        pSet.addPredicate(ctx.mkAdd(ctx.mkInt(2),(ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort())));
        assert (pSet.getSize() == 2);
        pSet.addPredicate(ctx.mkAdd((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(2)));
        assert (pSet.getSize() == 2);
    }
}
