package BinarySearchTree_Package;

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

}
