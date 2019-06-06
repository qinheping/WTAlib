package utilities;

import com.sun.javafx.css.Rule;
import parser.GTermNode;
import parser.GrammarNode;
import parser.NTNode;
import parser.RuleNode;

import java.util.ArrayList;
import java.util.List;

public class GrammarInterpretor {
    GrammarNode grammar;
    List<Equation> equations;


    public GrammarInterpretor(GrammarNode g){
        this.grammar = g;
    }

    public List<Equation> GrammarToEquations(GrammarNode grammar){
        List<Equation> result = new ArrayList<>();
        for(NTNode currentNT : grammar.getNtNodes()){
            List<RuleNode> rules = currentNT.getRules();

            Equation currentEq = new Equation(currentNT.getNtName(), RulesToExpression(rules));
            result.add(currentEq);
        }
        this.equations = result;
        return  result;

    }

    public Expression RulesToExpression(List<RuleNode> rules){
        Expression result = new Expression();
        if(rules.size() > 1){
            result.type = 3;
            result.left = RuleToExpression(rules.get(rules.size()-1));
            result.right = RulesToExpression(rules.subList(0,rules.size()-1));
            return  result;
        }
        return RuleToExpression(rules.get(0));
    }

    public Expression RuleToExpression(RuleNode r){
        Expression result = new Expression();
        if(r.getChildren()==null || r.getChildren().size() ==0){
            if(isInteger(r.getSymbol())){
                result.type = 0;
                result.constant =  Integer.parseInt(r.getSymbol());
                return result;
            }
            result.type = 1;
            result.var = r.getSymbol();
            return  result;
        }
        if(r.getSymbol().equals("+")) {
            result.type = 2;
            result.left = GTermToExpression(r.getChildren().get(0));
            result.right = GTermToExpression(r.getChildren().get(1));
            return result;
        }
        if(r.getSymbol().equals("ite")){
            result.type = 4;
            result.condition = GTermToExpression(r.getChildren().get(0));
            result.left = GTermToExpression(r.getChildren().get(1));
            result.right = GTermToExpression(r.getChildren().get(2));
            return result;
        }
        if(r.getSymbol().equals("<")||r.getSymbol().equals(">")||r.getSymbol().equals("<=")||r.getSymbol().equals("<=")||r.getSymbol().equals("=")||r.getSymbol().equals("and")||r.getSymbol().equals("or")){
            result.type = 5;
            result.bop = r.getSymbol();
            result.left = GTermToExpression(r.getChildren().get(0));
            result.right = GTermToExpression(r.getChildren().get(0));
            return result;
        }
        if(r.getSymbol().equals("not")){
            result.type = 6;
            result.bop = r.getSymbol();
            result.left = GTermToExpression(r.getChildren().get(0));
            return result;
        }
        System.out.println("ERROR: operator in grammar is invalid: "+r.getSymbol() +" in "+r.toString());
        return  null;
    }

    public Expression GTermToExpression(GTermNode gt){
        if(gt.getChildren()==null || gt.getChildren().size() ==0){
            Expression result = new Expression();
            if(isInteger(gt.getSymbol())){
                result.type = 0;
                result.constant =  Integer.parseInt(gt.getSymbol());
                return result;
            }
            result.type = 1;
            result.var = gt.getSymbol();
            return  result;
        }
        if(gt.getSymbol().equals("+")) {
            Expression result = new Expression();
            result.type = 2;
            result.left = GTermToExpression(gt.getChildren().get(0));
            result.right = GTermToExpression(gt.getChildren().get(1));
            return result;
        }
        if(gt.getSymbol().equals("ite")){
            Expression result = new Expression();
            result.type = 4;
            result.condition = GTermToExpression(gt.getChildren().get(0));
            result.left = GTermToExpression(gt.getChildren().get(1));
            result.right = GTermToExpression(gt.getChildren().get(2));
            return result;
        }
        if(gt.getSymbol().equals("<")||gt.getSymbol().equals(">")||gt.getSymbol().equals("<=")||gt.getSymbol().equals("<=")||gt.getSymbol().equals("=")||gt.getSymbol().equals("and")||gt.getSymbol().equals("or")){

            Expression result = new Expression();result.type = 5;
            result.bop = gt.getSymbol();
            result.left = GTermToExpression(gt.getChildren().get(0));
            result.right = GTermToExpression(gt.getChildren().get(0));
            return result;
        }
        if(gt.getSymbol().equals("not")){
            Expression result = new Expression();
            result.type = 6;
            result.bop = gt.getSymbol();
            result.left = GTermToExpression(gt.getChildren().get(0));
            return result;
        }
        System.out.println("ERROR: operator in grammar is invalid: "+gt.getSymbol()+" in "+gt.toString());
        return  null;


    }

    public static boolean isInteger(String s) {
        int radix = 10;
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
