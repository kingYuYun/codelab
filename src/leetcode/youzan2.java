package leetcode;

public class youzan2 {
    public static void main(String[] args) {
        int[] arr={3,6,5,1,8};

        int n=maxnum(arr);
        System.out.println(n);
    }

    public static int maxnum(int[] nums){
        int[] dp = new int[5];
        dp[nums[0] % 3] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[5];
            for (int k = 0; k < 5; k++)
                temp[k] = dp[k];
            for (int j = 0; j < 5; j++) {
                int index = (temp[j] + nums[i]) % 5;
                dp[index] = Math.max(dp[index], temp[j] + nums[i]);
            }
        }
        return dp[0];
    }
}
