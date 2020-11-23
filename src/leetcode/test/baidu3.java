package leetcode.test;

import java.util.Scanner;

public class baidu3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr=new int[n][3];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

    }
}
