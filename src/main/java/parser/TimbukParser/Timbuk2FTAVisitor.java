package parser.TimbukParser;

import automata.fta.FTA;
import automata.fta.FTAMove;

import java.util.ArrayList;
import java.util.HashMap;

public class Timbuk2FTAVisitor extends TimbukBaseVisitor<FTA<String>>{
    HashMap<String, Integer> stateMap = new HashMap<>();
    Integer currInx = 1;
    @Override
    public FTA visitFile(TimbukParser.FileContext ctx) {
        FTA result = new FTA();

        TimbukParser.AutomatonContext automatonCtx = ctx.automaton();
        TimbukParser.State_listContext finalStateCtx = automatonCtx.state_list(1);
        result.setInitialState(0);
        if(finalStateCtx.state().size() == 1){
            stateMap.put(finalStateCtx.getText(),0);
        }else {
            for(TimbukParser.StateContext stateCtx: finalStateCtx.state()){
                stateMap.put(stateCtx.getText(),currInx);
                result.addTransition(new FTAMove(0, currInx,""));
                currInx++;
            }
        }

        for(TimbukParser.TransitionContext transCtx: automatonCtx.transition_list().transition()){
            String op = transCtx.SYMBOL().getText();
            ArrayList<Integer> to = new ArrayList<>();
            Integer from;
            for(int i = 0; i < transCtx.state().size()-1; i++){
                to.add(getState(transCtx.state(i).getText()));
            }
            from =getState(transCtx.state(transCtx.state().size()-1).getText());
            result.addTransition(new FTAMove(from,to,op));
        }
        return  result;


    }

    public Integer getState(String key){
        if(stateMap.containsKey(key))
            return stateMap.get(key);
        stateMap.put(key,currInx);
        currInx++;
        return currInx-1;
    }
}
