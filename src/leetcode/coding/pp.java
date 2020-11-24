package leetcode.coding;

import java.util.*;

public class pp {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] s=in.nextLine().split(" ");
        System.out.println(s[2]);
        String wo1="a";
        String wo2="a";

        System.out.println(findClosest(s,wo1,wo2));
    }
    public static int findClosest(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            int t = p1;
            if (words[i] == word1) p1 = i;
            if (words[i] == word2) p2 = i;
            if (p1 != -1 && p2 != -1) {
                if (word1 == word2 && t != -1 && t != p1) {
                    res = Math.min(res, Math.abs(t - p1));
                } else if (p1 != p2) {
                    res = Math.min(res, Math.abs(p1 - p2));
                }
            }
        }
        return res;
    }
}
