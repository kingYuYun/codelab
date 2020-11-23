package leetcode.test;

import java.util.Scanner;

public class jd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] a=new int[n][2 * n - 1];
        int[][] b=new int[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=2*i-1; j++) {
                a[i][j]=sc.nextInt();
            }
        }
        b[0][0]=a[0][0];
        int max=0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=2*i-1; j++) {
                if (j==0)
                    b[i][j]=b[i-1][j]+a[i][j];
                else if(j==i)
                    b[i][j]=b[i-1][j-1]+a[i][j];
//                else if (j==i+1)
//                    b[i][j]=b[i][j-1]+a[i][j];
                else
                    b[i][j]=Math.max(b[i-1][j-1],b[i-1][j]+a[i][j]);
            }
        }

        max=b[n-1][0];
        for (int i = 1; i < b[n-1].length; i++) {
            if (b[n-1][i]>max)
                max=b[n-1][i];
        }
        System.out.println(max);
    }
}
