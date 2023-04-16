package BinarySearchTree_Package;
import Estructuras.DinamicQueue.*;
import Estructuras.ListasEnlaceDoble.LinkedList;

import java.util.logging.Logger;
public class BinarySearchTree<T> implements TreeInterface<T>{
    BinaryNode<T> root;//raiz en el arbol
    int size=0; //es el encargado de dar la cantidad de nodos en el arbol

    public BinarySearchTree(){
        this.root=null;
    }
    public BinarySearchTree(T objeto, int indice) {
        this.root = new BinaryNode<>(objeto,indice);
        size=1;
    }
    public BinarySearchTree(BinaryNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root==null;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int height() {

        return subHeight(this.root);
    }
    static int  counterRight=0, counterLeft=0;
    private int subHeight(BinaryNode<T> nodo){
        if(nodo==this.root){//se inicializan los contadores
            counterRight=0;
            counterLeft=0;
        }
        // se inicia la recursividad para comparar los subarboles de ambos lados
        if(nodo.left!=null){
            subHeight(nodo.left);
            counterLeft++;
        }
        if(nodo.right!=null){
            subHeight(nodo.right);
            counterRight++;
        }

        //se comparan los contadores y elige el mayor
        if(counterRight>counterLeft){
            return counterRight;
        }else{
            return counterLeft;
        }
    }

    @Override
    public boolean isComplete() {
        return isCompleteRecursive((TreeInterface<T>) this.root);
    }

    private boolean isCompleteRecursive(TreeInterface<T> raiz) {
        if (isEmpty()) {
            return true;
        }else{
            Queue<TreeInterface<T>> queue = new Queue<>();
            queue.insert(this.root);
            boolean end = false;
            while (!queue.isEmpty()) {
                BinaryNode<T> current = (BinaryNode<T>) queue.extract();
                if (current.left == null) {
                    end = true;
                } else if (end) {
                    return false;
                } else {
                    queue.insert(current.left);
                }
                if (current.right == null) {
                    end = true;
                } else if (end) {
                    return false;
                } else {
                    queue.insert(current.right);
                }
            }
            return true;
        }

    }

    //metodo para saber si el arbol esta lleno
    @Override
    public boolean isFull() {
        if(isEmpty()){//se verifica si esta vacio
            return true;
        }else{
            return isFullRecursive(this.root);//metodo recursivo para recorrer el arbol y verificar sus nodos
        }
    }

    private boolean isFullRecursive(BinaryNode<T> nodo) {
        /*
        Verifica que:
        Si el nodo es nulo, entonces el árbol es completo.
        Si el nodo no tiene hijos, entonces el árbol es completo.
        Si el nodo tiene dos hijos, entonces el método se llama recursivamente en los hijos izquierdo y derecho del nodo.
         */
        if (nodo == null) {
            return true;
        }
        if (nodo.left == null && nodo.right == null) {
            return true;
        }
        if (nodo.left != null && nodo.right != null) {
            return isFullRecursive(nodo.left) && isFullRecursive(nodo.right);
        }
        return false;
    }

    //INORDEN: Izquierdo-Raiz-Derecho
    public LinkedList<T> inordenToString() {
        LinkedList<T> lista=new LinkedList<>();
        return inorden(this.root, lista);
    }
    private LinkedList<T> inorden(BinaryNode<T> root, LinkedList<T> lista) {
        if (root != null) {
            inorden(root.getLeft(), lista);
            lista.add((T) root.getObjeto());
            inorden(root.getRight(), lista);

        }
        return lista;
    }

    //PREORDEN: Raiz-Izquierdo-Derecho
    public LinkedList<T>  preOrdenToString() {
        LinkedList<T> lista=new LinkedList<>();
        return preOrden(this.root, lista);
    }
    private LinkedList<T>  preOrden(BinaryNode<T> root, LinkedList<T> lista) {
        if (root != null) {
            lista.add((T) root.getObjeto());
            preOrden(root.getLeft(), lista);
            preOrden(root.getRight(), lista);

        }
        return lista;
    }

    // ira derecha raiz izquierda
    public LinkedList<T>  otroOrdenToString() {
        LinkedList<T> lista=new LinkedList<>();
        return otroOrden(this.root, lista);
    }
    private LinkedList<T>  otroOrden(BinaryNode<T> root, LinkedList<T> lista) {
        if (root != null) {
            otroOrden(root.getRight(), lista);
            lista.add((T) root.getObjeto());
            otroOrden(root.getLeft(), lista);
        }
        return lista;
    }

    //POSORDEN: Izquierdo-Derecho-Raiz
    public LinkedList<T> posOrdenToString() {
        LinkedList<T> lista=new LinkedList<>();
        return posOrden(this.root, lista);
    }
    private LinkedList<T> posOrden(BinaryNode<T> root, LinkedList<T> lista) {
        if (root != null) {
            posOrden(root.getLeft(), lista);
            posOrden(root.getRight(), lista);
            lista.add((T) root.getObjeto());
        }
        return lista;
    }


    //Recorrido por nivel en el arbol
    public String widthOrderToString() {
        String string = "";
        return widthOrder(this, string);
    }
    private String widthOrder(TreeInterface<T> root, String string) {
        Queue<TreeInterface<T>> cola = new Queue<>();
        cola.insert(this.root);
        BinaryNode<T> nodo = new BinaryNode<T>();
        while (!cola.isEmpty()) {
            nodo = (BinaryNode<T>) cola.extract();// siempre se extraerá algo hasta que sea null, entonces lo que se extrae es lo que se verifica
            string+=" - ";
            string += nodo.getObjeto().toString();//se añade a la cadena
            if (nodo.getLeft() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                cola.insert(nodo.getLeft());// se añade a la cola el nodo derecho
            }
            if (nodo.getRight() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                cola.insert(nodo.getRight());
            }
        }
        return string;

    }

    @Override
    public boolean add(T objeto, int indice) {
        boolean agregado=true;
        try{
            if(objeto!=null) {
                addRecursivo(this.root, objeto, indice);
                agregado=true;
            }
        }catch (Exception e){
             e.printStackTrace();
        }finally {
            return agregado;
        }
    }
    private BinaryNode<T> addRecursivo(BinaryNode<T> root, T objeto, int indice) {
        if(root==null){
            this.root=new BinaryNode<>(objeto,indice);
            size++;
            return this.root;
        }else{
            if(indice<root.getIndice()){
                if(root.left==null){
                    root.left=new BinaryNode<>(objeto,indice);
                    size++;
                    return root;
                }else{
                    root=root.left;
                    return addRecursivo(root,objeto,indice);
                }
            } else {
                if(root.right==null){
                    root.right=new BinaryNode<>(objeto,indice);
                    size++;
                    return root;
                }else{
                    root=root.right;
                    return addRecursivo(root,objeto,indice);
                }
            }
        }
    }

    @Override
    public T extract() {
        T objetoExtraido=null;
        try{
            BinaryNode<T> temp=this.root;
            remove(root.getIndice());
            objetoExtraido=temp.getObjeto();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return objetoExtraido;
        }

    }

    @Override
    public boolean search(int indice) {
        if(buscarValorEnABusquedaBinaria(this.root,indice).equals(indice)){
            return true;
        }else{
            return false;
        }
    }

    private BinaryNode<T> buscarValorEnABusquedaBinaria(BinaryNode<T> raiz, int indice) {
        if (raiz == null || raiz.getIndice() == indice) {
            return raiz;
        }
        if (((Comparable) indice).compareTo(raiz.getIndice())<0){
            return buscarValorEnABusquedaBinaria(raiz.left, indice);
        }else{
            return buscarValorEnABusquedaBinaria(raiz.right, indice);
        }
    }
    @Override
    public boolean remove(int indice) {
        /*
        CASO 1: Si el nodo es una hoja, lo elimina sin más
        CASO 2: Si el nodo tiene un hijo, devuelve el valor del hijo
        CASO 3: Si el nodo tiene dos hijos, elegir parametro de remover(izquierda o derecha)
         */
        boolean eliminado=false;
        try{
            if(!isEmpty()){
                if (indice==root.getIndice()){//en caso de que el elemento a eliminar sea la raiz
                    root=sustituir(root);//metodo auxiliar
                    size--;//se resta un elemento
                }
                else{
                    BinaryNode<T> current=root;//nodo actual
                    BinaryNode<T> parent=root;//nodo padre
                    //se elige
                    if(((Comparable)indice).compareTo(root.getIndice())<0){// en caso de que este en el lado inquierdo, menor al nodo
                        current=root.left;
                    }else {//en caso de que el objeto sea mayor a la raiz, verifica el lado derecho
                        current=root.right;
                    }
                    while ((current!=null)&& (eliminado==false)){//hasta que sea nulll-> llegue al final del arbol
                        if(indice==current.getIndice()){
                            eliminado=true;
                            size--;//se resta
                            if(current==parent.left){
                                parent.left=sustituir(current);//se tiene conocimiento del padre y del hijo
                            }else{
                                parent.right=sustituir(current);//
                            }
                        }else{
                            parent=current;//el padre sera el actual
                            if(((Comparable)indice).compareTo(root.getIndice())<0){// se verifica si va hacia la izquierda o derecha
                                current=current.left;//el actual sera el nodo izquierdo
                            }else{//si es mayor el objeto estara en la derecha
                                current=current.right;//el actual sera el nodo derecho
                            }
                        }
                    }
                    if(eliminado==false){
                        Logger.getAnonymousLogger("Binary Tree");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return eliminado;
        }
    }

    private BinaryNode<T> sustituir(BinaryNode<T> nodo){
        BinaryNode<T> nodoResultado=null;
        if((nodo.left==null)&&(nodo.right==null)){//caso donde es una hoja
            nodoResultado=null;
        }
        else  if ((nodo.left!=null)&&(nodo.right==null)){ //caso donde solo hay un hijo y es el izquierdo
            nodoResultado=nodo.left;
        } else if ((nodo.left==null)&&(nodo.right!=null)) {
            nodoResultado=nodo.right;
        }
        else {
            BinaryNode<T> current=nodo.right;
            BinaryNode<T> parent=nodo;

            while (current.left!=null){
                parent=current;
                current=current.left;
            }

            if(nodo.right==current){
                current.left=nodo.left;
            }else{
                parent.left=current.left;
                current.right=nodo.right;
                current.left=nodo.left;
            }
            nodoResultado=current;
        }
        return nodoResultado;
        //completar
    }

}
