package leetcode.nonam;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class peo1 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> printNode(TreeNode node){
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (node == null) {
            return res;
        }
        list.add(node);
        while (!list.isEmpty()){
            int len=list.size();
            ArrayList<Integer> l1=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node1=list.poll();
                l1.add(node1.val);
                if (node1.left!=null){
                    list.add(node1.left);
                }
                if (node1.right!=null){
                    list.add(node1.right);
                }
            }
            res.add(l1);
        }
        return res;


//        if (node==null){
//            throw new IllegalAccessException();
//        }
//        LinkedList<TreeNode> que=new LinkedList<>();
//        TreeNode tem=new TreeNode();
//        que.add(node);
//        int last=que.getFirst().val;
//        int nlast=0;
//        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> r1=new ArrayList<>();
//        while (!que.isEmpty()){
//            tem=que.removeFirst();
//            r1.add(tem.val);
//            if (tem.left!=null){
//                que.add(tem.left);
//                nlast=que.getLast().val;
//            }
//            if (tem.val==last){
//                res.add(r1);
//                r1=new ArrayList<Integer>();
//                last=nlast;
//            }
//        }
//
//        return res;
    }
}
