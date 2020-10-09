package top.trial.thread.basethread;


/**
 * 基本线程操作演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/8
 * @Version 1.0
 */
public class BaseThreadTestDemo {


    public static void main(String[] args) {

        saleTickets();//不加控制的卖票策略
        //saleTicketsSynchronized();//加上同步的卖票策略
        //dieLock();//测试死锁问题的出现
        //waitAndNotify();//测试等待唤醒机制，wait方法必须在同步代码中调用，可以释放锁
    }

    /**
     * 三窗口卖票，在不同步的情况下，会出现重复卖票等情况
     */
    private static void saleTickets() {
        TicketRunnableImpl ticket = new TicketRunnableImpl();

        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 三窗口卖票，在同步的情况下，重复卖票等情况不再出现
     */
    private static void saleTicketsSynchronized() {
        TicketSynchronizedRunnableImpl ticket = new TicketSynchronizedRunnableImpl();

        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 死锁问题举例,A锁代码中包含B锁代码，B锁代码中包含A锁
     */
    private static void dieLock() {

        DieLockRunnableImpl dieLockT = new DieLockRunnableImpl(true);
        DieLockRunnableImpl dieLockF = new DieLockRunnableImpl(false);

        Thread thread1 = new Thread(dieLockT, "线程1");
        Thread thread2 = new Thread(dieLockF, "线程2");

        thread1.start();
        thread2.start();
    }

    /**
     * 等待唤醒实例
     */
    private static void waitAndNotify() {

        WorkerDomain wd = new WorkerDomain();
        WorkerSetImpl wsi = new WorkerSetImpl(wd);
        WaitAndNotifyImpl wani = new WaitAndNotifyImpl(wd);

        Thread thread1 = new Thread(wsi, "线程1");
        Thread thread2 = new Thread(wani, "线程2");

        thread1.start();
        thread2.start();

    }
}
