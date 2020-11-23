package leetcode;

import java.util.Scanner;

public class pro3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(numint(arr));
    }

    public static void dfs(int[][] nums, int r, int c) {
        int nr = nums.length;
        int nc = nums[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || nums[r][c] == 0) {
           return;
        }
        nums[r][c] = 0;
        dfs(nums, r - 1, c);
        dfs(nums, r + 1, c);
        dfs(nums, r, c - 1);
        dfs(nums, r, c + 1);

    }

    public static int numint(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int r = nums.length;
        int c = nums[0].length;
        int num = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (nums[i][j] == 1) {
                    ++num;
                    dfs(nums, i, j);
                }
            }
        }
        return num;
    }


}
