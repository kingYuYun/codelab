package javacode.algorithm.dac;

public class Hanoitower1 {

	public static void main(String[] args) {
		hanoiTower(3, 'A', 'B', 'C');
	}
	
	//��ŵ�����ƶ��ķ���
	//ʹ�÷����㷨
	
	public static void hanoiTower(int num, char a, char b, char c) {
		//���ֻ��һ����
		if(num==1){
			System.out.println("��1���̴� " + a + "->" + c);
		}else {
			hanoiTower(num-1,a,c,b);
			System.out.println("�� " +num + "���̴� " +a+ "->" + c);
			hanoiTower(num-1,b,a,c);
		}
	}
}
