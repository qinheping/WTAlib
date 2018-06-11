/**
 * TAConstructor
 * Jun 6 2018,
 * @author Qinheping Hu
 */

package prover;

import automata.fta.FTA;
import com.microsoft.z3.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import parser.GrammarNode;
import parser.SortNode;
import parser.TermNode;

import java.lang.reflect.Array;
import java.util.*;

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
    private List<Sort> argSort_list;
    private Map<String, Sort> sortMap;

    private List<List<Expr>> argPatterns;
    private Map<List<Integer>,Set<Integer>> abstractInputOutputExample;

    public TAConstructor(Context ctx, GrammarNode grammar, TermNode specificationTerm, PredicateSet pSet, Map<String, FuncDecl> funcDeclMap){
        this.grammar = grammar;
        this.ctx = ctx;
        this.pSet = pSet;
        this.specificationTerm = specificationTerm;

        // read args and argSort from grammar
        synthFunSymbol = grammar.getFunName();
        argSort_list = new ArrayList<>();
        this.sortMap = new HashMap<>();
        for(int i = 0; i < argSort_list.size(); i++){
            this.sortMap.put(grammar.getArgList_list().get(i),this.argSort_list.get(i));
        }

        // funcDeclMap
        for(parser.SortNode sortNode: grammar.getArgSort_list()){
            ProverUtilities.parseSortNode2Sort(ctx, sortNode);
        }
        funcDeclMap.put(synthFunSymbol,ctx.mkFuncDecl(synthFunSymbol, (Sort[]) argSort_list.toArray(),ProverUtilities.parseSortNode2Sort(ctx,grammar.getFuncSort_node()) ));

        // parse specification term to expr
        this.specification = (BoolExpr) ProverUtilities.parseTerm2Expr(ctx, specificationTerm, this.sortMap, funcDeclMap);

        // find all pattern v of f(v) in the specification
        this.argPatterns = findArgPatterns(specification, synthFunSymbol);

        // construct abstract input-output example
        produceAbstractInputOutput(new ArrayList<Integer>());

        visitTerm(specificationTerm);


        grammarFTA = grammar.toFTA();
        anotatedFTA = produceAntotateFTA();
    }

    private void produceAbstractInputOutput(List<Integer> inputAbstract) {
        // internal node
        if(inputAbstract.size() < argSort_list.size()){
            for(int i = 0; i < this.pSet.getSize()-1; i++){
                List<Integer> child = new ArrayList<>();
                for(Integer input: inputAbstract)
                    child.add(input);
                child.add(i);
                produceAbstractInputOutput(child);
            }
            return;
        }

        // leaf
        for(int i = 0; i < this.pSet.getSize()-1; i++){
            BoolExpr assertion = ctx.mkTrue();
            for(int j = 0; j < inputAbstract.size()-1; j++){
                assertion = ctx.mkAnd()
            }
        }
    }

    private List<List<Expr>> findArgPatterns(Expr currentExpr, String targetFunc){
        List<List<Expr>> result = new ArrayList<>();
        if(currentExpr.getNumArgs() == 0)
            return result;
        if(currentExpr.getFuncDecl().getName().toString().equals(targetFunc)){
            result.add(Arrays.asList(currentExpr.getArgs()));
        }
        for(Expr arg: currentExpr.getArgs()){
            result.addAll(findArgPatterns(arg,targetFunc));
        }
        return result;
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
