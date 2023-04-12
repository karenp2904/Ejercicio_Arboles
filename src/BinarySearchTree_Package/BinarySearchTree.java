package BinarySearchTree_Package;
import Estructuras.DinamicQueue.*;
import Estructuras.ListasEnlaceDoble.LinkedList;

import java.util.logging.Logger;
public class BinarySearchTree<T> implements TreeInterface<T>{
    BinaryNode<T> root;//raiz en el arbol
    int size=0; //es el encargado de dar la cantidad de nodos en el arbol
    int counterHeight=0;

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
        return counterHeight;
    }

    //INORDEN: Izquierdo-Raiz-Derecho
    public String inordenToString() {
        String String;
        return inorden(this.root, String = "");
    }
    private String inorden(BinaryNode<T> root, String string) {
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
    private String preOrden(BinaryNode<T> root, String string) {
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
    private String posOrden(BinaryNode<T> root, String string) {
        if (root != null) {
            string = posOrden(root.getLeft(), string);
            string = posOrden(root.getRight(), string);
            string += root.getObjeto().toString();
        }
        return string;
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
            string+="";
            string += nodo.getObjeto().toString();//se añade a la cadena
            if (nodo.getLeft() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                cola.insert(nodo.getLeft());// se añade a la cola el nodo derecho
            }
            if (nodo.getRight() != null) {//se verifica que no sea la hoja(ultimo nodo en el arbol)
                cola.insert(nodo.getRight());
            }
            //para el contador de la altura
            if((nodo.getLeft() != null&& nodo.getRight() != null)){
                counterHeight++;
            }else{
                if(nodo.getLeft() != null&&nodo.getRight() == null ){
                    counterHeight++;
                }else {
                    if(nodo.getRight() != null&&nodo.getLeft() == null){
                    counterHeight++;
                    }
                }
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















    //metodo con el comprable - revisar para implementar la clave
    //errores cuando el objeto es enero, no funciona :(((
    @Override
    public boolean add(T objeto) {
        boolean insertado=false;
        /*
        Tener en cuenta: Java Comparable y su implementación
        Este método es el usado para comparar dos objetos y decidir cuando uno es mayor que otro .
        Devuelve 1 si el objeto actual es mayor que el que pasamos como parámetro.
        Devuelve 0 si en la comparación se produce una relación de igualdad y devuelve -1 si es menor .
         */
        try{
            BinaryNode<T> temporal=new BinaryNode<>(objeto);//el temporal tendra el objeto que se ingresa
            Comparable<T> comparableObject=(Comparable<T>)objeto; //se usa una clase que va a comparar los objetos
            if(isEmpty()){
                this.root=temporal;// la raiz recibira el objeto que guarda el temporal
            }else{
                BinaryNode<T> current=this.root; //se inicia con el actual de la raiz
                while (!insertado){ //hasta que encuentre un espacio null
                    if(comparableObject.compareTo((T) current.getObjeto())<0){//si es menor  a la izquierda
                        if (current.left==null){
                            current.left=temporal;//se el asigna al nodo derecho el objeto
                            insertado=true;
                            size++;//se añade uno más al size
                        }else{
                            current=current.left;//el actual sera el nodo izquierdo del mismo
                        }
                    }else{
                        if(comparableObject.compareTo((T) current.getObjeto())>0){//si es mayor a al izquierda
                            if (current.right==null){
                                current.right=temporal;//se el asigna al nodo derecho el objeto
                                insertado=true;
                                size++;//se añade uno más al size
                            }else{
                                current=current.right;//el actual sera el nodo izquierdo del mismo
                            }
                        }else{ //cuando es cero
                            System.out.println("El elemento ya tiene un mismo valor en el arbol");
                            //no se agrega al arbol, no se aumenta el size
                            insertado= false;
                            break;
                        }
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return insertado;
        }
    }
    @Override
    public T extract(Object objeto) {
         /*
        CASO 1: Si el nodo es una hoja, lo elimina sin más
        CASO 2: Si el nodo tiene un hijo, devuelve el valor del hijo
        CASO 3: Si el nodo tiene dos hijos, elegir parametro de remover(izquierda o derecha)
         */
        boolean eliminado=false;
        T resultado=null;
        try{
            //misma dinamica que en remover, se sustituye el nodo que se quita pero se devuelve el valor del mismo
            if(!isEmpty()){
                if (objeto.equals(root.getObjeto())){//en caso de que el elemento a eliminar sea la raiz
                    root=sustituir(root);//metodo auxiliar
                    size--;//se resta un elemento
                }
                else{
                    BinaryNode<T> current=root;//nodo actual
                    BinaryNode<T> parent=root;//nodo padre
                    if(((Comparable) objeto).compareTo(root.getObjeto())<0){// en caso de que este en el lado inquierdo, menor al nodo
                        current=root.left;
                    }else {//en caso de que el objeto sea mayor a la raiz, verifica el lado derecho
                        current=root.right;
                    }
                    while ((current!=null)&& (eliminado==false)){//hasta que sea nulll-> llegue al final del arbol
                        if(objeto.equals(current.getObjeto())){
                            eliminado=true;
                            size--;//se resta

                            resultado= (T) current.getObjeto(); //en el extraer-> se extrae el objeto del actual

                            if(current==parent.left){
                                parent.left=sustituir(current);//se tiene conocimiento del padre y del hijo
                            }else{
                                parent.right=sustituir(current);//
                            }
                        }else{
                            parent=current;//el padre sera el actual
                            if(((Comparable) objeto).compareTo(current.getObjeto())<0){// se verifica si va hacia la izquierda o derecha
                                current=current.left;//el actual sera el nodo izquierdo
                            }else{//si es mayor el objeto estara en la derecha
                                current=current.right;//el actual sera el nodo derecho
                            }
                        }
                    }
                    if(eliminado==false){
                        Logger.getAnonymousLogger("Binary Tree");
                        resultado=null;
                        System.out.println("No se ha encontrado el nodo");
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return resultado;
        }
    }
    @Override
    public boolean remove(T objeto) {
          /*
        CASO 1: Si el nodo es una hoja, lo elimina sin más
        CASO 2: Si el nodo tiene un hijo, devuelve el valor del hijo
        CASO 3: Si el nodo tiene dos hijos, elegir parametro de remover(izquierda o derecha)
         */
        boolean eliminado=false;
        try{
           if(!isEmpty()){
               if (objeto.equals(root.getObjeto())){//en caso de que el elemento a eliminar sea la raiz
                   root=sustituir(root);//metodo auxiliar
                   size--;//se resta un elemento
               }
               else{
                   BinaryNode<T> current=root;//nodo actual
                   BinaryNode<T> parent=root;//nodo padre
                   if(((Comparable) objeto).compareTo(root.getObjeto())<0){// en caso de que este en el lado inquierdo, menor al nodo
                       current=root.left;
                   }else {//en caso de que el objeto sea mayor a la raiz, verifica el lado derecho
                       current=root.right;
                   }
                   while ((current!=null)&& (eliminado==false)){//hasta que sea nulll-> llegue al final del arbol
                       if(objeto.equals(current.getObjeto())){
                           eliminado=true;
                           size--;//se resta
                           //Resultado=current.getObject; //en el extraer-> se extrae el objeto del actual
                           if(current==parent.left){
                               parent.left=sustituir(current);//se tiene conocimiento del padre y del hijo
                           }else{
                               parent.right=sustituir(current);//
                           }
                       }else{
                           parent=current;//el padre sera el actual
                           if(((Comparable) objeto).compareTo(current.getObjeto())<0){// se verifica si va hacia la izquierda o derecha
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

}
