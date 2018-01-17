package parser;

import automata.wta.WTA;
import semirings.BooleanSemiring;
import semirings.ProbabilitySemiring;
import semirings.Semiring;
import semirings.TropicalSemiring;

import java.util.ArrayList;
import java.util.List;

public class QSygusNode extends ProgramNode{
    List<Semiring> semirings;
    List<String> preCmds;
    List<String> postCmds;
    GrammarNode synthFun;
    TermNode weightConstraint;
    OptimizationNode weightOpt;

    public QSygusNode(List<String> preCmds, List<String> postCmds, GrammarNode synthFun, List<String> semirings, TermNode weightConstraint, OptimizationNode weightOpt){
        this.preCmds = preCmds;
        this.postCmds = postCmds;
        this.synthFun = synthFun;
        this.semirings = new ArrayList<Semiring>();
        for(String s: semirings){
            this.semirings.add(stringToSemiring(s));
        }
        this.weightConstraint = weightConstraint;
        this.weightOpt = weightOpt;
    }

    public Semiring stringToSemiring(String s){
        if(s.equals("BOOL"))
            return new BooleanSemiring();
        if(s.equals("PROB"))
            return new ProbabilitySemiring();
        if(s.equals("TROP"))
            return new TropicalSemiring();
        return null;
    }

    public WTA toWTA(){
        List<WTA> wtaList = new ArrayList<WTA>();
        for(int i = 0; i < semirings.size(); i++){
            wtaList.add(synthFun.toWTA(semirings.get(i), i));
        }
        // TODO we can do more
        return wtaList.get(0);
    }

    @Override
    public String toString(){
        String result = "";
        for(String cmd: preCmds){
            result = result + cmd + '\n';
        }
        result = result + synthFun.toString() + "\n";
        for(String cmd: postCmds){
            result = result + cmd + '\n';
        }
        return result;
    }

}


