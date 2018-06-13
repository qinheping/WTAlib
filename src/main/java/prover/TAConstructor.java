/**
 * TAConstructor
 * Jun 6 2018,
 * @author Qinheping Hu
 */

package prover;

import automata.fta.FTA;
import automata.fta.FTAMove;
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
    private Map<String, FuncDecl> funcDeclMap;

    private BoolExpr specification;
    private String synthFunSymbol;
    private FTA<String> grammarFTA;
    private FTA<String> anotatedFTA;
    private Integer numVars;
    private List<String> argList;
    private List<Sort> argSort_list;
    private Map<String, Sort> sortMap;

    private Set<List<Expr>> argPatterns;
    private Map<List<Integer>,Set<Integer>> abstractInputOutputExample;
    private List<FTA<String>> ftaList;
    private Map<String, Map<List<Integer>,Set<Integer>>> validTrans;

    public TAConstructor(Context ctx, GrammarNode grammar, TermNode specificationTerm, PredicateSet pSet, Map<String, FuncDecl> funcMap){
        this.grammar = grammar;
        this.ctx = ctx;
        this.pSet = pSet;
        this.specificationTerm = specificationTerm;
        grammarFTA = grammar.toFTA();

        // read args and argSort from grammar
        synthFunSymbol = grammar.getFunName();
        this.sortMap = new HashMap<>();
        this.argSort_list = new ArrayList<>();
        this.argList = grammar.getArgList_list();
        for(parser.SortNode sortNode: grammar.getArgSort_list()){
            this.argSort_list.add(ProverUtilities.parseSortNode2Sort(ctx, sortNode));
        }

        for(int i = 0; i < grammar.getArgSort_list().size(); i++){
            this.sortMap.put(grammar.getArgList_list().get(i),this.argSort_list.get(i));
        }
        System.out.println("sortmap: "+sortMap);

        // funcDeclMap
        this.funcDeclMap = funcMap;
        Sort[] sortArray = new Sort[argSort_list.size()];
        for(int i = 0; i < argSort_list.size(); i++){
            sortArray[i] = argSort_list.get(i);
        }
        funcDeclMap.put(synthFunSymbol,ctx.mkFuncDecl(synthFunSymbol, sortArray,ProverUtilities.parseSortNode2Sort(ctx,grammar.getFuncSort_node()) ));

        System.out.println("funcDeclmap: "+funcDeclMap);

        // parse specification term to expr
        this.specification = (BoolExpr) ProverUtilities.parseTerm2Expr(ctx, specificationTerm, this.sortMap, funcDeclMap);
        System.out.println("Spec: " +this.specification);

        // find all pattern v of f(v) in the specification
        this.argPatterns = findArgPatterns(specification, synthFunSymbol);
        System.out.println("argPatterns: "+argPatterns);

        // construct abstract input-output example
        final long startTime = System.currentTimeMillis();

        this.abstractInputOutputExample = new HashMap<>();
        produceAbstractInputOutput(new ArrayList<Integer>());
        System.out.println("abstract I-O: "+this.abstractInputOutputExample);


        final long endTime = System.currentTimeMillis();
        System.out.println("used time for abstract I-O: " + (endTime - startTime) );

        // construct ftas
        this.validTrans = new HashMap<>();
        this.ftaList = new ArrayList<>();
        for(List<Integer> inputAbstract: this.abstractInputOutputExample.keySet()){
            if(abstractInputOutputExample.get(inputAbstract).size() == 0)
                continue;
            ftaList.add(constructAbstractFTA(ctx,pSet,grammar.toFTA(),inputAbstract,abstractInputOutputExample.get(inputAbstract)));
        }

        visitTerm(specificationTerm);


        grammarFTA = grammar.toFTA();
        anotatedFTA = produceAntotateFTA();
    }

    private FTA<String> constructAbstractFTA(Context ctx, PredicateSet pSet, FTA fta, List<Integer> inputAbstract, Set<Integer> finalAbstracts) {
        FTA<String> result = new FTA<String>();
        Stack<Integer> toVisit = new Stack<>();

        // start from leaves
        for(Object move: fta.getLeafTransitions()){
            FTAMove<String> leafMove = (FTAMove) move;
            toVisit.push(leafMove.from);
            String operator = leafMove.symbol;
            // var
            if(this.argList.contains(operator)) {
                FTAMove newTransition = new FTAMove(transId(leafMove.from,inputAbstract.get(argList.indexOf(operator))),new ArrayList<>(),operator);
                result.addTransition(newTransition);
            }else{
                // constant
                Expr constant = ProverUtilities.parseString2Const(ctx, operator);
                BoolExpr newPre = ctx.mkEq(ctx.mkConst(ctx.mkSymbol(0),constant.getSort()),constant);
                pSet.addPredicate(newPre);
                int predIndex = -1;
                for(int i = 0; i < pSet.getSize(); i++){
                    if(pSet.getPredicate(i).equals(newPre)){
                        predIndex = i;
                        break;
                    }
                }
                result.addTransition(new FTAMove<>(transId(leafMove.from,predIndex),new ArrayList<>(),operator));
            }
        }

        while(!toVisit.isEmpty()){
            Integer currentState = toVisit.pop();
            for(Object move: fta.getMovesToContaints(currentState)){
                FTAMove<String> checkMove = (FTAMove) move;
                String operator = checkMove.symbol;
                Integer from = checkMove.from;
                List<Integer> to = checkMove.to;
                List<List<Integer>> predPattern = getPredPattern(result,to, new ArrayList<>());
                Set<Integer> validTo = checkTransValid(operator,predPattern);
            }
        }

        return result;
    }

    private Set<Integer> checkTransValid(String operator,List<List<Integer>> predPattern) {
        if(this.validTrans.get(operator) == null){
            this.validTrans.put(operator, new HashMap<>());
        }
        Map<List<Integer>,Set<Integer>> bucket = this.validTrans.get(operator);
        return null;

    }

    private List<List<Integer>> getPredPattern(FTA<String> fta, List<Integer> to, List<Integer> current) {
        List<List<Integer>> result = new ArrayList<>();
        if(current.size() < to.size()){
            Integer currentIndex = current.size();
            for(Integer anotatedState: fta.getStates()){
                if(transBack2State(anotatedState) == to.get(currentIndex)){
                    List<Integer> child = new ArrayList<>();
                    for(Integer st: current)
                        child.add(st);
                    child.add(transBack2Pred(anotatedState));
                    result.addAll(getPredPattern(fta,to,child));
                }
            }
        }else{
            result.add(current);
        }

        return result;
    }


    private void produceAbstractInputOutput(List<Integer> inputAbstract) {
        // internal node
        if(inputAbstract.size() < argSort_list.size()){
            for(int i = 0; i < this.pSet.getSize(); i++){
                List<Integer> child = new ArrayList<>();
                for(Integer input: inputAbstract)
                    child.add(input);
                child.add(i);
                produceAbstractInputOutput(child);
            }
            return;
        }

        // leaf
        Set<Integer> outputBucket = new HashSet<>();
        for(int i = 0; i < this.pSet.getSize(); i++){
            BoolExpr assertion = this.specification;

            for(List<Expr> pattern: this.argPatterns){
                Expr[] subVars = new Expr[pattern.size()+1];
                Expr[] subedVars = new Expr[pattern.size()+1];
                for(int j = 0; j < inputAbstract.size(); j++){
                    subedVars[0] = ctx.mkConst(ctx.mkSymbol(0),argSort_list.get(j));
                    subVars[0] = pattern.get(j);
                    for(int k = 0; k < pattern.size(); k++){
                        subVars[k+1] = pattern.get(k);
                        subedVars[k+1] = ctx.mkConst(ctx.mkSymbol(k+1),argSort_list.get(k));
                    }
                    assertion = ctx.mkAnd((BoolExpr) pSet.getPredicate(inputAbstract.get(j)).simplify().substitute(subedVars,subVars), assertion);
                }
                subVars[0] = ctx.mkApp(this.funcDeclMap.get(this.synthFunSymbol),(Expr[]) pattern.toArray());
                assertion = ctx.mkAnd(assertion, (BoolExpr) pSet.getPredicate(i).substitute(subedVars,subVars));
            }
            if(ProverUtilities.check(ctx,assertion) != null) {
                //System.out.println(assertion);
                outputBucket.add(i);
            }
        }
        this.abstractInputOutputExample.put(inputAbstract,outputBucket);
    }

    private Set<List<Expr>> findArgPatterns(Expr currentExpr, String targetFunc){
        Set<List<Expr>> result = new HashSet<>();
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

    private Integer transId(Integer state, Integer predicateIndex){
        return predicateIndex*this.grammarFTA.stateCount()+state+1;
    }
    private Integer transBack2Pred(Integer anoatedId){
        return (anoatedId-1)/this.grammarFTA.stateCount();
    }
    private Integer transBack2State(Integer anoatedId){
        return (anoatedId-1)%this.grammarFTA.stateCount();
    }

}
