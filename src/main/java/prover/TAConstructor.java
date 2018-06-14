/**
 * TAConstructor
 * Jun 6 2018,
 * @author Qinheping Hu
 */

package prover;

import automata.fta.FTA;
import automata.fta.FTAMove;
import com.microsoft.z3.*;
import parser.GrammarNode;
import parser.TermNode;

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

    /**
     *  Construct FTA that input variables satisfy predicate vector inputAbstract and the root satisfies finalAbstracts
     * @param ctx
     * @param pSet  Predicate set
     * @param fta   Grammar FTA
     * @param inputAbstract
     * @param finalAbstracts
     * @return
     */
    private FTA<String> constructAbstractFTA(Context ctx, PredicateSet pSet, FTA fta, List<Integer> inputAbstract, Set<Integer> finalAbstracts) {
        FTA<String> result = new FTA<String>();
        Stack<Integer> toVisit_annotated = new Stack<>();
        Set<Integer> visited_annotated = new HashSet<>();

        // start from leaves
        for(Object move: fta.getLeafTransitions()){
            FTAMove<String> leafMove = (FTAMove) move;
            String operator = leafMove.symbol;
            // var
            if(this.argList.contains(operator)) {
                FTAMove newTransition = new FTAMove(transId(leafMove.from,inputAbstract.get(argList.indexOf(operator))),new ArrayList<>(),operator);
                result.addTransition(newTransition);
            }else{
                // constant
                Expr constant = ProverUtilities.parseString2Const(ctx, operator);
                for(int i  = 0; i < pSet.getSize(); i++) {
                    // try to construct assertion phi_i(x/constant) is satisfiable
                    BoolExpr checkConst;
                    try{ checkConst = (BoolExpr) pSet.getPredicate(i).simplify().substitute(ctx.mkConst(ctx.mkSymbol(0),constant.getSort()),constant);}
                    catch (com.microsoft.z3.Z3Exception e) { continue; }
                    if(null != ProverUtilities.check(ctx, checkConst)){
                        result.addTransition(new FTAMove<>(transId(leafMove.from, i), new ArrayList<>(), operator));
                        toVisit_annotated.push(transId(leafMove.from, i));
                    }
                }
            }
        }
        System.out.println(result);

        // internal nodes
        while(!toVisit_annotated.isEmpty()){
            // start visit current State
            Integer currentState_annotated = toVisit_annotated.pop();
            visited_annotated.add(currentState_annotated);
            System.out.println("Current state: "+currentState_annotated + " state:" + transBack2State(currentState_annotated)+ " pred: "+transBack2Pred(currentState_annotated));

            // for each original move, construct some new move
            for(Object move: fta.getMovesToContaints(transBack2State(currentState_annotated))){
                FTAMove<String> currentMove = (FTAMove) move;
                System.out.println("currentMove: "+ currentMove.toString() );
                String operator = currentMove.symbol;
                Integer from = currentMove.from;
                List<Integer> to = currentMove.to;
                List<List<Integer>> predPatterns = getPredPatternRec(visited_annotated,to, new ArrayList<>(), currentState_annotated,false);

                System.out.println("predPatterns: "+ predPatterns);
                for(List<Integer> predPattern: predPatterns){
                    Set<Integer> validTo = checkTransValid(operator,predPattern);
                }
            }
        }

        return result;
    }

    private Set<Integer> checkTransValid(String operator,List<Integer> predPattern) {
        Set<Integer> result;
        this.validTrans.putIfAbsent(operator,new HashMap<>());
        Map<List<Integer>,Set<Integer>> bucket = this.validTrans.get(operator);

        bucket.putIfAbsent(predPattern, new HashSet<>());
        result = bucket.get(predPattern);

        for(int i = 0; i < pSet.getSize(); i++){
            // predicate of the parent
            Expr predTo = pSet.getPredicate(i);
            Sort subsSort = ProverUtilities.getSortFromExpr(predTo,ctx.mkConst(ctx.mkSymbol(0),ctx.mkIntSort()).toString());
            predTo = predTo.simplify().substitute(ctx.mkConst(ctx.mkSymbol(0),subsSort),ctx.mkConst("T",subsSort));

            // predicate of transformer


            for(int j = 0; j <  predPattern.size(); j++){

            }
        }

        return null;

    }

    private List<List<Integer>> getPredPatternRec(Set<Integer> annotatedStates_set, List<Integer> to, List<Integer> currentPredPattern, Integer targetState_annotated, boolean hitted) {
        List<List<Integer>> result = new ArrayList<>();
        // PredPattern not full
        if(currentPredPattern.size() < to.size()){
            Integer currentIndex = currentPredPattern.size();
            for(Integer annotatedState: annotatedStates_set){
                // if annotatedState == to[i], add Pred(annotated) to currentPredPattern
                if(transBack2State(annotatedState) == to.get(currentIndex)){
                    List<Integer> child = new ArrayList<>(currentPredPattern);
                    child.add(transBack2Pred(annotatedState));
                    result.addAll(getPredPatternRec(annotatedStates_set,to,child, targetState_annotated, (annotatedState == targetState_annotated) || hitted));
                }
            }
        }else{
            if(hitted)
            result.add(currentPredPattern);
        }

        return result;
    }


    private void produceAbstractInputOutput(List<Integer> inputAbstract) {
        // internal node
        if(inputAbstract.size() < argSort_list.size()){
            for(int i = 0; i < this.pSet.getSize(); i++){
                List<Integer> child = new ArrayList<>(inputAbstract);
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
                Expr[] pattern_array = new Expr[pattern.size()];
                for(int j = 0; j < pattern.size(); j++) pattern_array[j] = pattern.get(j);
                subVars[0] = ctx.mkApp(this.funcDeclMap.get(this.synthFunSymbol),pattern_array);
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
