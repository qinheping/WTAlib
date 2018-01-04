package utilities;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }
    public Tree(Node<T> root) {
        this.root = root;
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


        private Node<T> parent;
        public Node<T> getParent() {
            return parent;
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
