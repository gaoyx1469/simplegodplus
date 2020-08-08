package top.trial.thread.basethread;

/**
 * 卖票问题实现举例
 * 
 * @author Gaoyx
 *
 */
public class TicketSynchronizedRunnableImpl implements Runnable {

	private int ticketNum = 100;

	// 锁对象
	private final Object obj = new Object();

	@Override
	public void run() {

		// 加锁，也可以提取出一个方法，然后使用synchronized修饰
		// 也可以使用Lock接口的lock和unlock方法围绕
		synchronized (obj) {
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

}
