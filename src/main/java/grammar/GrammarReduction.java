package grammar;

import automata.FTA.FTA;
import automata.wta.WTA;
import semirings.Semiring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GrammarReduction<S,R>{
    private Semiring sr;
    public GrammarReduction(Semiring sr){
        this.sr = sr;
    }

    public FTA<S> mkFTALessThanC(WTA<S,R> wAut, R c){
        Map<Integer, Collection<R>> combinedStates = new HashMap<Integer, Collection<R>>();
    }

}