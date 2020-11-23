package yu.Thread;


public class Singleton3 {

    /**
     * 双重校验锁实现对象单例（线程安全）
     */

    private volatile static Singleton3 uniqueInstance;

    private Singleton3() {
    }

    public static Singleton3 getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
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
        System.out.println("两个对象实例是否相同？");
        System.out.println(s1 == s2);
    }
}
