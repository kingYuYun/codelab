package leetcode.xhs;

import java.util.*;

public class test {
    public static void main(String args[]) {

        int[] arr = { 12, 45, 356, 767, 33, 23, 35 };
        List list=new ArrayList();
        System.out.println(getMaxSum(arr));
    }

    public static String getMaxSum(int[] nums) {
        if (nums == null) {
            return "";
        }
        String[] numsStr = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            numsStr[i++] = num + "";
        }
        Arrays.sort(numsStr, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String temp1 = str1 + str2;
                String temp2 = str2 + str1;
                return (-temp1.compareTo(temp2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : numsStr)
            sb.append(s);
        return sb.toString();
    }
}
