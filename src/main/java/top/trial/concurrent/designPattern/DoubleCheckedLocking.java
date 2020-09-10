package top.trial.concurrent.designPattern;

/**
 * 单例模式之double-checked locking
 *
 * @Author gaoyx1469
 * @Date 2020/9/10
 * @Version 1.0
 */
public class DoubleCheckedLocking {

    private static volatile DoubleCheckedLocking object = null;
    //关键点在volatile关键字，防止object = new DoubleCheckedLocking()语句创建对象和赋值这两个指令的重排

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        if (object == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (object == null) {
                    object = new DoubleCheckedLocking();
                }
            }
        }
        return object;
    }
}
