package leetcode.mihayou;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();

        System.out.println(ismatch(s, p));
    }

    public static boolean ismatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean hm = !s.isEmpty() && (s.charAt(0)) == p.charAt(0) || p.charAt(0) == '.';
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return ismatch(s, p.substring(2));
        } else if (p.length() >= 2 && p.charAt(1) == '+') {
            return hm && ismatch(s.substring(2), p);
        } else if (hm) {
            return ismathc(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

    public static boolean ismathc(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matchs(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else if (p.charAt(j - 1) == '+') {
                    f[i][j] = f[i][j - 2];
                    if (matchs(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matchs(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matchs(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
