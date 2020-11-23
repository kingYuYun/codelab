package leetcode.nonam;

import java.util.Scanner;
//you
//        i love you,oyu love me
//        jack
public class xc1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        String str = sc.nextLine();

        String[] s = str.split(" |,");
//        String[] s=sc.nextLine().split(" |,");
        String[] s2 = str.split(" ");

        String t = sc.nextLine();
        char[] c = m.toCharArray();
//        for (String s1 :
//                s) {
//            System.out.println(s1);
//        }
        int n=0;
        for (int i = 0; i < s2.length; i++) {
            if (s2[i].indexOf(",")>0){
                n=i;
                break;
            }
        }
        for (int i = 0; i < s.length; i++) {
            int flag = 1;
            if (m.length() != s[i].length()) continue;
            for (int j = 0; j < m.length(); j++) {
                if (s[i].indexOf(c[j]) < 0) {
                    flag = -1;
                    break;
                }
            }
            if (flag == 1) {
                s[i] = t;
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (n==i) System.out.print(s[i]+",");
            else  System.out.print(s[i] + " ");
        }
    }
}
