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
    public AbstractLearner(List<String> symbolicArguments, TermNode program, Map<String,Sort> sortMap){
        this.currentProgram = program;
        this.symbolicArguments = symbolicArguments;
        this.ctx = new Context();
        this.predicateSet = new PredicateSet(ctx);
        this.sortMap = sortMap;
    }
    public AbstractLearner(List<String> symbolicArguments, TermNode program, Sort sort){
        this(symbolicArguments, program, new HashMap<>());
        for(String argument : symbolicArguments){
            this.sortMap.put(argument,sort);
        }
    }

    /**
     * Recursively learn predicates from term node by node
     * @param term current node
     * @return predicates learnt from children
     */
     public List<ArithExpr> learnFromTerm(TermNode term){
         String operator = term.getSymbol(); // current operator
         List<ArithExpr> predicateCandidates = new ArrayList();

         // branch operator
         if(operator.equals("ite")){
             predicateCandidates.addAll(learnFromTerm(term.getChildren().get(1)));  // true branch
             predicateCandidates.addAll(learnFromTerm(term.getChildren().get(2)));  // false branch
             return predicateCandidates;
         }

         // linear operator
         if(operator.equals("+")){
             List<ArithExpr> predicate_Children0 = learnFromTerm(term.getChildren().get(0));
             List<ArithExpr> predicate_Children1 = learnFromTerm(term.getChildren().get(1));
             // combine both child
             for(int i = 0; i < predicate_Children0.size(); i++){
                 for(int j = 0; j < predicate_Children1.size(); j++) {
                    predicateCandidates.add()
                 }
             }
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
