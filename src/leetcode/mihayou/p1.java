package leetcode.mihayou;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        printABC(m, n);

    }

    public static void printABC(int m, int n) {
        char[][] charstr = new char[m][n];
        int count = 0;
        StringBuffer alp = getAlp(m, n);
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;

        while ((left <= right) && (top <= bottom)) {
            for (int i = left; i <= right; i++) {
                charstr[top][i] = alp.charAt(count);
                count++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                charstr[i][right] = alp.charAt(count);
                count++;
            }
            if ((top + 1) <= bottom) {
                for (int i = right - 1; i >= left; i--) {
                    charstr[bottom][i] = alp.charAt(count);
                    count++;
                }
            }
            if ((left + 1) <= right) {
                for (int i = bottom - 1; i > top; i--) {
                    charstr[i][left] = alp.charAt(count);
                    count++;
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(charstr[i][j]+" ");
            }
            System.out.println("");
        }


    }

    private static StringBuffer getAlp(int m, int n) {
        StringBuffer singAlp = new StringBuffer();
        StringBuffer useAlp = new StringBuffer();

        int allnums = m * n;
        int filstchar = 'A';
        int lastchar = 'Z';
        for (int i = filstchar; i <= lastchar; i++) {
            char e = (char) i;
            singAlp.append(e);
        }
        int totalAlp = (allnums / 26) + 1;
        for (int i = 0; i < totalAlp; i++) {
            useAlp.append(singAlp);
        }
        return useAlp;
    }


}
