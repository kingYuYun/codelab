package leetcode;

import java.util.Arrays;

public class zhishu {
    public static void main(String[] args) {
        int[] arr = {2,5,7,11,8,19,12,25};

        System.out.println(Arrays.toString(isPrime(arr)));;
    }

    private static int[] isPrime(int[] arr) {
        boolean isPrime = true;
        int index=0;
        int[] b = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1 || arr[i] % 2 == 0 && arr[i] != 2) {
                isPrime = false;
            } else {
                for (int j = 2; j < arr[i]; j += 2) {
                    if (arr[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime)
                b[index++]=arr[i];

            isPrime = true;
        }
        return b;
    }
}
