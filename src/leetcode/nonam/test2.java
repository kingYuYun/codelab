package leetcode.nonam;

import java.util.Scanner;

public class    test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        n = 1024 - n;
        int result = 0;
        int num = n / 64;
        n = n - 64 * num;
        result += num;

        num = n / 16;
        n = n - 16 * num;
        result += num;

        num = n / 4;
        n = n - 4 * num;
        result += num;

        result += n;
        System.out.println(result);
    }


}
