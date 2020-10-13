package top.trial.designPattern.singletonPattern;

/**
 * 单例模式饿汉式，double check方式使用锁和volatile
 *
 * @Author gaoyx1469
 * @Date 2020/10/13
 * @Version 1.0
 */
public class SingletonPatternLazy {

    private SingletonPatternLazy() {
    }

    private static volatile SingletonPatternLazy singletonPatternLazy;

    public static SingletonPatternLazy getInstance() {
        if (singletonPatternLazy == null) {
            synchronized (SingletonPatternLazy.class) {
                if (singletonPatternLazy == null) {
                    singletonPatternLazy = new SingletonPatternLazy();
                }
            }
        }
        return singletonPatternLazy;
    }
}
