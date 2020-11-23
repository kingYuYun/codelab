package yu.algorithm.dac;

public class Hanoitower1 {

	public static void main(String[] args) {
		hanoiTower(3, 'A', 'B', 'C');
	}
	
	//汉诺塔的移动的方法
	//使用分治算法
	
	public static void hanoiTower(int num, char a, char b, char c) {
		//如果只有一个盘
		if(num==1){
			System.out.println("第1个盘从 " + a + "->" + c);
		}else {
			hanoiTower(num-1,a,c,b);
			System.out.println("第 " +num + "个盘从 " +a+ "->" + c);
			hanoiTower(num-1,b,a,c);
		}
	}
}
