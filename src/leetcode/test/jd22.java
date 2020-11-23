package leetcode.test;

import java.util.Scanner;

public class jd22 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            long[][] arr = new long[n + 1][2 * n];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= 2 * i - 1; j++){
                    arr[i][n - i + j] = sc.nextLong();
                }
            }
            for(int i = n - 1; i >= 1; i--){
                for(int j = 1; j <= 2 * i - 1; j++){
                    arr[i][n - i + j] += Math.max(Math.max(arr[i + 1][n - i + j - 1], arr[i + 1][n - i + j]), arr[i + 1][n - i + j + 1]);
                }
            }
            System.out.println(arr[1][n]);
        }
}
