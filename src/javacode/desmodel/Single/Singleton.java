package javacode.desmodel.Single;

/**
 * 饿汉模式
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        if (s1 == s2) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }

    }
}
