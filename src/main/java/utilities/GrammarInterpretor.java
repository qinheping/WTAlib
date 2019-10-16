package utilities;

import com.sun.javafx.css.Rule;
import parser.GTermNode;
import parser.GrammarNode;
import parser.NTNode;
import parser.RuleNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrammarInterpretor {
    GrammarNode grammar;
    List<Equation> equations;

    // track the type of equation
    int flag = 1;

    public GrammarInterpretor(GrammarNode g){
        this.grammar = g;
    }

    public List<Equation> GrammarToEquations(GrammarNode grammar){
        List<Equation> result = new ArrayList<>();
        for(NTNode currentNT : grammar.getNtNodes()){
            List<RuleNode> rules = currentNT.getRules();
            this.flag = 1;
            Equation currentEq = new Equation(currentNT.getNtName(), RulesToExpression(rules));
            currentEq.type = this.flag;
            result.add(currentEq);
        }
        this.equations = result;
        return  result;

    }

    public GrammarNode mkCommutativeGrammar(GrammarNode grammar){
        List<NTNode> newNts = new ArrayList<>();
        Set<String> toAdd_newNegNT = new HashSet<>();
        Set<String> added_newNegNT = new HashSet<>();
        for(NTNode currNT: grammar.getNtNodes()){
            List<RuleNode> newRules = new ArrayList<>();
            for(RuleNode currRule: currNT.getRules()){
                List<GTermNode> newChildren = new ArrayList<>();
                if (currRule.getContent().symbol.equals("-")){
                    newChildren.add(currRule.getContent().children.get(0));
                    newChildren.add(new GTermNode(currRule.getContent().getChildren().get(1).getSymbol()+"_minus",currRule.getContent().children.get(1).children));
                    newRules.add(new RuleNode(new ArrayList<>(),new GTermNode("-",newChildren)));
                    toAdd_newNegNT.add(currRule.getContent().getChildren().get(1).getSymbol());
                    continue;
                }
                newRules.add(currRule);
            }
            newNts.add(new NTNode(currNT.getNtName(),currNT.getNtSort(),newRules));
        }

        while (!toAdd_newNegNT.isEmpty()){
            String currNT_name = toAdd_newNegNT.iterator().next();
            toAdd_newNegNT.remove(currNT_name);
            added_newNegNT.add(currNT_name);
            NTNode currNT = null;
            for(NTNode nt: newNts){
                if(nt.getNtName().equals(currNT_name))
                    currNT = nt;
            }

            // mkNegNT
            List<RuleNode> newRules = new ArrayList<>();
            for(RuleNode currRule: currNT.getRules()){

                if (isInteger(currRule.getContent().symbol)){
                    if(currRule.getContent().symbol.charAt(0)=='-'){
                        newRules.add(new RuleNode(new GTermNode(currRule.getContent().symbol.substring(1,currRule.getContent().symbol.length()))));
                    }else
                        newRules.add(new RuleNode(new GTermNode("-"+currRule.getContent().symbol)));
                    continue;
                }
                if (currRule.getChildren().size()==0){
                    newRules.add(new RuleNode(new GTermNode(currRule.getSymbol()+"_minus")));
                    if(!added_newNegNT.contains(currRule.getSymbol())){
                        toAdd_newNegNT.add(currRule.getSymbol());
                    }
                    continue;
                }
                if (currRule.getSymbol().equals("+")){
                    newRules.add(currRule);
                }
                //TODO
            }

        }
        return null;
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
        if(r.getSymbol().equals("<")||r.getSymbol().equals(">")||r.getSymbol().equals("<=")||r.getSymbol().equals(">=")||r.getSymbol().equals("=")||r.getSymbol().equals("and")||r.getSymbol().equals("or")){
            this.flag = 0;
            result.type = 5;
            result.bop = r.getSymbol();
            result.left = GTermToExpression(r.getChildren().get(0));
            result.right = GTermToExpression(r.getChildren().get(0));
            return result;
        }
        if(r.getSymbol().equals("not")){
            this.flag = 0;
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
            this.flag = 0;
            Expression result = new Expression();result.type = 5;
            result.bop = gt.getSymbol();
            result.left = GTermToExpression(gt.getChildren().get(0));
            result.right = GTermToExpression(gt.getChildren().get(0));
            return result;
        }
        if(gt.getSymbol().equals("not")){
            this.flag = 0;
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
