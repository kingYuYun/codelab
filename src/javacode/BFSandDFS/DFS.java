package javacode.BFSandDFS;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFS {
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.left = treeNode8;
        treeNode5.left = treeNode9;
        treeNode6.left = treeNode10;

        treeNode7.left = treeNode11;
        treeNode7.right = treeNode12;

        List<Integer> result = DFS.DFSByRecursion(treeNode);

        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

//        List<Integer> result1 = DFS.DFSByStack(treeNode);
//        Iterator<Integer> iterator1 = result1.iterator();
//        while (iterator1.hasNext()) {
//            System.out.print(iterator1.next() + " ");
//        }



    }

    /**DFS�ĵ���ʵ�ְ汾��Stack��
     *
     * @param root
     * @return
     */
    public static List<Integer> DFSByStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();

            /*
            ���� TreeNode �ڵ� ���߼�
             */
            result.add(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

        }
        return result;
    }


    /**DFS�ݹ�ʵ��
     *
     * @param root
     * @return
     */
    public static List<Integer> DFSByRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        /*
        ����ڵ���߼�(�����ǵݹ�ĵ��ã�����ArrayList��ʱ����д�ڷ����ڲ�)
         private static List<Integer> result = new ArrayList<>();
         �Ұ� �˴��� result �Ķ���Ϊ��һ��ȫ�ֱ���
         */
        //��ű��������Ȼ�󷵻�

        result.add(root.val);

        if (root.left != null) {
            DFSByRecursion(root.left);
        }
        if (root.right != null) {
            DFSByRecursion(root.right);
        }
        return result;
    }

}
