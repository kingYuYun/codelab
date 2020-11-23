package yu.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
		
		//测试快排的执行速度
		// 创建要给80000个的随机的数组
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}
		
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
		
		quickSort2(arr, 0, arr.length-1);
		for (int i = 0; i <arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		//System.out.println("arr=" + Arrays.toString(arr));
	}
	public static void quickSort2(int[] arr,int low,int high){
		int i,j,temp,t;
		if(low>high){
			return;
		}
		i=low;
		j=high;
		//temp就是基准位
		temp = arr[low];

		while (i<j) {
			//先看右边，依次往左递减
			while (temp<=arr[j]&&i<j) {
				j--;
			}
			//再看左边，依次往右递增
			while (temp>=arr[i]&&i<j) {
				i++;
			}
			//如果满足条件则交换
			if (i<j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}
		}
		//最后将基准为与i和j相等位置的数字交换
		arr[low] = arr[i];
		arr[i] = temp;
		//递归调用左半数组
		quickSort2(arr, low, j-1);
		//递归调用右半数组
		quickSort2(arr, j+1, high);
	}


	public static void quickSort(int[] arr,int left, int right) {
		int l = left; //左下标
		int r = right; //右下标
		//pivot 中轴值
		int pivot = arr[(left + right) / 2];
		int temp = 0; //临时变量，作为交换时使用
		//while循环的目的是让比pivot 值小放到左边
		//比pivot 值大放到右边
		while( l < r) { 
			//在pivot的左边一直找,找到大于等于pivot值,才退出
			while( arr[l] < pivot) {
				l += 1;
			}
			//在pivot的右边一直找,找到小于等于pivot值,才退出
			while(arr[r] > pivot) {
				r -= 1;
			}
			//如果l >= r说明pivot 的左右两的值，已经按照左边全部是
			//小于等于pivot值，右边全部是大于等于pivot值
			if( l >= r) {
				break;
			}
			
			//交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			//如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
			if(arr[l] == pivot) {
				r -= 1;
			}
			//如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
			if(arr[r] == pivot) {
				l += 1;
			}
		}
		
		// 如果 l == r, 必须l++, r--, 否则为出现栈溢出
		if (l == r) {
			l += 1;
			r -= 1;
		}
		//向左递归
		if(left < r) {
			quickSort(arr, left, r);
		}
		//向右递归
		if(right > l) {
			quickSort(arr, l, right);
		}
		
		
	}
}
