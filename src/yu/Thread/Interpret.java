package yu.Thread;

public class Interpret {
    private int count=1;
    private  static int num=1;
    private static int c='A';

    public synchronized void printNum(){
        try{
            for (int i = 1; i < 10; i++) {
                while (count==0){
                    this.wait();
                }
                System.out.print(num++);
                if (i<6){
                    count--;
                }
                this.notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void printChar(){
        try {
            for (int i = 1; i <6; i++) {
                while(count==1){
                    this.wait();
                }
                System.out.print((char)c++);
                count=1;
                this.notifyAll();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Interpret obj=new Interpret();

        new Thread(()->obj.printNum(),"numb").start();
        new Thread(()-> obj.printChar(),"char").start();
    }

/**

    private static final Object lock = new Object();
    private static final char[] nums = "123456789".toCharArray();
    private static final char[] chars = "ABCDE".toCharArray();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (lock){
                for (char n : nums) {
                    System.out.print(n);
                    try {
                        lock.notify();//先唤醒另一个线程
                        lock.wait();//让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        }, "N").start();

        new Thread(()->{
            synchronized (lock) {
                for (char c : chars) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "C").start();
    }
 */
}
