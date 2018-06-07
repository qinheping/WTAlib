/**
 * AbstractLearner
 * Jun 6 2018,
 * @author Qinheping Hu
 */
package prover;

import parser.TermNode;

import java.util.List;


import com.microsoft.z3.*;


/**
 * An abstract learner that reads a term and learns abstract
 */

public class AbstractLearner {

    private List<String> symbolicArguments;
    private TermNode currentProgram;

    /**
     * Construct an abstract learner
     */
    public AbstractLearner(List<String> symbolicArguments, TermNode program){
        this.currentProgram = program;
        this.symbolicArguments = symbolicArguments;
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
