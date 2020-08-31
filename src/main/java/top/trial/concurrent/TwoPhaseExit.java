package top.trial.concurrent;

/**
 * 两阶段退出demo代码演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/31
 * @Version 1.0
 */
public class TwoPhaseExit {

    public static void main(String[] args) throws InterruptedException {

        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        Thread.sleep(5500);
        tpt.stop();

    }
}

class TwoPhaseTermination {
    private Thread thread;

    //启动监控线程
    public void start() {
        thread = new Thread(() -> {
            while (true) {
                Thread curr = Thread.currentThread();
                if (curr.isInterrupted()) {
                    System.out.println("被打断了，料理后事");
                    break;
                }
                try {
                    Thread.sleep(2000);
                    System.out.println("执行正常监控程序ing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("睡眠中被打断");
                    curr.interrupt();//将打断标记置为真
                }
            }
        }, "thread");

        thread.start();
    }

    //停止通知线程
    public void stop() {
        thread.interrupt();
    }
}
