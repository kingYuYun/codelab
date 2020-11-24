package javacode.datastructures.sort;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //
        arr=HeapSort(arr);

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]+" ");
        }
    }
    //����ȫ�ֱ��������ڼ�¼����array�ĳ��ȣ�
    static int len;
    /**
     * �������㷨
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.����һ������
        buildMaxHeap(array);
        //2.ѭ��������λ�����ֵ����ĩλ������Ȼ�������µ�������
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    private static void swap(int[] array, int i, int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
    }

    /**
     * ��������
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //�����һ����Ҷ�ӽڵ㿪ʼ���Ϲ�������
        for (int i = (len/2 - 1); i >= 0; i--) { //��л @���ҷ���� ���ѵ����ѣ��˴�Ӧ��Ϊ i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }
    /**
     * ����ʹ֮��Ϊ����
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //������������������������ڸ��ڵ㣬�����ָ��ָ��������
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //������������������������ڸ��ڵ㣬�����ָ��ָ��������
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //������ڵ㲻�����ֵ���򽫸��ڵ������ֵ���������ҵݹ�����븸�ڵ㽻����λ�á�
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
}
