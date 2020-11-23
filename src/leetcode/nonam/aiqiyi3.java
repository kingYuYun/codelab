package leetcode.nonam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class aiqiyi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        List ls=func(nums);
//        for (int i = 0; i < ls.size(); i++) {
//            System.out.print(ls.get(i));
//        }
    }
    public static List<List<Integer>> func(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int t=0-nums[i];
            int l=i+1;
            int r=len-1;
            while (l<r){
                List<Integer> list=new ArrayList<>();
                if (nums[l]+nums[r]==t){
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (r>l&&nums[l+1]==nums[l]) l++;
                    while (r>l&&nums[r]==nums[r-1]) r--;
                    l++;
                    r--;

                }else if (nums[l]+nums[r]>t) r--;
                else l++;
            }

        }
        for (List ls:
        res){
            for (int i = 0; i < ls.size(); i++) {
                System.out.print(ls.get(i)+" ");
            }
            System.out.println("");
        }
        return res;
    }

}
