package top.trial.concurrent.designPattern;

/**
 * 同步模式--保护性暂停，拓展解耦，实现多个线程的get和set
 *
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class GuardedObjectPlusTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 4; i++) {
            new Thread(new ObjectGetter(), "t" + i).start();
        }
        Thread.sleep(2000);
        for (int i : ObjectBoxes.getIds()) {//此处并发修改异常，因为启动Setter线程，导致Getter线程调了get方法，动了ObjectBoxes中的map，为了避免，可以让Setter线程先休眠一会再remove？
            new Thread(new ObjectSetter(i, "hehe" + i), "f" + i).start();
        }
    }
}
