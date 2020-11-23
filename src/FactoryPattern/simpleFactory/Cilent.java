package FactoryPattern.simpleFactory;

public class Cilent {
    public static void main(String[] args) {
        //调用Factory的静态方法生成所要的类
        Factory.create("productA");
        Factory.create("ProductB");
    }
}
