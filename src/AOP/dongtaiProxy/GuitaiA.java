package AOP.dongtaiProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GuitaiA implements InvocationHandler {
    private Object pingpai;


    public GuitaiA(Object pingpai) {
        this.pingpai = pingpai;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("���ۿ�ʼ  ��̨�ǣ� "+this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("���۽���");
        return null;
    }
}
