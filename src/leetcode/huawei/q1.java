package leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> l = new ArrayList<>();
        int n = 0;
        String a;
        while (true) {
            String s = sc.nextLine();
            if (Integer.parseInt(s) > 9) {
                l.add(s);
                n++;
            } else {
                a = s;
                break;
            }
        }
        int[] arr = new int[n];
        String str = new String();
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
//        System.out.println(l.get(3));
        for (int i = 0; i < ch.length; i++) {
            if (Integer.parseInt(String.valueOf(ch[i])) < Integer.parseInt(a)) {
//                System.out.print(ch[i]);
                str += String.valueOf(ch[i]);
            }
        }
        int key=Integer.parseInt(a);
//        System.out.println(str);
//        ArrayList<String> tzplace=new ArrayList<>();
        for (int i = 0; i < n; i++) {
//            System.out.println(l.get(i));
            char[] ch1 = l.get(i).toCharArray();
            String str1 = new String();
            for (int j = 0; j < ch1.length; j++) {
                if (Integer.parseInt(String.valueOf(ch1[j])) < Integer.parseInt(a)) {
                    str1 += String.valueOf(ch1[j]);
                }
            }
//            System.out.println(str1);

//            str1=gettz(l.get(i),key);
            Pattern pattern=Pattern.compile(str);
            Matcher matcher=pattern.matcher(str1);
            if (str1.contains(str)) {
//                arr[i] = i;
                System.out.println(l.get(i));
            }

        }

    }
    private static String gettz(String ss,int key){
        String tz=null;
        for (int i = 0; i < ss.length(); i++) {
            int num=(int) ss.charAt(i)-(int)('0');
            if(num<key){
                tz+=String.valueOf(num);
            }
        }
        return tz;
    }
}
