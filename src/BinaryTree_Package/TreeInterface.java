package BinaryTree_Package;

import Estructuras.ListasEnlaceDoble.LinkedList;

public interface TreeInterface<T> {

    LinkedList<T> widthOrderToString();
    LinkedList<T> inordenToString();
    LinkedList<T> preOrdenToString();
    LinkedList<T> posOrdenToString();

    boolean addWidth(T objeto);
    boolean addDepth(T objeto);

    boolean remove(T objeto);

    boolean removePosOrden();

    boolean isEmpty();

    int size();

    T find(T elemento);

    boolean isComplete();
    boolean isFull();



}
