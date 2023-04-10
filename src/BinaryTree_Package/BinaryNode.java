package BinaryTree_Package;

import BasicTreeNode.TreeNode;

public class BinaryNode<T> extends TreeNode<T> {

    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode() {
        super();
        this.left = this.right = null;
    }

    public BinaryNode(Object objeto) {
        super(objeto);
        this.left = this.right = null;
    }

    public BinaryNode(Object objeto, BinaryNode left, BinaryNode righ) {
        super(objeto);
        this.left = left;
        this.right = right;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int numChildren(){ //devuelve el numero de hijos no nulos del nodo
        int children=0;
        if(left!=null){
            children=1+ left.numChildren();
        }
        if(right!=null){
            children=children+1+ right.numChildren();
        }
        return children;//retornar el numero de hijos
    }

}
