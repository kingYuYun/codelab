package leetcode.test;

import java.util.Scanner;

public class substring {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String origin = scanner.nextLine();
        origin = origin.replaceAll("_+", "_");
        int start = 0, end = origin.length();
        if (origin.charAt(0) == '_') {
            start = 1;
        }

        if (origin.charAt(origin.length() - 1) == '_') {
            end -= 1;
        }

        System.out.println(origin.substring(start, end));
    }
}
