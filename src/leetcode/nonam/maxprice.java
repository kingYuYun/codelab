package leetcode.nonam;

import java.util.Scanner;

public class maxprice {
    public static void main(String[] args) {
//        char[] s1={'a','b','c','d','e','f','g'};
//        char[] s2={'b','d','a','c','f','g','e'};
//        int n=7;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();


        char[] s1 = str1.replace(" ","").toCharArray();
        char[] s2 = str2.replace(" ","").toCharArray();

        for (char c :
                s1) {
            System.out.println(c);
        }

//        System.out.println(maxout(s1, s2, n));
    }

    public static int maxout(char[] s1, char[] s2, int n) {

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // ��ȡ�������ַ�
                char c1 = s1[i], c2 = s2[j];
                if (c1 == c2) {
                    // ȥ������ǰ�����һ���ֵ��1����
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //Ҫô��text1��ǰ��һ��Ҫô��text2��ǰ��һ�����������ֵ
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][n];
    }
}
