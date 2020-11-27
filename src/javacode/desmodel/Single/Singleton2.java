package javacode.desmodel.Single;

/**
 *
 */
public class Singleton2 {
    private static class SingletonHandler {
        private final static Singleton2 instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return SingletonHandler.instance;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Singleton2 s1, s2;
        s1 = Singleton2.getInstance();
        s2 = Singleton2.getInstance();
        System.out.println("1");
        System.out.println(s1 == s2);

    }
}
