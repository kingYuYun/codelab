package javacode.desmodel;


public class Singleton3 {

    /**
     * ˫��У����ʵ�ֶ��������̰߳�ȫ��
     */

    private volatile static Singleton3 uniqueInstance;

    private Singleton3() {
    }

    public static Singleton3 getUniqueInstance() {
        //���ж϶����Ƿ��Ѿ�ʵ������û��ʵ�������Ž����������
        if (uniqueInstance == null) {
            //��������
            synchronized (Singleton3.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton3();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Singleton3 s1, s2;
        s1 = Singleton3.getUniqueInstance();
        s2 = Singleton3.getUniqueInstance();
        System.out.println("��������ʵ���Ƿ���ͬ��");
        System.out.println(s1 == s2);
    }
}
