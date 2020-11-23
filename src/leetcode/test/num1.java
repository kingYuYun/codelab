package leetcode.test;

import java.util.Scanner;

public class num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x=new long[n];
        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
        }
        System.out.println(sum1(n,x));
    }

    static long sum1(int n, long[] x){
        long sum=0;
        for (int i = 0; i < n; i++) {
            sum+=x[i]/2;
        }
        return sum;
    }
}
