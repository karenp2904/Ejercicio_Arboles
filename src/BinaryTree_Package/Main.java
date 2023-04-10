package BinaryTree_Package;

public class Main {
    public static void main(String[] args) {
        BinaryTree arbol=new BinaryTree("buenas");

        BinaryNode nodo= new BinaryNode<>(100);
        nodo.left=new BinaryNode<>(20);
        nodo.left.left=new BinaryNode<>(15);
        nodo.left.right=new BinaryNode<>(21);
        nodo.left.left.left=new BinaryNode<>(33);
        nodo.left.left.right=new BinaryNode<>(80);
        nodo.left.right=new BinaryNode<>(21);
        nodo.right=new BinaryNode<>(40);
        nodo.right.right=new BinaryNode<>(31);
        nodo.right.left=new BinaryNode<>(31);

        arbol.addWidth("holaaa");
        arbol.addWidth("b");
        arbol.addWidth("c");
        arbol.addWidth("buen");
        arbol.addWidth("diaaa");
        arbol.addWidth("holaaa");
        arbol.addWidth("buuu");
        arbol.addWidth("yupi");






        System.out.println(arbol.widthOrderToString());
        //arbol.addWidth("holaaa");

        //System.out.println(arbol.root.left.getObjeto());
    }
}
