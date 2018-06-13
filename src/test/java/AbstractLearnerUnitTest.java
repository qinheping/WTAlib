import com.microsoft.z3.*;
import parser.TermNode;
import prover.AbstractLearner;
import prover.PredicateSet;
import prover.TAConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractLearnerUnitTest {

    @org.junit.Test
    public void testPredicateSet() {
        Context ctx = new Context();
        PredicateSet pSet = new PredicateSet(ctx);
        assert (pSet.getSize() == 0);
        pSet.addPredicate(ctx.mkLt((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(1)));
        assert (pSet.getSize() == 2);
        pSet.addPredicate(ctx.mkLt(ctx.mkInt(1),(ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort())));
        assert (pSet.getSize() == 4);
        pSet.addPredicate(ctx.mkLt(ctx.mkInt(2),(ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort())));
        assert (pSet.getSize() == 6);
        pSet.addPredicate(ctx.mkLt((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(2)));
        assert (pSet.getSize() == 6);
        System.out.println(ctx.mkAnd(ctx.mkLt((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(2)),ctx.mkLt((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(1))));
        System.out.println(ctx.mkAnd(ctx.mkLt((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(2)),ctx.mkLt((ArithExpr) ctx.mkConst(ctx.mkSymbol(0),
                ctx.mkIntSort()),ctx.mkInt(1))).getFuncDecl());

    }

    @org.junit.Test
    public void testLearner() {
        Context ctx = new Context();
        TermNode condition = new TermNode("<",new TermNode("x"),new TermNode("y"));
        TermNode tree = new TermNode("ite",condition, new TermNode("+",new TermNode("y"),new TermNode("1")), new TermNode("x"));
        System.out.println(tree);
        List<String> args = new ArrayList<>();
        args.add("x");
        args.add("y");
        AbstractLearner abL = new AbstractLearner(ctx,args,tree,ctx.mkIntSort());
        System.out.println(abL.learn());
    }

  

    Model check(Context ctx, BoolExpr f)
    {
        Solver s = ctx.mkSolver();
        s.add(f);
        if (s.check() == Status.SATISFIABLE)
            return s.getModel();
        else
            return null;
    }
}
