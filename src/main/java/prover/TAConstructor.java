/**
 * TAConstructor
 * Jun 6 2018,
 * @author Qinheping Hu
 */

package prover;

import automata.fta.FTA;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import parser.GrammarNode;
import parser.TermNode;

public class TAConstructor {
    private GrammarNode grammar;
    private TermNode specificationTerm;
    private PredicateSet pSet;
    private Context ctx;

    private BoolExpr specification;
    private String synthFunSymbol;
    private FTA<String> grammarFTA;
    private FTA<String> anotatedFTA;
    private Integer numVars;

    public TAConstructor(Context ctx, GrammarNode grammar, TermNode specificationTerm, PredicateSet pSet){
        this.grammar = grammar;
        this.ctx = ctx;
        this.pSet = pSet;
        this.specificationTerm = specificationTerm;

        synthFunSymbol = grammar
        visitTerm(specificationTerm);


        grammarFTA = grammar.toFTA();
        anotatedFTA = produceAntotateFTA();
    }

    private void visitTerm(TermNode specificationTerm) {

    }

    private FTA<String> produceAntotateFTA() {
        anotatedFTA = new FTA<>();
        return null;
    }

    private Integer translateToAntoatedId(Integer state, Integer predicateIndex){
        return predicateIndex+this.pSet.getSize()*state;
    }

}
