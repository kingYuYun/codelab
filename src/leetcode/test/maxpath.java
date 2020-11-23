package leetcode.test;

import java.util.Scanner;

public class maxpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a=sc.nextInt();
//        int b=sc.nextInt();
        String[] s = sc.nextLine().split(",");
        int a = Integer.parseInt(s[0]);

        int b = Integer.parseInt(s[1]);

        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int out = maxPathSum(arr);
        System.out.println(out);
        System.out.println(shortestRoad1(arr));
    }

    public static int shortestRoad1(int arr[][])
    {
        int dp[]=new int[arr[0].length];
        dp[0]=arr[0][0];
        for(int j=1;j<arr[0].length;j++)
        {
            dp[j]=dp[j-1]+arr[0][j];
            //求出第一行的dp
        }
        for(int i=1;i<arr.length;i++)
        {
            dp[0]=arr[i][0]+dp[0];
            //dp[0]代表每一行最左边的dp，
            //后一行的dp覆盖前一行的dp
            for(int j=1;j<arr[0].length;j++)
            {
                dp[j]=Math.min(dp[j-1]+arr[i][j], dp[j]+arr[i][j]);
            }
        }
        return dp[arr[0].length-1];
    }

    public static int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid[0] == null)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int j = 1; j < n; j++)
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        return dp[m - 1][n - 1];
    }
    public static int maxPathSum(int[][] grid) {
        int[] sum = new int[grid[0].length];
        for (int j = 0; j < sum.length; j++) {
            if (j == 0) {
                sum[j] = grid[0][j];
            } else {
                sum[j] = sum[j - 1] + grid[0][j];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            int[] currentSum = new int[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    currentSum[j] = sum[j] + grid[i][j];
                } else {
                    currentSum[j] = Math.max(sum[j], currentSum[j - 1]) + grid[i][j];
                }
            }
            sum = currentSum;
        }
        return sum[grid[0].length - 1];
    }

}
