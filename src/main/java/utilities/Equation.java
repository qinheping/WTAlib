package utilities;

public class Equation<E> {
    String left;
    Expression<E> right;


    // 0 for bool
    // 1 for int
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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
