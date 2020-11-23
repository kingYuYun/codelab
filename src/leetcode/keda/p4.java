package leetcode.keda;

import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        int n=sc.nextInt();
        char[] c=s.toCharArray();
        String str=new String();
        String s1=s.substring(n);
        String s2=s.substring(0,n);
//        str=s1+s2;
        str=s2+s1;
        System.out.println(str);

//        if (n>=c.length){
//            System.out.print(s);
//        }else {
//            for (int i = n; i < c.length; i++) {
//                str += c[i];
//            }
//            for (int i = 0; i < n; i++) {
//                str += c[i];
//            }
//            System.out.print(str);
//        }
    }
}
