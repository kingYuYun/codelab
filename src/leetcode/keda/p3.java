package leetcode.keda;

import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i;
        for ( i = 0; n>0 ; i++) {
            n&=n-1;
        }
        System.out.print(i);
    }
}
