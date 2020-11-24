package javacode.datastructures.tree.redbalcktree;


public class RedblackTree {
    public static void main(String[] args) {

    }
}

class RBTrdd<T extends Comparable<T>>{
    public RBNode<T> mRoot = null;    // �����
    public static boolean RED = true;
    public static boolean BLACK = false;
    class RBNode <T extends Comparable<T>> {
        //��ɫ
        boolean color;
        //�ؼ��֣���ֵ��
        T key;
        //���ӽڵ�
        RBNode<T> left;
        //���ӽڵ�
        RBNode<T> right;
        //���ڵ�
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


