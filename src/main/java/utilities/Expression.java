package utilities;

public class Expression<E> {
    /*
        0: const
        1: var
        2: dot
        3: plus
     */
    Integer type;
    String var;
    Expression left;
    Expression right;
    E constant;

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
}
