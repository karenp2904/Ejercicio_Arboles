package BasicTreeNode;

public class TreeNode<T> {

        T objeto;

        public TreeNode() {
        }
        public TreeNode(T objeto) {
            this.objeto = objeto;
        }

        public T getObjeto() {
            return objeto;
        }

        public void setObjeto(T objeto) {
            this.objeto = objeto;
        }


}
