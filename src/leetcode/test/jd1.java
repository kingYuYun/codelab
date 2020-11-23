package leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        num(n);
    }

    private static void num(int n) {
        int count = 0;
        int[] arr = {2, 3, 5};
        List<Integer> res = new ArrayList<Integer>();
        while (n > 0) {
            n -= 1;
            res.add(n % 3);
            n /= 3;
        }
        for (int i = res.size()-1; i >= 0; i--) {
            System.out.println(arr[res.get(i)]);
        }

    }
}