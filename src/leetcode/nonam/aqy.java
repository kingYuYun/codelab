package leetcode.nonam;

import java.util.Arrays;
import java.util.Scanner;

public class aqy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

//        List<Integer> l=new ArrayList<>();
//        while (!sc.hasNextInt()){
//            l.add(sc.nextInt());
//        }
//        int[] nums=new int[l.size()];
//        for (int i = 0; i < l.size()-1; i++) {
//            nums[i]=l.get(i);
//        }

        System.out.println(maxnum(nums));

    }

    public static int maxnum1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int maxnum(int[] nums) {
        int c = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                c = nums[i];
            } else if (c == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return c;
    }
}
