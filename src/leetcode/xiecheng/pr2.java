package leetcode.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] income = new int[100][2];
        int i=0;
        while (true) {
            String s=in.nextLine();
            if (s.equals("#")) break;
            for (int j = 0; j <2 ; j++) {
                income[i][j]=Integer.parseInt(s.split(" ")[j]);
            }
            i++;
        }
        System.out.println(income[0][1]);
    }

    private static int maxnum(int[][] income){
        int[][] dp=new int[income.length][income.length];
        for (int i = 0; i < income.length; i++) {
            dp[i][0]=income[i][0];
        }
        for (int i = 0; i < income.length; i++) {
            dp[i][1]=income[i][1];
        }

        for (int i = 1; i < income.length; i++) {
            for (int j = 0; j < income.length; j++) {

            }

        }
        return 0;
    }
}
