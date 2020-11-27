package javacode.desmodel.Single;

/**
 * ���߳��µĵ���-����ʽ���ж��߳�����
 * ����ʽ�����ж��߳�����
 * <p>
 * <p>
 * //����ʽ
 * <p>
 * class Single {
 * private static final Single s = new Single(); //final�޸ĵı�������Ҫ��ʾ��ʼ��
 * private Single() {}  //���캯��˽�л�������紴������
 * public static Single getInstance() { //��粻�ܴ�������,��ô��Ҫ�����ṩ�����ķ��ʷ�ʽ--��װ��˼��(����ʵ��ϸ��,�����ṩ�����ķ��ʷ�ʽ)
 * return s;
 * }
 * }
 * <p>
 * <p>
 * //����ʽ
 * class Single2 {
 * private static Single2 s = null;
 * private Single2() {}
 * public static Single2 getInstance() {
 * if (s == null) { //����˫���ж�Ϊ�˽��Ч������,ֻҪ��һ���̴߳���������,�����߳̾Ͳ���Ҫ�ж������������Ч��
 * synchronized(Single2.class) {
 * if (s == null) {
 * s = new Single2();
 * }
 * }
 * }
 * return s;
 * }
 * }
 */


public class SingleModel {

    private static SingleModel single = new SingleModel();

    public static SingleModel getInstance() {
        return SingleModel.single;
    }


}
