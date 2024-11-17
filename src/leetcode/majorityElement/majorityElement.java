package leetcode.majorityElement;

public class majorityElement {
    public static void main(String[] args) {
        int nums [] = {2,2,1,1,3,3,3};
        int result = majorityElements(nums);
        System.out.println(result);
    }

    private static int majorityElements(int[] nums) {
        int count = 0;
        int majority = 0;

        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            count += (num == majority) ? 1 : -1;
        }

        return majority;
    }
}
