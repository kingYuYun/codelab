package leetcode;

import java.util.Scanner;

public class san1 {
    private static int n=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
//        for (String c :
//                s) {
//            System.out.print(c);
//        }
        int a=Integer.parseInt(s[0]);
        int b=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[0]);
        int v=Integer.parseInt(s[0]);
        System.out.println(minout(a,b,k,v));
        System.out.println(n);
    }

    public static int minout(int a,int b,int k,int v){
        n++;
        int count=0;
        count=k*v;
        if (b<=k+1){
            return (a/v)+1;
        }else{
            b=b-k+1;
        }

        if (a<count) {
            return 1;
        }
        else {
            return minout(a-count, b, k, v);
        }
    }
}
