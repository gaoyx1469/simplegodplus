package top.trial.thread.designPattern;

/**
 * 同步模式--保护性暂停，初始版，参考join
 *
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class GuardedObject {

    private final int id;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //结果对象
    private Object response;

    //含超时时间的获取结果
    public synchronized Object get(long timeout) {
        long beginTime = System.currentTimeMillis();
        long currTimeout = timeout;
        while (response == null && currTimeout > 0) {
            try {
                this.wait(currTimeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currTimeout = timeout + beginTime - System.currentTimeMillis();
        }
        return response;

    }

    //获取结果
    public synchronized Object get() {
        while (response == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    //产生结果
    public synchronized void put(Object response) {
        this.response = response;
        this.notifyAll();
    }

}
