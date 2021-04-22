package javacode.Sort;

public class HeapSort {
    public static void BuildMaxHeap(int arr[], int n, int i){//n为完全二叉树个数，i为根节点位置
        printArray(arr);
        System.out.println("");
        int largest = i; // 初始化根
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // left > root
        if (l < n && arr[l] > arr[largest])
            largest = l; //largest表示此时最大值的位置

        // right > root
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // 如果最大值不是根节点，调整
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // BuildMaxHeap层层找到最最大值
            BuildMaxHeap(arr, n, largest);
        }

    }
    //打印函数
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int arr[] = {7, 3, 8, 5, 1, 2};
        int n = arr.length;
        // 初始化堆 初始化后就可以得到 根节点为最大值
        for (int i = n / 2 - 1; i >= 0; i--){
            BuildMaxHeap(arr, n, i);
        }

        //依次把最大值沉下去 从右到左断开最后一个元素，重新构造大顶堆 也就是从小到大 排序
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            BuildMaxHeap(arr, i, 0);
        }
        // 打印结果
        System.out.println("结果：");
        printArray(arr);
    }
}
