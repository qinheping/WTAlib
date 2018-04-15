package automata.fta;

import automata.Move;

import java.util.List;

public class FTAMove<S> extends Move<S> {
    public FTAMove(Integer from, List<Integer> to, S symbol){
        super(from, to, symbol);
    }
    public FTAMove(Integer from, List<Integer> to, S symbol, String sort){
        super(from, to, symbol);this.sort =sort;
    }
    public String toDotString() {
        String result = from + " -> (" + symbol +") "+to;
        return result;
    }
    public  String toString(){
        return toDotString();
    }


}