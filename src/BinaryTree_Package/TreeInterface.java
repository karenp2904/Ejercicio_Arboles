package BinaryTree_Package;

public interface TreeInterface<T> {

    String widthOrderToString();
    String inordenToString();
    String preOrdenToString();
    String posOrdenToString();

    boolean addWidth(T objeto);
    boolean addDepth(T objeto);

    boolean remove(T objeto);

    boolean isEmpty();

    int size();

    T find(T elemento);



}
