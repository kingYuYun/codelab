package leetcode.qianx;

public class p1 {
    public static void main(String[] args) {
        int[] arr1={3,5,7,2,8,8,15,3};
        int[] arr2={1,0,1,0,1,0,1,0};
        int n=3;
        System.out.println(maxCandies(arr1,arr2,n));

    }

    private static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        int max=0;
        for (int i = 0; i <coin.length-n+1; i++) {
            int sum=0;

            int[] c=coin.clone();

            for (int j = i; j <n+i; j++) {
                c[j]=0;
            }

            for (int k = 0; k <candies.length ; k++) {
                if (c[k]==0)
                    sum+=candies[k];
            }
            if (sum>=max){
                max=sum;
            }
        }
        return max;
    }
}
