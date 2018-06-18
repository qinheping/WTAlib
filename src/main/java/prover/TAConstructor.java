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
import parser.TermNode;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.System.exit;
import static java.lang.System.out;

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

    private final static int SATISFIABILITY = 0;
    private final static int IMPLICATION = 1;
    private int SMTMod = 0;

    private final static int FTACLASS = 0;
    private final static int VATA = 1;
    private int ftaMod = 1;


    public TAConstructor(Context ctx, GrammarNode grammar, TermNode specificationTerm, PredicateSet pSet, Map<String, FuncDecl> funcMap){
        this.grammar = grammar;
        this.ctx = ctx;
        this.pSet = pSet;
        System.out.println("predicate set: "+ pSet);
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
        System.out.println("argPatterns: "+this.argPatterns);

        // construct abstract input-output example
        final long startTime = System.currentTimeMillis();

        this.abstractInputOutputExample = new HashMap<>();
        produceAbstractInputOutput(new ArrayList<Integer>());
        System.out.println("abstract I-O: ");
        for(List<Integer> key: this.abstractInputOutputExample.keySet()){
            if(this.abstractInputOutputExample.get(key).size() != 0)
                System.out.print(key + "->" + this.abstractInputOutputExample.get(key)+ " ");
        }
        System.out.println();

        final long endTime = System.currentTimeMillis();
        System.out.println("used time for abstract I-O: " + (endTime - startTime) );

        // construct ftas
        this.validTrans = new HashMap<>();
        this.ftaList = new ArrayList<>();
        for(List<Integer> inputAbstract: this.abstractInputOutputExample.keySet()){
            if(abstractInputOutputExample.get(inputAbstract).size() == 0)
                continue;
            FTA newFTA = constructAbstractFTA(ctx,pSet,grammar.toFTA(),inputAbstract,abstractInputOutputExample.get(inputAbstract));
            System.out.print("original fta: "+newFTA.getTransitionCount()+" "+newFTA.stateCount());
            FTA reducedFTA = ProverUtilities.reduceFTA(newFTA);
            System.out.print("redu fta: "+ reducedFTA.getTransitionCount()+ " "+ reducedFTA.stateCount());

            FTA detReducedFTA = ProverUtilities.reduceFTA(reducedFTA.determinization());
            System.out.print("det redu fta: "+ detReducedFTA.getTransitionCount()+ " "+ detReducedFTA.stateCount());
            ftaList.add(detReducedFTA);
        }

        // print valid trans
        System.out.println(this.validTrans);

        sortFTAList();
        FTA<String> ftaIntersection = new FTA<>();

        while(ftaList.size()>1){
            switch(this.ftaMod){
                case FTACLASS:
                    ftaIntersection = ProverUtilities.reduceFTA(ftaList.get(0).intersectionWith(ftaList.get(1)));
                    break;
                case VATA:
                    ftaIntersection = ProverUtilities.reduceFTA(ProverUtilities.callVata(ftaList.get(0),ftaList.get(1),"isect"));
                    break;
                default: System.out.print("wrong mode. exit");
                    exit(1);
            }
            ftaList.remove(0);
            ftaList.remove(0);
            if(ProverUtilities.isConstantFTA(ftaIntersection)){
                ftaList.add(0,ftaIntersection);
                break;
            }
            ftaList.add(ftaIntersection);
            sortFTAList();
            System.out.println(ftaIntersection.toTimbukString());
        }

        System.out.println(ftaList.get(0));

        grammarFTA = grammar.toFTA();
        anotatedFTA = produceAnnotateFTA();
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
                //System.out.println("currentMove: "+ currentMove.toString() );
                String operator = currentMove.symbol;
                Integer from = currentMove.from;
                List<Integer> to = currentMove.to;
                List<List<Integer>> predPatterns = getPredPatternRec(visited_annotated,to, new ArrayList<>(), currentState_annotated,false);

                //System.out.println("predPatterns: "+ predPatterns);
                for(List<Integer> predPattern: predPatterns){
                    Set<Integer> validTo = checkTransValid(operator,predPattern);
                    for(Integer predTo: validTo){
                        List<Integer> to_annotated = new ArrayList<>();
                        for(Integer pred: predPattern){
                            to_annotated.add(transId(to.get(predPattern.indexOf(pred)),pred));
                        }
                        result.addTransition(new FTAMove<String>(transId(from,predTo),to_annotated,operator));
                    }
                }
            }
        }
        result.setInitialState(0);
        Set<Integer> newInitial_annotated = new HashSet<>();
        for(Integer state_annotated: (Collection<Integer>)result.getStates()){
            if(fta.getInitialState() != transBack2State(state_annotated))
                continue;
            if(!finalAbstracts.contains(transBack2Pred(state_annotated)))
                continue;
            newInitial_annotated.add(state_annotated);
        }
        for(Integer state_annotated: newInitial_annotated)
            result.addTransition(new FTAMove<String>(0,state_annotated,""));

        result.clean();
        //System.out.println("fta: "+ result.toTimbukString());
        return result;
    }

    private Set<Integer> checkTransValid(String operator,List<Integer> predPattern) {
        Set<Integer> result;
        this.validTrans.putIfAbsent(operator,new HashMap<>());
        Map<List<Integer>,Set<Integer>> bucket = this.validTrans.get(operator);

        if(bucket.get(predPattern) != null){
            return bucket.get(predPattern);
        }

        bucket.putIfAbsent(predPattern, new HashSet<>());
        result = bucket.get(predPattern);

        // predicate of the from
        BoolExpr predFrom = ctx.mkTrue();
        for(int j = 0; j <  predPattern.size(); j++){
            Sort subsSort = ProverUtilities.getSortFromExpr(pSet.getPredicate(predPattern.get(j)),ctx.mkConst(ctx.mkSymbol(0),ctx.mkIntSort()).toString());
            predFrom = ctx.mkAnd(predFrom,
                    (BoolExpr)pSet.getPredicate(predPattern.get(j)).simplify().substitute(ctx.mkConst(ctx.mkSymbol(0),subsSort),ctx.mkConst("T"+j,subsSort)));
        }

        // special case: ite
        if(operator.equals("ite")){
                result.add(predPattern.get(0) == -1?predPattern.get(1):predPattern.get(2)); // true return 1 false return 2
                return result;
        }

        // predicate of transformer
        List<String> args = new ArrayList<>();
        for(int j = 0; j < predPattern.size();j++)
            args.add("T"+j);
        BoolExpr predTrans = ProverUtilities.generateTermFromOperator(ctx,operator,"T",args);

        // predicate of output
        if(ProverUtilities.isOutputBool(operator)){
            for(int i = -2;  i <0;i++){
                // predicate of the parent
                BoolExpr predTo = pSet.getPredicate(i);
                Sort subsSort = ProverUtilities.getSortFromExpr(predTo, ctx.mkConst(ctx.mkSymbol(0), ctx.mkIntSort()).toString());
                subsSort = subsSort==null?ctx.mkBoolSort():subsSort;
                predTo = (BoolExpr) predTo.simplify().substitute(ctx.mkConst(ctx.mkSymbol(0), subsSort), ctx.mkConst("T", subsSort));

                if (ProverUtilities.IsSatisfiable(ctx,ctx.mkAnd(predFrom, predTrans)) && checkRelation(ctx.mkAnd(predFrom, predTrans), predTo))
                    result.add(i);
            }
        }else {
            for (int i = 0; i < pSet.getSize(); i++) {
                // predicate of the parent
                BoolExpr predTo = pSet.getPredicate(i);
                Sort subsSort = ProverUtilities.getSortFromExpr(predTo, ctx.mkConst(ctx.mkSymbol(0), ctx.mkIntSort()).toString());
                if(subsSort == null) {
                    System.out.println("wrong sort. exit");
                    exit(1);
                }
                predTo = (BoolExpr) predTo.simplify().substitute(ctx.mkConst(ctx.mkSymbol(0), subsSort), ctx.mkConst("T", subsSort));

                if (ProverUtilities.IsSatisfiable(ctx,ctx.mkAnd(predFrom, predTrans)) && checkRelation(ctx.mkAnd(predFrom, predTrans), predTo))
                    result.add(i);
            }
        }
        //System.out.println(operator +" "+predPattern+ " "+result);

        return result;

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
            BoolExpr assertion = (BoolExpr)this.specification.simplify();
            BoolExpr outputAssert = ctx.mkTrue();

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
                    BoolExpr inputAssert = (BoolExpr) pSet.getPredicate(inputAbstract.get(j)).simplify().substitute(subedVars,subVars);
                    if(inputAbstract.get(0)==2 &&inputAbstract.get(1)==2 )System.out.println("inputassert: "+j +" "+inputAssert.simplify()+" pset "+ pSet.getPredicate(inputAbstract.get(j)).simplify());
                    assertion = (BoolExpr)ctx.mkAnd((BoolExpr) pSet.getPredicate(inputAbstract.get(j)).simplify().substitute(subedVars,subVars), assertion).simplify();

                }
                Expr[] pattern_array = new Expr[pattern.size()];
                for(int j = 0; j < pattern.size(); j++) pattern_array[j] = pattern.get(j);
                subVars[0] = ctx.mkApp(this.funcDeclMap.get(this.synthFunSymbol),pattern_array);
                outputAssert = (BoolExpr)ctx.mkAnd(outputAssert, (BoolExpr) pSet.getPredicate(i).substitute(subedVars,subVars)).simplify();
            }
            if(ProverUtilities.IsSatisfiable(ctx,assertion) && checkRelation(assertion,outputAssert)) {
                outputBucket.add(i);
            }
        }
        this.abstractInputOutputExample.put(inputAbstract,outputBucket);
    }

    /**
     * mod sat: return sat(expr1 and expr2)
     * mod imp: return (expr1 -> expr2)
     * @param expr1 first expr
     * @param expr2 second expr
     * @return return sat or imp
     */
    private boolean checkRelation(BoolExpr expr1,BoolExpr expr2){
        switch (this.SMTMod){
            case SATISFIABILITY:
                return ProverUtilities.check(ctx,ctx.mkAnd(expr1,expr2)) != null;
            case IMPLICATION:
                return ProverUtilities.check(ctx,ctx.mkNot(ctx.mkOr(expr2,ctx.mkNot(expr1)))) == null;

        }
        return false;
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

    private FTA<String> produceAnnotateFTA() {
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
    private void sortFTAList(){
        this.ftaList.sort(Comparator.comparing(FTA::getTransitionCount));
    }

}
