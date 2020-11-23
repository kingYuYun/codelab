package leetcode.xiaomi;

import java.util.Scanner;

public class xm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            removestr(str);
    }
    public static void removestr(String s){
        StringBuffer sb=new StringBuffer();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if (s.indexOf(c)==s.lastIndexOf(c)){
                sb.append(c);
            }else {
                int num=s.indexOf(c);
                if (num==i){
                    sb.append(c);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
