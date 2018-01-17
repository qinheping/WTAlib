package automata.fta;

import automata.Move;

import java.util.List;

public class FTAMove<S> extends Move<S> {
    public FTAMove(Integer from, List<Integer> to, S symbol){
        super(from, to, symbol);
    }
    public String toDotString() {
        String result = from + " -> (" + symbol +") "+to;
        return result;
    }
}
