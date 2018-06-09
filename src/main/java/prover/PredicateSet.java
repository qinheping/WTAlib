/**
 * PredicateSet
 * Jun 6 2018,
 * @author Qinheping Hu
 */

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

    public void addPredicate(BoolExpr newPredicate){
        for(Expr predicate : this.predicateList){
            try{
            BoolExpr eq = ctx.mkEq(predicate,newPredicate);
                eq = ctx.mkNot(eq);
                if(check(ctx,eq) == null) {
                    return;
                }
            }
            catch (Z3Exception e){
                continue;
            }
        }
        this.predicateList.add(newPredicate.simplify());
        addPredicate(ctx.mkNot( newPredicate));
    }

    public Integer getSize(){
        return this.predicateList.size();
    }

    @Override
    public String toString(){
        return this.predicateList.toString();
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
