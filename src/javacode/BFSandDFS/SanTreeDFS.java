package javacode.BFSandDFS;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public String value;
    public Node left;
    public Node middle;
    public Node right;

    Node(String v) {
        value = v;
    }
}

public class SanTreeDFS {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Node node = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("G");
        Node node6 = new Node("K");

        node.left = node2;
        node.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;

//        List<String> result1 = SanTreeDFS.DFSByRecursion1(node);
//        Iterator<String> iterator1 = result1.iterator();
//        while (iterator1.hasNext()) {
//            System.out.print(iterator1.next() + " ");
//        }

        printTreeVertical(node);

    }

    private static void printTreeVertical(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        trace(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }

    public static void trace(Stack<Node> stack) {
        if (stack.isEmpty())
            return;

        Node current = stack.peek();
        if (null == current.left && null == current.middle && null == current.right) {
            List<Node> list = new ArrayList<>();
            StringBuilder buf = new StringBuilder(100);
            for (final Node tmp :
                    list) {
                buf.append(tmp.value).append(",");
            }
            System.out.println(buf.toString());
            stack.pop();
            return;
        }
        if (null != current.left) {
            stack.push(current.left);
            trace(stack);
        }
        if (null != current.middle) {
            stack.push(current.middle);
            trace(stack);
        }
        if (null != current.right) {
            stack.push(current.right);
            trace(stack);
        }

    }


    /**
     * DFS�ݹ�ʵ��
     *
     * @param root
     * @return
     */
    public static List<String> DFSByRecursion1(Node root) {
        if (root == null) {
            return null;
        }
        /*
        ����ڵ���߼�(�����ǵݹ�ĵ��ã�����ArrayList��ʱ����д�ڷ����ڲ�)
         private static List<Integer> result = new ArrayList<>();
         �Ұ� �˴��� result �Ķ���Ϊ��һ��ȫ�ֱ���
         */
        //��ű��������Ȼ�󷵻�

        result.add(root.value);

        if (root.left != null) {
            DFSByRecursion1(root.left);
            return result;
        }
        if (root.middle != null) {
            DFSByRecursion1(root.middle);

        }
        if (root.right != null) {
//            result.add(root.right.value);
            DFSByRecursion1(root.right);
        }
        return result;
    }

}
