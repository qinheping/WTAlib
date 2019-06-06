package parser;

import java.util.List;

public class NTNode extends ProgramNode{
    public List<RuleNode> getRules() {
        return rules;
    }

    public String getNtName() {
        return ntName;
    }

    public void setRules(List<RuleNode> rules) {
        this.rules = rules;
    }

    public void setNtName(String ntName) {
        this.ntName = ntName;
    }

    public String getNtSort() {
        return ntSort;
    }

    public void setNtSort(String ntSort) {
        this.ntSort = ntSort;
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
