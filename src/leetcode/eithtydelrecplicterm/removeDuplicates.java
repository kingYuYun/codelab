package leetcode.eithtydelrecplicterm;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,2,3,3,4};
        int result = removeDuplicate(nums);
        System.out.println(result);
    }

    private static int removeDuplicate(int[] nums) {
        if (nums.length<=2) {
            return nums.length;
        }

        int i = 0; // 记录新数组的最后一个有效位置
        int count = 1; // 当前元素的出现次数

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[++i] = nums[j];
            }
        }

        return i + 1; // 返回新数组的长度
    }
}
