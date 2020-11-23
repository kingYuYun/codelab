package leetcode;

import java.util.Scanner;

public class wangyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res=new int[t];


        while (t>=0){
            int n=sc.nextInt();
            int[][] arr=new int[n][2];
            for(int i = 0; i < n; i++){
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            res[t]=count(n,arr);
            t--;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
    private static int count(int n,int[][] arr){
        int count=0;
        int x,y=0;
//        int[][] stack=new int[][];
        for (int i = 0; i <n; i++) {
            if(arr[i][0]==0 || arr[i][0]==2){
                if (arr[i][1]==1){
                    count++;
                }else {
                    count--;
                }
            }

        }
      return count;
    }
}
