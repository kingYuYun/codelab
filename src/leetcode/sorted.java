package leetcode;

import java.util.Arrays;

public class sorted {
    public static void main(String[] args) {
        int[] a={4,-7,-9,-8,0,6,3,2,12,55,6,88,34,56};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] arr) {
        int head = 0, tail = arr.length - 1;
        while (head < tail) {
            int positive = head, negative = tail;
            for (int i = head; i <= tail; ++i) {
                if (arr[i] >= 0 && (arr[positive] < 0 || arr[i] < arr[positive]))
                    positive = i;
                else if (arr[i] < 0 && (arr[negative] >= 0 || arr[i] < arr[negative]))
                    negative = i;
            }
            if (positive != head) {
                int temp = arr[head];
                arr[head] = arr[positive];
                arr[positive] = temp;
                if (negative == head)
                    negative = positive;
            }
            if (negative != tail) {
                int temp = arr[tail];
                arr[tail] = arr[negative];
                arr[negative] = temp;
            }

            head++;
            tail--;
        }
    }
}
