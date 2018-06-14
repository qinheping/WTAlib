/**
 * PredicateSet
 * Jun 6 2018,
 * @author Qinheping Hu
 */

package prover;

import com.microsoft.z3.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PredicateSet {
    private Context ctx;
    private ArrayList<BoolExpr> predicateList;
    private List<String> symbolicArgumentsList;

    public PredicateSet(Context ctx, ArrayList<BoolExpr> abList, List<String> saList){
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
                if(ProverUtilities.check(ctx,eq) == null) {
                    return;
                }
            }
            catch (Z3Exception e){
                continue;
            }
        }
        this.predicateList.add((BoolExpr)newPredicate.simplify());
    }

    public BoolExpr getPredicate(int index){
        if(index == -1)
            return ctx.mkTrue();
        if(index == -2)
            return ctx.mkFalse();
        return this.predicateList.get(index);
    }

    public Integer getSize(){
        return this.predicateList.size();
    }

    @Override
    public String toString(){
        return this.predicateList.toString();
    }

    public PredicateSet minTerminize() {
        HashSet<Pair<BoolExpr,ArrayList<Integer>>> minterms = new HashSet<>();
        ProverUtilities.getMintermsRec(ctx,this.predicateList,0,ctx.mkTrue(),new ArrayList<>(),minterms);
        this.predicateList = new ArrayList<>();
        for(Pair<BoolExpr,ArrayList<Integer>> pair: minterms){
            this.predicateList.add((BoolExpr) pair.first.simplify());
        }
        return this;

    }
}
