package BinarySearchTree_Package;

public class Probandooo {
    public static void main(String[] args) {
        BinarySearchTree arbol = new BinarySearchTree();
        arbol.add("+", 10);
        arbol.add("*", 7);
        arbol.add("/", 13);
        arbol.add("a", 6);
        arbol.add("b", 8);
        arbol.add("c", 12);
        arbol.add("d", 14);

        arbol.remove( 13);

        System.out.println(arbol.posOrdenToString().toString());
    }
}
