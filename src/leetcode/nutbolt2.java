package leetcode;

import java.util.Arrays;

public class nutbolt2 {
    static int k = 1;

    public static void main(String[] args) {
        int[] Nut = {6, 8, 1, 2, 9, 3, 7};
        int[] Screw = {9, 3, 7, 1, 6, 2, 8};
        System.out.println("螺母(Nut)  排序前:" + Arrays.toString(Nut));
        System.out.println("螺钉(Screw)排序前:" + Arrays.toString(Screw));
        Quicksort(Nut, Screw, 0, Screw.length - 1);

    }

    public static void Quicksort(int[] Nut, int[] Screw, int left, int right) {
        if (left >= right) return;
        System.out.println("第" + (k++) + "次排序：");
        int std = partition(Screw, left, right, Nut[left]);
        partition(Nut, left, right, Screw[std]);
        System.out.println("此时的螺母(Nut)  的序列为：" + Arrays.toString(Nut));
        System.out.println("此时的螺钉(Screw)的序列为：" + Arrays.toString(Screw));
        Quicksort(Nut, Screw, left, std - 1);
        Quicksort(Nut, Screw, std + 1, right);
    }

    public static int partition(int[] nums, int left, int right, int std) {
        if (left >= right) return left;
        int i = left, j = left;
        while (j < right) {
            if (nums[j] < std) {
                swap(nums, i, j);
                i++;
            } else if (nums[j] == std) {
                swap(nums, j, right);
                continue;
            }
            j++;
        }
        swap(nums, i, j);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
