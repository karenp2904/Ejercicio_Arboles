package BinarySearchTree_Package;

public interface TreeInterface<T> {

    String widthOrderToString();
    String inordenToString();
    String preOrdenToString();
    String posOrdenToString();

    boolean add(T objeto);
    boolean isEmpty();

    int size();

    T extract(Object objeto);
    boolean search(T objecto);

    boolean remove(T objeto);

}
