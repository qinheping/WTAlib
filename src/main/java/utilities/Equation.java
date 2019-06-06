package utilities;

public class Equation {
    String left;
    Expression right;

    public Equation(String left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
    @Override
    public String toString(){
        return this.left +" = "+this.right;
    }
}
