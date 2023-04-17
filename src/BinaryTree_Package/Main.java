package BinaryTree_Package;

public class Main {
    public static void main(String[] args) {
        BinaryTree arbol=new BinaryTree();


        arbol.addDepth("Buenas");
        arbol.addDepth("Tardes");
        arbol.addDepth("Amix");
        arbol.addDepth("Quiero");
        arbol.addDepth("Terminar");
        arbol.addDepth("Esto");
        arbol.addDepth("Ya");
        arbol.addDepth("Dormir");
        arbol.addDepth("No");
        arbol.addDepth("bu");
        arbol.addDepth("iz");
        arbol.addDepth("dere");
        arbol.addDepth("ggg");
/*
        arbol.addWidth("holaaa");
        arbol.addWidth("b");
        arbol.addWidth("c");
        arbol.addWidth("buen");
        arbol.addWidth("diaaa");
        arbol.addWidth("holaaa");
        arbol.addWidth("buuu");
        arbol.addWidth("yupi");

 */
        System.out.println("inoder: ");
        System.out.println(arbol.inordenToString());
        System.out.println("pre: ");
        System.out.println(arbol.preOrdenToString());
        System.out.println("pos: ");
        System.out.println(arbol.posOrdenToString());
        System.out.println("nivel: ");
        System.out.println(arbol.widthOrderToString());

        System.out.println(arbol.remove("c"));

       // System.out.println(arbol.addDepth("karen"));
       System.out.println(arbol.isComplete());
       System.out.println(arbol.isFull());
        System.out.println(arbol.isEmpty());
        System.out.println(arbol.remove("ggg"));
        System.out.println(arbol.search("yupi"));



        //arbol.addWidth("holaaa");

        //System.out.println(arbol.root.left.getObjeto());
    }
}
