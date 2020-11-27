package javacode.desmodel.FactoryPattern.simpleFactory;

public class Cilent {
    public static void main(String[] args) {
        //����Factory�ľ�̬����������Ҫ����
        Factory.create("productA");
        Factory.create("ProductB");
    }
}
