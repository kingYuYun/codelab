package mutilthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Double> task = new FutureTask(new MyCallable());
        //创建一个线程，异步计算结果
        Thread thread = new Thread(task);
        thread.start();
        //主线程继续工作
        Thread.sleep(1000);
        System.out.println("主线程等待计算结果...");
        //当需要用到异步计算的结果时，阻塞获取这个结果
        Double d = task.get();
        System.out.println("计算结果是："+d);

        //用同一个 FutureTask 再起一个线程
        Thread thread2 = new Thread(task);
        thread2.start();
    }
}

class MyCallable implements Callable<Double> {

    @Override
    public Double call() {
        double d = 0;
        try {
            System.out.println("异步计算开始.......");
            d = Math.random()*10;
            d += 1000;
            Thread.sleep(2000);
            System.out.println("异步计算结束.......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return d;
    }
}
