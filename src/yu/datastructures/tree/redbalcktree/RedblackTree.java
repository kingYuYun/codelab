package yu.datastructures.tree.redbalcktree;


public class RedblackTree {
    public static void main(String[] args) {

    }
}

class RBTrdd<T extends Comparable<T>>{
    public RBNode<T> mRoot = null;    // 根结点
    public static boolean RED = true;
    public static boolean BLACK = false;
    class RBNode <T extends Comparable<T>> {
        //颜色
        boolean color;
        //关键字（键值）
        T key;
        //左子节点
        RBNode<T> left;
        //右子节点
        RBNode<T> right;
        //父节点
        RBNode<T> parent;

        public RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "" + key + (this.color == RED ? "RED" : "BLACK");
        }
    }
}


