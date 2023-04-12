package BinarySearchTree_Package;

import BasicTreeNode.TreeNode;

public class BinaryNode<T> extends TreeNode<T> {

    BinaryNode<T> left;
    BinaryNode<T> right;
    private int indice;

    public BinaryNode() {
        super();
        this.left = this.right = null;
    }

    public BinaryNode(T objeto, int indice) {
        super(objeto);
        this.indice=indice;
        this.left = this.right = null;
    }
    public BinaryNode(T objeto) {
        super(objeto);
        this.left = this.right = null;
    }

    public BinaryNode(T objeto, BinaryNode<T> left, BinaryNode<T> right) {
        super(objeto);
        this.left = left;
        this.right = right;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


}
