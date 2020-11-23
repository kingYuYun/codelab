package leetcode.nonam;

import java.util.Map;
import java.util.Scanner;

public class dancijili {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] word = in.nextLine().split(" ");
        String w1 = in.nextLine();
        String w2 = in.nextLine();
        System.out.println(find(word, w1, w2));

    }

    public static int find(String[] s, String w1, String w2) {
        int p1 = -1, p2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; ++i) {
            int t = p1;
            if (s[i] == w1) p1 = i;
            if (s[i] == w2) p2 = i;
            if (p1 != -1 && p2 != -1) {
                if (w1 == w2 && t != -1 && t != p1) {
                    res = Math.min(res, Math.abs(t - p1));
                } else if (p1 != p2) {
                    res = Math.min(res, Math.abs(p1 - p2));
                }
            }
        }
        return res;
    }
}
