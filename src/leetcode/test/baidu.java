package leetcode.test;

import java.util.Scanner;

public class baidu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] xy=sc.nextLine().split(" ");
        int x=Integer.parseInt(xy[0]);
        int y=Integer.parseInt(xy[1]);

//        int x = sc.nextInt();
//        int y=sc.nextInt();
        String s=sc.nextLine();
        char[] arr=s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'U') {
                y++;
            } else if (arr[i] == 'D') {
                y--;
            } else if (arr[i] == 'L') {
                x--;
            } else if (arr[i] == 'R') {
                x++;
            }
        }
        System.out.println(x+" "+y);
    }
}
