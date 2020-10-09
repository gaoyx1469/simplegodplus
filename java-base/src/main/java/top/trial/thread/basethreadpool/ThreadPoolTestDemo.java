package top.trial.thread.basethreadpool;


import top.trial.thread.basethread.TicketRunnableImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTestDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //useThreadPool();
        useCallable();
    }

    /**
     * 线程池使用举例
     */
    private static void useThreadPool() {

        ExecutorService es = Executors.newFixedThreadPool(2);//给定一个2个线程的线程池

        TicketRunnableImpl tri = new TicketRunnableImpl();//给定未同步的卖票的方法

        es.submit(tri);//请求开启5个线程执行方法，实际只有两个线程得到运行，待到两个线程将票卖完之后交回线程池，则再继续从线程池中拿线程执行买票方法，只是票已卖完，进去后就退出
        es.submit(tri);
        es.submit(tri);
        es.submit(tri);
        es.execute(tri);


        es.shutdown();//在线程池中执行完全部execute或submit后关闭线程池
    }

    /**
     * Callable使用
     *
     * @throws ExecutionException   ExecutionException
     * @throws InterruptedException InterruptedException
     */
    private static void useCallable() throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(3);//给定一个3个线程的线程池

        SumCallableImpl sci1 = new SumCallableImpl(10);//Callable接口实现类，构造方法传入参数
        SumCallableImpl sci2 = new SumCallableImpl(100);
        SumCallableImpl sci3 = new SumCallableImpl(200);

        Future<Integer> f1 = es.submit(sci1);//执行Callable接口实现类的call()方法，返回值封装到Future中
        Future<Integer> f2 = es.submit(sci2);
        Future<Integer> f3 = es.submit(sci3);

        es.shutdown();

        System.out.println(f1.get() + "--------" + f2.get() + "---------" + f3.get());//使用Future的get()方法拿到计算结果，可以看到，线程池已经关闭，结果依然还在，不用担心丢失

    }

}
