package leetcode.nonam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class aqy2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(len(s));
    }
    public static int len(String s){
        Set<Character> set=new HashSet<>();
        int l=0;
        int r=0;
        int res=0;
        while (r<s.length()){
            char c=s.charAt(r++);
            while (set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res=Math.max(res,r-l);
        }
        return res;
    }
}
