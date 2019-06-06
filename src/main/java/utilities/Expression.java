package utilities;

public class Expression<E> {
    /*
        0: const
        1: var
        2: dot
        3: plus
        4: ite
        5: bool
        6: boolu
     */
    Integer type;
    String var;
    Expression left;
    Expression right;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    Expression condition;
    E constant;

    public String getBop() {
        return bop;
    }

    public void setBop(String bop) {
        this.bop = bop;
    }

    String bop;

    public Expression() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public E getConstant() {
        return constant;
    }

    public void setConstant(E constant) {
        this.constant = constant;
    }

    @Override
    public String toString(){
        String result = "";
        if(this.type == 2)
            return left.toString()+"(*)"+right.toString();
        if(this.type == 3)
            return left.toString() + "(+)" + right.toString();
        if(this.type == 0 )
            return this.constant.toString();
        if(this.type == 1 )
            return this.var.toString();
        if(this.type == 4)
            return "(ITE ("+ this.condition.toString()+") " +" ("+this.left.toString()+") "+ " ("+this.right.toString()+") "+")";
        if(this.type == 5)
            return this.left.toString()+" "+this.bop +" "+this.right.toString();
        if(this.type == 6)
            return this.bop +" "+this.left.toString();
        System.out.println("ERROR: invalid expression type: " + this.type.toString());
        return null;
    }
}
