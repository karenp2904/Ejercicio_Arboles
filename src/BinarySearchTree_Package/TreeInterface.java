package BinarySearchTree_Package;

import Estructuras.ListasEnlaceDoble.LinkedList;

public interface TreeInterface<T> {

    LinkedList<T> widthOrderToString();
    LinkedList<T> inordenToString();
    LinkedList<T> preOrdenToString();
    LinkedList<T> posOrdenToString();
    boolean add(T objeto, int indice);
    T extract();
    boolean search(int indice);
    boolean remove(int indice);
    boolean isEmpty();
    int size();
    int height();
    boolean isComplete();
    boolean isFull();

}
