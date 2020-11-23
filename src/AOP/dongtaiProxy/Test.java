package AOP.dongtaiProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Maotaijiu maotaijiu = new Maotaijiu();
        Wuliangye wuliangye = new Wuliangye();


        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiA(wuliangye);

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(Maotaijiu.class.getClassLoader(),
                Maotaijiu.class.getInterfaces(), jingxiao1);
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(Wuliangye.class.getClassLoader(),
                Wuliangye.class.getInterfaces(), jingxiao2);

        dynamicProxy.mainJiu();
        dynamicProxy2.mainJiu();
    }
}
