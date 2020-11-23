package leetcode.test;

import java.util.Scanner;

public class jd222 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine().trim();
        // String[] arr = s.split("\\s");
        int[][] dp = new int[2][2 * n - 1];
        dp[0][n - 1] = Integer.parseInt(s);

        int cur = 0;
        int last;
        for (int i = 1; i < n; i++) {
            cur = i % 2;
            last = 1 - cur;

            s = scanner.nextLine().trim();
            String[] arr = s.split("\\s");
            int beginIndex = n - 1 - i;
            // 读当前行的数据
            for (int j = 0; j < arr.length; j++) {
                dp[cur][beginIndex++] = Integer.parseInt(arr[j]);
            }

            beginIndex = n - 1 - i;
            // 更新当前行的路径和
            dp[cur][beginIndex] += dp[last][beginIndex + 1];
            beginIndex ++;
            dp[cur][beginIndex] += Math.max(dp[last][beginIndex], dp[last][beginIndex + 1]);
            beginIndex++;

            for (int j = 2; j < (arr.length - 1); j++) {
                int lastMax = Math.max(dp[last][beginIndex - 1], dp[last][beginIndex]);
                lastMax = Math.max(lastMax, dp[last][beginIndex + 1]);
                dp[cur][beginIndex] += lastMax;
                beginIndex++;
            }

            dp[cur][beginIndex] += dp[last][beginIndex - 1];
        }

        int result = 0;
        for (int j = 0; j < dp[0].length; j++) {
            result = Math.max(result, dp[cur][j]);
        }
        System.out.println(result);
    }
}
