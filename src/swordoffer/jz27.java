package swordoffer;

public class jz27 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return null;
        }
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }
}
