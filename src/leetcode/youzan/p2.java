package leetcode.youzan;

import java.util.*;

public class p2 {
    public static void main(String[] args) {
        int[] a={1,2,4};
        int c= minMoves(a);
        System.out.println(c);
    }

    private static int minMoves (int[] nums) {
        // write code here

        int count=0;
        if (nums.length==1){
            return count;
        }
        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//
//        }
        for (int i :
                nums) {
            count+=Math.abs(nums[nums.length/2]-i);
        }
        return count;
    }
}
