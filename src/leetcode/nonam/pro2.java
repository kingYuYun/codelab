package leetcode.nonam;

import java.util.Set;
import java.util.TreeSet;

public class pro2 {
    public int firstMissingPositive (int[] nums) {
        Set<Integer> set=new TreeSet<>();
        for (int num :
                nums) {
            set.add(num);
        }
        System.out.println(set);
        int i=1;
        while (i<nums.length+1){
            if (!set.contains(i)){
                return i;
            }
            i++;
        }
        return i;
    }


//    public int firstMissingPositive (int[] nums) {
//        // write code here
//        int l=0;
//        int r=nums.length;
//        while(l<r){
//            if(nums[l]==l+1){
//                l++;
//            }else if(nums[r]<=1||nums[l]>r||nums[nums[l]-1]==nums[l]){
//                nums[l]=nums[--r];
//            }else{
//
//            }
//        }
//        return l+1;
//    }
}
