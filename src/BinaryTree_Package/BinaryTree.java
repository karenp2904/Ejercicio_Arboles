package BinaryTree_Package;

import Estructuras.DinamicQueue.Queue;
import Estructuras.ListasEnlaceDoble.LinkedList;

public class BinaryTree<T> implements TreeInterface<T> {
    BinaryNode<T> root;
    int size = 0;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
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
            string+="";
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

    public boolean addDepth(T objeto) { //completar
        boolean insertar = false;
        int bandera = 1;
        try {
            //PREORDEN: Raiz-Izquierdo-Derecho
            Queue<TreeInterface<T>> cola = new Queue<>();
            cola.insert(root);
            BinaryNode<T> nodo = new BinaryNode<>();
            while (!cola.isEmpty()) {
                nodo = (BinaryNode<T>) cola.extract();// siempre se extraerá algo hasta que sea null, entonces lo que se extrae es lo que se verifica
                if (nodo.getLeft() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                    cola.insert(nodo.getLeft());// se añade a la cola el nodo derecho
                    bandera++;//se encuentra en unn nivelo superior
                }
                else if (nodo.getRight() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                    cola.insert(nodo.getRight());// se añade a la cola el nodo derecho
                    bandera++;//se encuentra en unn nivelo superior
                }
                else {
                    if(Math.pow(2,(bandera+1)-1)!=size) {
                        if (nodo.getLeft() == null) {
                            nodo.left = new BinaryNode<>(objeto);
                            cola.clear();
                            insertar = true;
                            size++;
                        } else {
                            if (nodo.getRight() == null) {
                                nodo.right = new BinaryNode<>(objeto);
                                cola.clear();
                                insertar = true;
                                size++;
                            }
                        }
                    }
                }
                bandera++;
            }
            return insertar;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return insertar; //retornar el valor booleano que indica si hubo una insercion o no
        }
    }

    public boolean remove(T objeto){
        return removeObject(this.root,objeto);
    }
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
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T find(T elemento) {
        BinaryNode<T> current=findRecursive(elemento,this.root);
        if(current!=null){
            return  (T) current.getObjeto();
        }else{
            return null;
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

    //metodo para verificar si el arbol esta lleno
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


}





        /*
        boolean insertar = false;
        int bandera = 1;
        try {
            //PREORDEN: Raiz-Izquierdo-Derecho
            Queue<TreeInterface<T>> cola = new Queue<>();
            cola.insert(root);
            BinaryNode<T> nodo = new BinaryNode<>();
            while (!cola.isEmpty()) {
                nodo = (BinaryNode<T>) cola.extract();// siempre se extraerá algo hasta que sea null, entonces lo que se extrae es lo que se verifica
                if (nodo.getLeft() != null && nodo.getRight() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                    cola.insert(nodo.getLeft());// se añade a la cola el nodo derecho
                    cola.insert(nodo.getRight());
                    bandera++;//se encuentra en unn nivelo superior
                } else {
                    if(Math.pow(2,bandera)==size) {
                        if (nodo.getLeft() == null) {
                            nodo.left = new BinaryNode<>(objeto);
                            cola.clear();
                            insertar = true;
                            size++;
                        } else {
                            if (nodo.getRight() == null) {
                                nodo.right = new BinaryNode<>(objeto);
                                cola.clear();
                                insertar = true;
                                size++;
                            }
                        }
                    }
                }
                return insertar;
            }
        }catch(Exception e){
                e.printStackTrace();
            }finally{
                return insertar; //retornar el valor booleano que indica si hubo una insercion o no
            }
        }

         */


