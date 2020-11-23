package leetcode.nonam;
import java.util.NoSuchElementException;
import java.util.Random;

public class BinaryHeap<T extends Comparable<? super T>> {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        arr = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        arr = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (T item : items) {
            arr[i++] = item;
        }
        buildHeap();
    }

    /**
     * ����ѵĲ��뷽����ʹ�����˷���
     *
     * @param t �������Ԫ��
     */
    public void insert(T t) {
        if (currentSize == arr.length - 1) {
            // �����ǰԪ�ظ���Ϊ���鳤��-1��������
            enlargeArray(arr.length * 2 + 1);
        }
        int hole = ++currentSize;
        // arr[0] = t��ʼ����������ѭ�������㣬t.compartTo(arr[hole / 2])��arr[0]Ϊ0��ѭ������
        for (arr[0] = t; t.compareTo(arr[hole / 2]) < 0; hole /= 2) {
            // ���ڵ��ֵ��ֵ���ӽڵ�
            arr[hole] = arr[hole / 2];
        }
        // ���ڵ�(����Ҷ�ڵ�)��ֵΪt
        arr[hole] = t;
    }

    /**
     * Ѱ�Ҷ�����Сֵ������1����Ԫ����С��
     *
     * @return
     */
    public T findMin() {
        if (isEmpty()) {
            // ���������Ϊ�գ������׳��쳣��
            // throw new UnderflowException( );
        }
        // ��1λ��Ԫ����С
        return arr[1];
    }

    public T deleteMin() {
        if (isEmpty()) {
            // ���������Ϊ�գ������׳��쳣��
            // throw new UnderflowException( );
        }
        T minItem = findMin();
        // �����һ���ڵ㸳ֵ�����ڵ�
        arr[1] = arr[currentSize--];
        // �Ӹ��ڵ�ִ������
        percolateDown(1);
        return minItem;
    }

    /**
     * �ж϶��Ƿ�Ϊ��
     *
     * @return Ϊ�շ���true�����򷵻�false
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * ���ÿ�
     */
    public void makeEmpty() {
        currentSize = 0;
    }

    /**
     * ��ӡ��
     */
    public void print(){
        System.out.print("��Ϊ:");
        for (int i = 1;arr[i] != null;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private T[] arr;

    /**
     * ����
     *
     * @param hole ������ʵ�Ľڵ������
     */
    private void percolateDown(int hole) {
        int child;
        T tmp = arr[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && arr[child + 1].compareTo(arr[child]) < 0) {
                // ���ӽڵ㲻Ϊ���һ���ڵ㣨˵�����ҽڵ㣩���ҽڵ�����ڵ�С��������Ϊ�ҽڵ�ڵ�
                child++;
            }
            if (arr[child].compareTo(tmp) < 0) {
                // ���������������ڵ�����һ��Ԫ��С
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        // �����һ��Ԫ�ز���ǰ��Ŀ�λ
        arr[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * ����
     * @param newSize ������Ĵ�С
     */
    private void enlargeArray(int newSize) {
        T[] old = arr;
        arr = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            arr[i] = old[i];
        }
    }
}
