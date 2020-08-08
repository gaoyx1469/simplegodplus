package top.trial.thread.basethread;


public class WaitAndNotifyImpl implements Runnable {

	private final WorkerDomain wd;

	public WaitAndNotifyImpl(WorkerDomain wd) {
		this.wd = wd;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (wd) {
				if (!wd.isFlag()) {
					try {
						// System.out.println("implwait2");
						wd.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// System.out.println("implnotify2");
				wd.notify();
				wd.setFlag(false);
				System.out.println(wd.toString());
			}
		}

	}

}
