package automata.wta;

import automata.Move;

import java.util.List;

public class WTAMove<S,R> extends Move<S> {
    public R weight;


    public WTAMove(Integer from, List<Integer> to, S symbol, R weight) {
        super(from,to,symbol);
        this.weight = weight;
    }

    public String toDotString(){
        String result = from +" -> (" + symbol + ", " + weight +") " +to;
        return result;
    }
}
