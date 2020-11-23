package leetcode.test;

import java.util.Scanner;

public class baidu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] x = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = sc.nextInt();
            }
        }
        int[][] arr = new int[n][m];
        float res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    arr[i][j] = x[i][j];
                } else if(i != 1 || j!= 1 || i != n|| j != m){
                    res = (float) ((x[i][j] + x[i - 1][j] + x[i + 1][j] + x[i][j - 1] + x[i][j + 1])/5.0);

                    if ((res - Math.floor(res)) >= 0.5) {
                        res = (float) Math.ceil(res);
                    } else {
                        res = (float) Math.floor(res);
                    }
                    arr[i][j] = (int) res;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
