package leetcode.didi;

import java.util.Scanner;

public class d1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s=sc.nextLine();

        char[] c = s.toCharArray();

        String str = new String();

        int index1 = 0;
        for (int i = 0; i < s.length() / n; i++) {
            String s1 = s.substring(index1, index1 + n);
            StringBuilder sb = new StringBuilder(s1);
            str += sb.reverse().toString();
            index1 += n;
        }

        int index = s.length() - 1;
        for (int i = (s.length() % n); i >0; i--) {
            str += s.charAt(index);
            index--;
        }

        System.out.println(str);

    }
}
