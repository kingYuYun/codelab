package yu.Thread;

/**
 * 基于饿汉式单例
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
            System.out.println("两个对象是相同实例");
        } else {
            System.out.println("两个对象是不同实例");
        }

    }
}
