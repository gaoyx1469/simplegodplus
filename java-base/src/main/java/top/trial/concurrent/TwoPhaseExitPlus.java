package top.trial.concurrent;

/**
 * 两阶段退出demo代码演示，使用flag代替打断标记，使用volatile保证flag可见性【一个线程使用flag，主线程修改flag】
 *
 * @Author gaoyx1469
 * @Date 2020/8/31
 * @Version 1.0
 */
public class TwoPhaseExitPlus {

    public static void main(String[] args) throws InterruptedException {

        TwoPhaseTerminationPlus tpt = new TwoPhaseTerminationPlus();
        tpt.start();
        Thread.sleep(5500);
        tpt.stop();

    }
}

class TwoPhaseTerminationPlus {
    private Thread thread;

    private volatile boolean flag = false;

    //启动监控线程
    public void start() {
        thread = new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println("被打断了plus，料理后事");
                    break;
                }
                try {
                    Thread.sleep(2000);
                    System.out.println("执行正常监控程序ing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("睡眠中被打断plus");
                }
            }
        }, "thread");

        thread.start();
    }

    //停止通知线程
    public void stop() {
        flag = true;
        thread.interrupt();//打断睡眠，保证能立刻停止
    }
}
