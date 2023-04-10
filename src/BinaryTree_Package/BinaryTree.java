package BinaryTree_Package;

import Tools.DinamicQueue.Queue;

public class BinaryTree<T> implements TreeInterface<T> {
    BinaryNode<T> root;
    int size = 0;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public BinaryTree(Object objet) {
        root = new BinaryNode<T>(objet);
        size=1;
    }

    //INORDEN: Izquierdo-Raiz-Derecho
    public String inordenToString() {
        String String;
        return inorden(this.root, String = "");
    }


    public String inorden(BinaryNode root, String string) {
        if (root != null) {
            string = inorden(root.getLeft(), string);
            string += root.getObjeto().toString();
            string = inorden(root.getRight(), string);
        }
        return string;
    }

    //PREORDEN: Raiz-Izquierdo-Derecho
    public String preOrdenToString() {
        String String;
        return preOrden(this.root, String = "");
    }

    public String preOrden(BinaryNode root, String string) {
        if (root != null) {
            string += root.getObjeto().toString();
            string = preOrden(root.getLeft(), string);
            string = preOrden(root.getRight(), string);
        }
        return string;
    }

    //POSORDEN: Izquierdo-Derecho-Raiz
    public String posOrdenToString() {
        String String;
        return posOrden(this.root, String = "");
    }

    public String posOrden(BinaryNode root, String string) {
        if (root != null) {
            string = posOrden(root.getLeft(), string);
            string = posOrden(root.getRight(), string);
            string += root.getObjeto().toString();
        }
        return string;
    }

    public String widthOrderToString() {
        String string = "";
        return widthOrder(this, string);
    }

    public String widthOrder(TreeInterface<T> root, String string) {
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

    public boolean addWidth(Object objeto) {
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

    public boolean addDepth(Object objeto) { //completar
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

    public boolean remove(Object objeto){
        return removeObject(this.root,objeto);
    }
    public boolean removeObject(BinaryNode<T> raiz, Object objeto) {
        if (raiz == null) {
            return false;
        }

        Queue<TreeInterface<T>> cola = new Queue<>();
        cola.insert(raiz);

        while (!cola.isEmpty()) {
            BinaryNode<T> nodo = (BinaryNode<T>) cola.extract();

            if (nodo.getObjeto() == objeto) {
                eliminarNodo(nodo);
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


