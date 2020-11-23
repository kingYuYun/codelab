package yu.Thread;

/**
多线程下的单例-懒汉式会有多线程问题
饿汉式不会有多线程问题


//饿汉式

class Single {
    private static final Single s = new Single(); //final修改的变量必须要显示初始化
    private Single() {}  //构造函数私有化不让外界创建对象
    public static Single getInstance() { //外界不能创建对象,那么需要对外提供公共的访问方式--封装的思想(隐藏实现细节,对外提供公共的访问方式)
        return s;
    }
}


//懒汉式
class Single2 {
    private static Single2 s = null;
    private Single2() {}
    public static Single2 getInstance() {
        if (s == null) { //加入双重判断为了解决效率问题,只要有一个线程创建完对象后,其他线程就不需要判断锁操作了提高效率
            synchronized(Single2.class) {
                if (s == null) {
                    s = new Single2();
                }
            }
        }
        return s;
    }
}
 */


public class SingleModel {

        private static SingleModel single = new SingleModel();

    public static SingleModel getInstance() {
        return SingleModel.single;
    }


}
