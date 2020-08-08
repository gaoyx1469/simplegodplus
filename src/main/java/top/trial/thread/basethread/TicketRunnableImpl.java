package top.trial.thread.basethread;

/**
 * 卖票问题实现举例
 *
 * @author Gaoyx
 */
public class TicketRunnableImpl implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + ticketNum);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketNum--;
        }
    }
}
