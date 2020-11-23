package leetcode.zijie;

import java.util.Map;

public class pro {
    public static void main(String[] args) {
//        int[] arr={0,0,1,1,3,1,2,0};
        int[] arr={2,0,3,1,1,1,0,0};
        if (PolygonArea(arr)>0){
            System.out.println("no");
        }else {
            System.out.println("yes");
        }

        System.out.println(Math.abs(area(arr)));


    }

    //判断值为正，逆时针；为负则是顺时针
   private static double PolygonArea(int[] arr) {
        int sum=(arr[4]-arr[2])*(arr[7]-arr[5])-(arr[5]-arr[3])*(arr[6]-arr[4]);
       return sum;
    }
    private static int area(int[] arr){

        return (arr[5]*(arr[6]-arr[0]));
    }

}
