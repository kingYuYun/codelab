package leetcode;

import java.util.Scanner;

public class test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr=new int[]{5,3,7,6};

        boolean f=judgePoint24(arr);
        System.out.println(f);

    }
      static  boolean judgePoint24(int[] nums) {
            if(nums == null || nums.length == 0){
                return false;
            }

            int n = nums.length;
            double [] arr = new double[n];
            for(int i = 0; i < n; i++){
                arr[i] = nums[i];
            }

            return dfs(arr);
        }

       static boolean dfs(double [] arr){
            if(arr.length == 1){
                return Math.abs(arr[0] - 24) < 0.001;
            }

            for(int i = 0; i < arr.length; i++){
                for(int j = i + 1; j < arr.length; j++){
                    double [] next = new double[arr.length - 1];
                    for(int k = 0, ind = 0; k < arr.length; k++){
                        if(k == i || k == j){
                            continue;
                        }
                        next[ind++] = arr[k];
                    }
                    for(double can : compute(arr[i], arr[j])){
                        next[next.length - 1] = can;
                        if(dfs(next)){
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        static double [] compute(double a, double b){
            return new double[]{a * b, a + b, a - b, b - a, a / b, b / a};
        }

}
