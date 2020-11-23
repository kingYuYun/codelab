package leetcode.keda;

import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {
        int[] arr = { 25, 84, 21, 47, 15, 27, 68, 35, 35, 20 };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        quickSort(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //���±�
        int r = right; //���±�
        //pivot ����ֵ
        int pivot = arr[(left + right) / 2];
        int temp = 0; //��ʱ��������Ϊ����ʱʹ��
        //whileѭ����Ŀ�����ñ�pivot ֵС�ŵ����
        //��pivot ֵ��ŵ��ұ�
        while (l < r) {
            //��pivot�����һֱ��,�ҵ����ڵ���pivotֵ,���˳�
            while (arr[l] < pivot) {
                l += 1;
            }
            //��pivot���ұ�һֱ��,�ҵ�С�ڵ���pivotֵ,���˳�
            while (arr[r] > pivot) {
                r -= 1;
            }
            //���l >= r˵��pivot ����������ֵ���Ѿ��������ȫ����
            //С�ڵ���pivotֵ���ұ�ȫ���Ǵ��ڵ���pivotֵ
            if (l >= r) {
                break;
            }

            //����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //���������󣬷������arr[l] == pivotֵ ��� r--�� ǰ��
            if (arr[l] == pivot) {
                r -= 1;
            }
            //���������󣬷������arr[r] == pivotֵ ��� l++�� ����
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // ��� l == r, ����l++, r--, ����Ϊ����ջ���
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //����ݹ�
        if (left < r) {
            quickSort(arr, left, r);
        }
        //���ҵݹ�
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}