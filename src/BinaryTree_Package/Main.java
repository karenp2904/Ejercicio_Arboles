package BinaryTree_Package;

public class Main {
    public static void main(String[] args) {
        BinaryTree arbol=new BinaryTree("buenas");

        arbol.addWidth("holaaa");
        arbol.addWidth("b");
        arbol.addWidth("c");
        arbol.addWidth("buen");
        arbol.addWidth("diaaa");
        arbol.addWidth("holaaa");
        arbol.addWidth("buuu");
        arbol.addWidth("yupi");

        //System.out.println(arbol.posOrdenToString());
        //System.out.println(arbol.inordenToString());
        //System.out.println(arbol.preOrdenToString());
        //System.out.println(arbol.widthOrderToString());


        System.out.println(arbol.remove("c"));
        System.out.println(arbol.addDepth("karen"));
        System.out.println(arbol.isComplete());
        System.out.println(arbol.isFull());
        System.out.println(arbol.preOrdenToString());



        //arbol.addWidth("holaaa");

        //System.out.println(arbol.root.left.getObjeto());
    }
}
