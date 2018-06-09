/**
 * AbstractLearner
 * Jun 6 2018,
 * @author Qinheping Hu
 */
package prover;

import parser.TermNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.microsoft.z3.*;


/**
 * An abstract learner that reads a term and learns abstract
 */

public class AbstractLearner {

    private List<String> symbolicArguments;
    private TermNode currentProgram;
    private PredicateSet predicateSet;
    private Context ctx;
    private Map<String, Sort> sortMap;


    /**
     * Construct an abstract learner
     */
    public AbstractLearner(Context ctx,List<String> symbolicArguments, TermNode program, Map<String,Sort> sortMap){
        this.currentProgram = program;
        this.symbolicArguments = symbolicArguments;
        this.ctx = ctx;
        this.predicateSet = new PredicateSet(ctx);
        this.sortMap = sortMap;
    }
    public AbstractLearner(Context ctx,List<String> symbolicArguments, TermNode program, Sort sort){
        this(ctx,symbolicArguments, program, new HashMap<>());
        for(String argument : symbolicArguments){
            this.sortMap.put(argument,sort);
        }
    }

    public PredicateSet learn(){
        learnFromTerm(this.currentProgram);
        return this.predicateSet;
    }

    /**
     * Recursively learn predicates from term node by node
     * @param term current node
     * @return predicates learnt from children
     */
     public List<Expr> learnFromTerm(TermNode term){
         String operator = term.getSymbol(); // current operator
         List<Expr> predicateCandidates = new ArrayList();

         System.out.println(term);

         // branch operator
         if(operator.equals("ite")){
             learnFromTerm(term.getChildren().get(0));
             predicateCandidates.addAll(learnFromTerm(term.getChildren().get(1)));  // true branch
             predicateCandidates.addAll(learnFromTerm(term.getChildren().get(2)));  // false branch
             return predicateCandidates;
         }

         // Binary operator TODO: make it switch
         if(term.getChildren().size() == 2){
             List<Expr> predicate_Children0 = learnFromTerm(term.getChildren().get(0));
             List<Expr> predicate_Children1 = learnFromTerm(term.getChildren().get(1));
             // combine both child
             for(int i = 0; i < predicate_Children0.size(); i++){
                 for(int j = 0; j < predicate_Children1.size(); j++) {
                     Expr expri = predicate_Children0.get(i);
                     Expr exprj = predicate_Children1.get(j);
                     Expr substVar = ctx.mkConst(ctx.mkSymbol(0),expri.getSort());
                     switch (operator) {
                         case "+" :
                             this.predicateSet.addPredicate(ctx.mkEq(substVar,ctx.mkAdd((ArithExpr) expri, (ArithExpr) exprj)));
                             predicateCandidates.add(ctx.mkAdd((ArithExpr) expri, (ArithExpr) exprj));
                             break;
                         case "-" :
                             this.predicateSet.addPredicate(ctx.mkEq(substVar,ctx.mkSub((ArithExpr) expri, (ArithExpr) exprj)));
                             predicateCandidates.add(ctx.mkSub((ArithExpr) expri, (ArithExpr) exprj));
                             break;
                         case "=" :
                             predicateCandidates.add(ctx.mkEq(expri,exprj));
                             break;
                         case "<" :
                             this.predicateSet.addPredicate(ctx.mkLt((ArithExpr) substVar, (ArithExpr) exprj));
                             this.predicateSet.addPredicate(ctx.mkLt((ArithExpr) expri, (ArithExpr) substVar));
                             predicateCandidates.add(ctx.mkLt((ArithExpr) expri,  (ArithExpr) exprj));
                             break;
                         case "<=" :
                             this.predicateSet.addPredicate(ctx.mkLe((ArithExpr) substVar, (ArithExpr) exprj));
                             this.predicateSet.addPredicate(ctx.mkLe((ArithExpr) expri, (ArithExpr) substVar));
                             predicateCandidates.add(ctx.mkLe((ArithExpr) expri,  (ArithExpr) exprj));
                         case ">" :
                             this.predicateSet.addPredicate(ctx.mkGt((ArithExpr) substVar, (ArithExpr) exprj));
                             this.predicateSet.addPredicate(ctx.mkGt((ArithExpr) expri, (ArithExpr) substVar));
                             predicateCandidates.add(ctx.mkGt((ArithExpr) expri,  (ArithExpr) exprj));
                             break;
                         case ">=" :
                             this.predicateSet.addPredicate(ctx.mkGe((ArithExpr) substVar, (ArithExpr) exprj));
                             this.predicateSet.addPredicate(ctx.mkGe((ArithExpr) expri, (ArithExpr) substVar));
                             predicateCandidates.add(ctx.mkGe((ArithExpr) expri,  (ArithExpr) exprj));
                             break;
                         default:
                             return predicateCandidates;
                     }
                 }
             }
         }


         // Unary operator

         // Leaf
         if(term.getChildren()==null || term.getChildren().size()==0){
             if(this.symbolicArguments.contains(operator)){ // variable
                 Expr substVar = ctx.mkConst(ctx.mkSymbol(0),this.sortMap.get(operator));
                 this.predicateSet.addPredicate(ctx.mkEq(substVar,ctx.mkConst(operator,this.sortMap.get(operator))));
                 predicateCandidates.add(ctx.mkConst(operator,this.sortMap.get(operator)));
             }else{
                 Expr ct = parseString2Const(ctx, operator);
                 Expr substVar = ctx.mkConst(ctx.mkSymbol(0),ct.getSort());
                 this.predicateSet.addPredicate(ctx.mkEq(substVar,ct));
                 predicateCandidates.add(ct);
             }
         }

         return predicateCandidates;
     }

    /**
     * Parse a given symbol to a z3 num object
     * @param ctx context
     * @param operator symbol used to parse
     * @return
     */
    private Expr parseString2Const(Context ctx,String operator) {
         try {
             // LIA
             return ctx.mkInt(Integer.parseInt(operator));
         }catch(NumberFormatException e){
             // BV
             Integer size = operator.length()-2;
             return ctx.mkBV(Integer.parseInt(operator.substring(2),16),size);
         }
    }


    // ------------------------------------------------------
    // Getter and Setter
    // ------------------------------------------------------
    public List<String> getSymbolicArguments() {
        return symbolicArguments;
    }

    public void setSymbolicArguments(List<String> symbolicArguments) {
        this.symbolicArguments = symbolicArguments;
    }

    public TermNode getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(TermNode currentProgram) {
        this.currentProgram = currentProgram;
    }
}
