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
    int height();

    boolean search(T objeto);

    boolean searchPreOrden(T objeto);

    boolean isComplete();
    boolean isFull();



}
