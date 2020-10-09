package top.trial.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author gaoyx1469
 * @Date 2020/9/22
 * @Version 1.0
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(2);
        System.out.println(pool.invoke(new MyTask(5)));
        System.out.println(pool.invoke(new MyTaskPlus(1, 100)));
    }
}
