package BinaryTree_Package;

import Estructuras.DinamicQueue.Queue;
import Estructuras.ListasEnlaceDoble.LinkedList;

public class BinaryTree<T> implements TreeInterface<T> {
    BinaryNode<T> root;
    int size = 0;

    public BinaryTree() {
        this.root = null;
        size=0;
    }
    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
        size=1;
    }
    public BinaryTree(T objet) {
        root = new BinaryNode<T>(objet);
        size=1;
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

    // ira derecha raiz izquierda - para un recorrido de mayor a menos jsksksks
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

    public LinkedList<T> widthOrderToString() {
        LinkedList<T> lista=new LinkedList<>();
        return widthOrder(this, lista);
    }
    private LinkedList<T> widthOrder(TreeInterface<T> root,  LinkedList<T> lista) {
        Queue<TreeInterface<T>> cola = new Queue<>();
        cola.insert(this.root);
        BinaryNode<T> nodo = new BinaryNode<T>();
        while (!cola.isEmpty()) {
            nodo = (BinaryNode<T>) cola.extract();// siempre se extraerá algo hasta que sea null, entonces lo que se extrae es lo que se verifica
            lista.add(nodo.getObjeto());//se añade a la lista
            if (nodo.getLeft() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                cola.insert(nodo.getLeft());// se añade a la cola el nodo derecho
            }
            if (nodo.getRight() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                cola.insert(nodo.getRight());
            }
        }
        return lista;

    }

    public boolean addWidth(T objeto) {
        boolean insertar = false;
        try {
            //INORDEN: Izquierdo-Raiz-Derecho
            Queue<TreeInterface<T>> cola = new Queue<>();
            cola.insert(root);
            BinaryNode<T> nodo = new BinaryNode<>();
            while (!cola.isEmpty()) {
                nodo = (BinaryNode<T>) cola.extract();// siempre se extraerá algo hasta que sea null, entonces lo que se extrae es lo que se verifica
                if (nodo.getLeft() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                    cola.insert(nodo.getLeft());// se añade a la cola el nodo derecho
                } else {
                    nodo.left = new BinaryNode<>(objeto);
                    cola.clear();
                    insertar = true;
                }
                if (nodo.getRight() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                    cola.insert(nodo.getRight());
                } else {
                    nodo.right = new BinaryNode<>(objeto);
                    cola.clear();
                    insertar = true;
                }
            }
            size++; //contador para el tamaño y la cantidad de nodos en el arbol
            return insertar;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return insertar; //retornar el valor booleano que indica si hubo una insercion o no
        }
    }

    public boolean addDepth(T objeto) { // - la idea es insertar segun la estructura del recorrido por orden
        boolean insertar = false;
        try {
            BinaryNode<T> nodo = new BinaryNode<>(objeto);
            //PREORDEN: Raiz-Izquierdo-Derecho
            if (isEmpty()) {
               this.root=new BinaryNode<>(objeto);
            } else {
                if (root == null) {
                    root = nodo;
                } else {
                    Queue<BinaryNode<T>> queue = new Queue();
                    queue.insert(this.root);
                    while (!queue.isEmpty()) {
                        BinaryNode<T> aux = (BinaryNode<T>) queue.extract();
                        if (aux.left == null) {
                            aux.left = nodo;
                            queue.clear();
                            insertar=true;
                        } else if (aux.right == null) {
                            aux.right = nodo;
                            queue.clear();
                            insertar=true;
                        } else {
                            queue.insert(aux.left);
                            queue.insert(aux.right);
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return insertar; //retornar el valor booleano que indica si hubo una insercion o no
        }
    }
    private boolean addDepthRecursive(T objeto, BinaryNode<T> nodo){ //comprobar**
        //PREORDEN: Raiz-Izquierdo-Derecho
        boolean añadido=false;
        if(nodo==null){
            nodo=new BinaryNode<>(objeto);
            añadido=true;
            return añadido;
        }else{
            if(nodo.left==null) {
                nodo.left=new BinaryNode<>(objeto);//se le añade el objeto al izauierdo en primera instancia
                añadido=true;
            }else if(nodo.right==null){
                nodo.right=new BinaryNode<>(objeto);
                añadido=true;
            }else if(nodo.left!=null){
                    addDepthRecursive(objeto,nodo.left);
                }else if(nodo.right!=null){
                    addDepthRecursive(objeto,nodo.right);
            }
        }
        return añadido;
    }

    public boolean remove(T objeto){
        return removeObject(this.root,objeto);
    }

    //en el removeObject se busca al nodo que contiene el objeto
    private boolean removeObject(BinaryNode<T> raiz, T objeto) {
        if (raiz == null) {
            return false;
        }
        Queue<TreeInterface<T>> cola = new Queue<>();
        cola.insert(raiz);

        while (!cola.isEmpty()) {
            BinaryNode<T> nodo = (BinaryNode<T>) cola.extract();
            if (nodo.getObjeto() == objeto) {
                eliminarNodo(nodo);
                size--;
                return true;
            }
            if (nodo.left != null) {
                cola.insert(nodo.left);
            }

            if (nodo.right != null) {
                cola.insert(nodo.right);
            }
        }
        return true;
    }
    private void eliminarNodo(BinaryNode<T> nodoAEliminar) {
        // Caso 1: el nodo a eliminar es una hoja (no tiene hijos)
        if (nodoAEliminar.left == null && nodoAEliminar.right == null) {
            nodoAEliminar = null;
        }
        // Caso 2: el nodo a eliminar solo tiene un hijo
        else if (nodoAEliminar.left == null || nodoAEliminar.right == null) {
            BinaryNode<T> hijo = nodoAEliminar.left == null ? nodoAEliminar.right : nodoAEliminar.left;
            nodoAEliminar.setObjeto(hijo.getObjeto());
            nodoAEliminar.left = hijo.left;
            nodoAEliminar.right = hijo.right;
        }
        // Caso 3: el nodo a eliminar tiene dos hijos
        else {
            BinaryNode<T> sucesor = encontrarSucesor(nodoAEliminar.right);
            nodoAEliminar.setObjeto(sucesor.getObjeto());
            eliminarNodo(sucesor);
        }
    }
    private BinaryNode<T> encontrarSucesor(BinaryNode<T> nodo) {
        while (nodo.left != null) { // preferencia por la izquierda si tiene dos hijos
            nodo = nodo.left;
        }
        return nodo;
    }

    @Override
    public boolean removePosOrden() {
        return removeRecursive(this.root);
    }
    private boolean removeRecursive(BinaryNode<T> raiz){
        if(!isEmpty()){
            removeRecursive(raiz.left);
            removeRecursive(raiz.right);
            remove(raiz.getObjeto());//re utiliza el metodo remove generado anteriormente
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }
    @Override
    public int size() {
        return size;
    }

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
        if(counterRight>counterLeft){ // se comparan ambos nodos
            return counterRight;
        }else{
            return counterLeft;
        }
    }

    @Override
    public boolean search(T objeto) {
        BinaryNode<T> current=findRecursive(objeto,this.root);
        if(current!=null){
            return  true;
        }else{
            return false;
        }
    }

    public BinaryNode<T> findRecursive(T elemento, BinaryNode<T> next){
        if(next==null){
            return null;
        }
        if(next.getObjeto().equals(elemento)){
            return next;
        }
        BinaryNode<T> temporal=findRecursive(elemento,next.left);
        if(temporal==null){
            temporal=findRecursive(elemento,next.right);
        }
        return temporal;
    }

    @Override
    public boolean searchPreOrden(T objeto) {
        return searchPreRecursive(this.root);
    }
    private boolean searchPreRecursive(BinaryNode<T> raiz){
        boolean encontrado=false;
        if(!isEmpty()){
            //preOrden: raiz- izq- der
            encontrado=search(raiz.getObjeto());//re utiliza el metodo search generado anteriormente
            searchPreRecursive(raiz.left);
            searchPreRecursive(raiz.right);
        }
        return encontrado;
    }
    //metodo para verificar si el arbol esta lleno
    @Override
    public boolean isComplete() {
        return isCompleteRecursive(this.root);
    }
    private boolean isCompleteRecursive(BinaryNode<T> raiz) {
        if (isEmpty()) {
            return true;
        }else{
            Queue<TreeInterface<T>> queue = new Queue<>();
            queue.insert(root);
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
}