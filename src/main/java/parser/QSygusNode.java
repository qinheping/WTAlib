package parser;

import automata.fta.FTA;
import automata.wta.WTA;
import javafx.util.Pair;
import semirings.BooleanSemiring;
import semirings.ProbabilitySemiring;
import semirings.Semiring;
import semirings.TropicalSemiring;

import java.util.ArrayList;
import java.util.List;

public class QSygusNode extends ProgramNode{
    public List<Semiring> semirings;
    public List<String> weightNames;
    List<String> preCmds;
    List<String> postCmds;
    GrammarNode synthFun;
    public TermNode weightConstraint;
    OptimizationNode weightOpt;

    public QSygusNode(List<String> preCmds, List<String> postCmds, GrammarNode synthFun, List<Pair<String,String>> semirings, TermNode weightConstraint, OptimizationNode weightOpt){
        this.preCmds = preCmds;
        this.postCmds = postCmds;
        this.synthFun = synthFun;
        this.semirings = new ArrayList<Semiring>();
        this.weightNames = new ArrayList<String>();
        for(Pair<String,String> pss: semirings){
            this.semirings.add(stringToSemiring(pss.getValue()));
            this.weightNames.add(pss.getKey());
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
        return this.toWTA(0);
    }
    public WTA toWTA(Integer index){
        List<WTA> wtaList = new ArrayList<WTA>();
        for(int i = 0; i < semirings.size(); i++){
            wtaList.add(synthFun.toWTA(semirings.get(i), i));
        }
        // TODO we can do more
        return wtaList.get(index);
    }

    public GrammarNode getSynthFun() {
        return synthFun;
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

    public String toString(FTA fta){

        String result = "";
        for(String cmd: preCmds){
            result = result + cmd + '\n';
        }
        result = result + synthFun.toString(fta) + "\n";
        for(String cmd: postCmds){
            result = result + cmd + '\n';
        }
        return result;
    }

    public TermNode getWeightConstraint() {
        return weightConstraint;
    }
}


