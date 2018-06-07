package prover;

import com.microsoft.z3.*;

import java.util.ArrayList;
import java.util.List;

public class PredicateSet {
    private Context ctx;
    private List<Expr> predicateList;
    private List<String> symbolicArgumentsList;

    public PredicateSet(Context ctx, List<Expr> abList, List<String> saList){
        this.ctx = ctx;
        this.predicateList = abList;
        this.symbolicArgumentsList = saList;
    }

    public PredicateSet(Context ctx, List<String> saList){
        this(ctx, new ArrayList<>(), saList);
    }

    public PredicateSet(Context ctx){
        this(ctx, new ArrayList<>(),new ArrayList<>());
    }

    public void addPredicate(Expr newPredicate){
        for(Expr predicate : this.predicateList){
            BoolExpr eq = ctx.mkEq(predicate,newPredicate);
            eq = ctx.mkNot(eq);
            if(check(ctx,eq) == null)
                return;
        }
        this.predicateList.add(newPredicate);
    }

    public Integer getSize(){
        return this.predicateList.size();
    }

    /**
     * Check if the given expression <code>f</code> is satisfiable
     * @param ctx   Context
     * @param f     Expression to check
     * @return      null if unsat,
     *              model if sat
     */
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
