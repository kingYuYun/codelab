package leetcode.xiechen;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BTree {
    private int node;
    private String string;
    private BTree LChild;
    private BTree RChild;

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public BTree getLChild() {
        return LChild;
    }

    public void setLChild(BTree LChild) {
        this.LChild = LChild;
    }

    public BTree getRChild() {
        return RChild;
    }

    public void setRChild(BTree RChild) {
        this.RChild = RChild;
    }

    private BTree(int node, String string) {
        this.node = node;
        this.string = string;
        LChild = null;
        RChild = null;
    }

    public static BTree InitBtree(int num, String string) {
        if (num == 0) {
            return null;
        }
        BTree root = new BTree(num, string);
        root.setLChild(InitBtree(num - 1, "G"));
        root.setRChild(InitBtree(num - 1, "R"));
        return root;
    }

    public static void outBST(BTree node, StringBuffer s) {
        if (node == null) return;
        outBST(node.LChild, s);
        s.append(node.string);
        outBST(node.RChild, s);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _n;
        try {
            _n = in.nextLine();
            Pattern pattern=Pattern.compile("[0-9]*");
            if (!pattern.matcher(_n).matches()) {
                System.out.println("N");
                return;
            }

            if (Integer.parseInt(_n) > 12 || Integer.parseInt(_n) < 1){
                System.out.println("O");
                return;
            }

        } catch (Exception e) {
            _n = null;
        }


        StringBuffer sb = new StringBuffer();
        BTree root = InitBtree(Integer.parseInt(_n), "R");
        outBST(root, sb);
        res = sb.toString();
        System.out.println(res);
    }

}
