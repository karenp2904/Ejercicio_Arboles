package BinaryTree_Package;

public interface TreeInterface<T> {

    String widthOrderToString();
    String inordenToString();
    String preOrdenToString();
    String posOrdenToString();

    boolean addWidth(Object objeto);
    boolean addDepth(Object objeto);

    boolean remove(Object objeto);

    boolean isEmpty();

    int size();

    T find(T elemento);



}
