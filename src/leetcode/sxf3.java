package leetcode;

import java.util.Arrays;

public class sxf3 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 2, 7, 8};
        System.out.println(maxCoins(arr));
    }

    public static int maxCoins(int[] piles) {
        // write code here
        Arrays.sort(piles);
        int l = 0;
        int r = piles.length - 2;
        int sum = 0;
        while (l < r) {
            sum += piles[r];
            r -= 2;
            l++;
        }
        return sum;
    }
}
