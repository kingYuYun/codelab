package leetcode.nonam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class xc3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String m=sc.nextLine();
//        String[] s = sc.nextLine().split(" |,");
//        String t=sc.nextLine();
//
//        for (int i = 0; i < s.length; i++) {
//            int flag=1;
//            for (int j = 0; j < Math.min(m.length(),s[i].length()); j++) {
//                if (m.indexOf(s[i].charAt(i))<0){
//                    flag=-1;
//                    break;
//                }
//            }
//            s[i]=t;
//        }
//
//        for (String s1 :
//                s) {
//            System.out.print(s1+" ");
//        }
        ArrayList<String> places=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            places.add(sc.nextLine().trim());
        }
        Set<String> set=new HashSet<>();
        set=RollList(places.get(0),0);
        String target=places.get(1);
        for (String i :
                set) {
            if (places.get(1).contains(i)){
                target=target.replaceAll(i,places.get(2));
            }
        }
        System.out.println(target);
    }
    private static Set<String> RollList(String str,int i){
        Set<String> set=new HashSet<>();
        if(i>=(str.length()-1)){
            set.add(str);
            return set;
        }
        char[] charArray=str.toCharArray();
        String now="";
        for (int k = 1; k < str.length(); k++) {
            char temp=charArray[i];
            charArray[i]=charArray[k];
            charArray[k]=temp;
            now=String.valueOf(charArray);
            set.addAll(RollList(now,(i+1)));
            temp=charArray[i];
            charArray[i]=charArray[k];
            charArray[k]=temp;
        }
        return set;
    }
}
