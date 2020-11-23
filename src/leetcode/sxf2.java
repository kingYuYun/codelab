package leetcode;

public class sxf2 {
    public static void main(String[] args) {
        String a = "horse";
        String b = "rose";
        System.out.println(minDistance(a, b));
    }

    public static int minDistance(String a, String b) {
        // write code here
        int[][] dp = new int[99][99];
        for (int i = 1; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= b.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
