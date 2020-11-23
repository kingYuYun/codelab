package yu.datastructures.sort.MaxHeap;

public class BuildMaxHeap {
    //堆排序的最坏、最好、平均时间复杂度均为O(nlogn)，是不稳定排序算法。
    public static void main(String[] args) {
        int[] a = {7, 3, 8, 5, 1, 2};
        int len = 6;    /* 数组长度 */
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
        /* Function: 构建大顶堆 */

            int i;
            int temp;

            for (i = len/2-1; i >= 0; i--)
            {
                if ((2*i+1) < len && heap[i] < heap[2*i+1])    /* 根节点小于左子树 */
                {
                    temp = heap[i];
                    heap[i] = heap[2*i+1];
                    heap[2*i+1] = temp;
                    /* 检查交换后的左子树是否满足大顶堆性质 如果不满足 则重新调整子树结构 */
                    if ((2*(2*i+1)+1 < len && heap[2*i+1] < heap[2*(2*i+1)+1]) || (2*(2*i+1)+2 < len && heap[2*i+1] < heap[2*(2*i+1)+2]))
                    {
                        MaxHeap(heap, len);
                    }
                }
                if ((2*i+2) < len && heap[i] < heap[2*i+2])    /* 根节点小于右子树 */
                {
                    temp = heap[i];
                    heap[i] = heap[2*i+2];
                    heap[2*i+2] = temp;
                    /* 检查交换后的右子树是否满足大顶堆性质 如果不满足 则重新调整子树结构 */
                    if ((2*(2*i+2)+1 < len && heap[2*i+2] < heap[2*(2*i+2)+1]) || (2*(2*i+2)+2 < len && heap[2*i+2] < heap[2*(2*i+2)+2]))
                    {
                        MaxHeap(heap, len);
                    }
                }
            }

    }
}
