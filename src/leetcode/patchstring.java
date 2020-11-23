package leetcode;

import java.util.List;
import java.util.Scanner;

public class patchstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            float len = s.length();//总长
            int count = 1;//个数至少为一个
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    count++;
                }
            }
            System.out.println((int)(len / count));
        }
    }
}
