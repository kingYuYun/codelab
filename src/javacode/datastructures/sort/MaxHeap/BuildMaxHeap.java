package javacode.datastructures.sort.MaxHeap;

public class BuildMaxHeap {
    //������������á�ƽ��ʱ�临�ӶȾ�ΪO(nlogn)���ǲ��ȶ������㷨��
    public static void main(String[] args) {
        int[] a = {7, 3, 8, 5, 1, 2};
        int len = 6;    /* ���鳤�� */
        int i;

        for (i = len; i > 0; i--)
        {
            MaxHeap(a, i);
            Swap(a,i);
        }

        for (int j = 0; j < len; j++) {
            System.out.println(a[j]);
        }
    }


    public static void Swap(int[] heap,int len){
        int temp;

        temp = heap[0];
        heap[0] = heap[len-1];
        heap[len-1] = temp;
    }
    public static void MaxHeap(int[] heap, int len){
        /* Function: �����󶥶� */

            int i;
            int temp;

            for (i = len/2-1; i >= 0; i--)
            {
                if ((2*i+1) < len && heap[i] < heap[2*i+1])    /* ���ڵ�С�������� */
                {
                    temp = heap[i];
                    heap[i] = heap[2*i+1];
                    heap[2*i+1] = temp;
                    /* ��齻������������Ƿ�����󶥶����� ��������� �����µ��������ṹ */
                    if ((2*(2*i+1)+1 < len && heap[2*i+1] < heap[2*(2*i+1)+1]) || (2*(2*i+1)+2 < len && heap[2*i+1] < heap[2*(2*i+1)+2]))
                    {
                        MaxHeap(heap, len);
                    }
                }
                if ((2*i+2) < len && heap[i] < heap[2*i+2])    /* ���ڵ�С�������� */
                {
                    temp = heap[i];
                    heap[i] = heap[2*i+2];
                    heap[2*i+2] = temp;
                    /* ��齻������������Ƿ�����󶥶����� ��������� �����µ��������ṹ */
                    if ((2*(2*i+2)+1 < len && heap[2*i+2] < heap[2*(2*i+2)+1]) || (2*(2*i+2)+2 < len && heap[2*i+2] < heap[2*(2*i+2)+2]))
                    {
                        MaxHeap(heap, len);
                    }
                }
            }

    }
}
