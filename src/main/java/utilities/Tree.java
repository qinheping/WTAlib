package utilities;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    public Node<T> getRoot() {
        return root;
    }

    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }
    public Tree(Node<T> root) {
        this.root = root;
    }

    public Tree(Tree<T> t){
        root = new Node<T>();
        root.data = t.getRoot().getData();
        root.setChildren(new ArrayList<Node<T>>(root.getChildren()));
    }

    public void addChild(Tree<T> child){
        root.getChildren().add(child.getRoot());
    }

    public boolean isLeaf(){
        return root.isLeaf();
    }

    public List<Tree<T>> getSubTrees(){
        List<Tree<T>> subTrees = new ArrayList<Tree<T>>();
        for(Node<T> child: root.children){
            subTrees.add(new Tree<T>(child));
        }
        return subTrees;
    }

    public static class Node<T>{
        private T data;
        public T getData() {
            return data;
        }

        public void setChildren(List<Node<T>> children) {
            this.children = children;
        }

        private List<Node<T>> children;
        public List<Node<T>> getChildren() {
            return children;
        }

        public boolean isLeaf(){
            return children.isEmpty();
        }
    }
}
