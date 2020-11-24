package javacode.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};

        //���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//		}

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        quickSort2(arr, 0, arr.length-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
        //System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort2(int[] arr,int low ,int hight){
        int i,j,temp,t;
        if (low>hight) return;
        i=low;
        j=hight;
        temp=arr[low];

        while (i<j){
            while (temp<=arr[j]&&i<j){
                j--;
            }
            while (temp>=arr[i]&&i<j){
                i++;
            }
            if (i<j){
                t=arr[j];
                arr[j]=arr[i];
                arr[i]=t;
            }
            arr[low]=arr[i];
            arr[i]=temp;
        }
        quickSort2(arr, low, j-1);
        quickSort2(arr, j+1, hight);
    }



}
