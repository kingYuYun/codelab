package leetcode.keda;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] a=new int[1001];
        int[] c=new int[1001];
        int[] d=new int[1001];

        int x;
        int n;
        int m;
        n = in.nextInt();
        m = in.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x = in.nextInt();
                if (x>a[i]){
                    d[i]=a[i];
                    a[i]=x;
                    c[i]=j;
                }else {
                    if (x>d[i]){
                        d[i]=x;
                    }
                }
            }
        }

        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (c[i]!=c[j]) ans=Math.max(ans,a[i]*a[j]);
                else {
                    ans=Math.max(ans,a[i]*d[j]);
                    ans=Math.max(ans,d[i]*a[j]);
                }
            }
        }
        System.out.println(ans);
    }
//    public  static int maxnum(int[][] arr,int n,int m){
//
//    }
}
