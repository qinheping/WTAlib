package parser;

import java.util.List;

public class NTNode extends ProgramNode{
    public List<RuleNode> getRules() {
        return rules;
    }

    public String getNtName() {
        return ntName;
    }

    List<RuleNode> rules;
    String ntName;
    String ntSort;
    public NTNode(String ntName, String ntSort, List<RuleNode> rules){
        this.ntName = ntName;
        this.ntSort = ntSort;
        this.rules = rules;
    }

    @Override
    public String toString(){
        String result = "( " + ntName + " " + ntSort + " (";
        for(RuleNode rule: rules){
            result = result + "\t" + rule.toString() + "\n";
        }
        return result + "))";
    }
}
