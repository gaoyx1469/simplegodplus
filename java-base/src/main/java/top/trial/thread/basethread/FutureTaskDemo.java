package top.trial.thread.basethread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试FutureTask
 *
 * @Author gaoyx1469
 * @Date 2020/8/25
 * @Version 1.0
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "-----" + "111");
            Thread.sleep(3000);
            return 200;
        });
        Thread t1 = new Thread(ft, "t1");
        t1.start();
        System.out.println(Thread.currentThread().getName() + "-----" + 100);
        System.out.println(ft.get());
    }
}
