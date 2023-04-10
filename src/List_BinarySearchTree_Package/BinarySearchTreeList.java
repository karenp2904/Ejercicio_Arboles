package List_BinarySearchTree_Package;

import BinarySearchTree_Package.BinarySearchTree;

public class BinarySearchTreeList<T> extends BinarySearchTree<T> {

    public BinarySearchTreeList() {
        super();
    }

    public boolean addList(T objeto){
        if(objeto!=null){
            add(objeto); //este metodo añadir es el que se encuentre en el arbol de busqueda binaria
            return true;
        }else{
            return false;
        }
    }

    public boolean removeList(T objeto){
        return remove(objeto);//este metodo remover es el que se encuentre en el arbol de busqueda binaria
    }


}
