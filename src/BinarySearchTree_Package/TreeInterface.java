package BinarySearchTree_Package;

public interface TreeInterface<T> {

    String widthOrderToString();
    String inordenToString();
    String preOrdenToString();
    String posOrdenToString();
    boolean add(T objeto);
    T extract();
    boolean search(int indice);
    boolean remove(int indice);
    boolean isEmpty();
    int size();
    int height();



    boolean add(T objeto,int indice);
    T extract(T objeto);
    boolean remove(T objeto);

}
