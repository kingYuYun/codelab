package leetcode.test;

import java.util.Scanner;

public class num3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int min=suma(a)-price(n,a);
        System.out.println(min);
    }

    private static int suma(int[] a) {
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        return sum;
    }

    private static int price(int n,int[] a){
        int[] p=new int[n];
        int[] w=new int[n];
        p=a;
        w=a;
        int[] dp=new int[n];

        int max=0;

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j<n; j++) {
            if (p[j]!=w[i]){
                dp[j]=Math.max(dp[j],dp[w[i]]+dp[p[i]]);
            }else {
                dp[j]=dp[i];
            }
                for (int k = 0; k < n; k++) {
                    max=max>dp[i]?max:dp[i];
                }
            }
        }
        return max;
    }

}
