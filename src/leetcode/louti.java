package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class louti {
    public static void main(String[] args) {
        System.out.println(count(3));
        System.out.println(climbStairs(3));

    }

    /**di
     * @param ladder 台阶数量
     * @return 总的爬法
     */
    private static int count(int ladder) {
        if (ladder <1) {
            return 0;
        }
        if (ladder == 1) {
            return 1;
        }
        if (ladder == 3) {
            return 4;
        }
        return count(ladder-1)+count(ladder-3);



    }

    private static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        if (n == 3)
            return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

}
