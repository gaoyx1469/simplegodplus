package top.trial.designPattern.singletonPattern;

/**
 * 单例模式饿汉式，具体初始化时机是静态代码块初始化
 *
 * @Author gaoyx1469
 * @Date 2020/10/13
 * @Version 1.0
 */
public class SingletonPatternHungry {

    //private static SingletonPatternHungry singletonPatternHungry = new SingletonPatternHungry();
    private static final SingletonPatternHungry singletonPatternHungry;

    static {
        singletonPatternHungry = new SingletonPatternHungry();
    }

    private SingletonPatternHungry() {
    }

    public static SingletonPatternHungry getInstance() {
        return singletonPatternHungry;
    }
}
