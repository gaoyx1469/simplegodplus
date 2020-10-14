package top.trial.designPattern.singletonPattern;

/**
 * 单例模式饿汉式，具体初始化时机是静态代码块初始化
 *
 * @Author gaoyx1469
 * @Date 2020/10/13
 * @Version 1.0
 */
public class SingletonPatternHungry {

    //private static final SingletonPatternHungry singletonPatternHungry = new SingletonPatternHungry();//静态常量模式
    private static final SingletonPatternHungry singletonPatternHungry;

    static {//静态代码块模式
        singletonPatternHungry = new SingletonPatternHungry();
    }

    private SingletonPatternHungry() {
        System.out.println("SingletonPatternHungry初始化");
    }

    public static SingletonPatternHungry getInstance() {
        return singletonPatternHungry;
    }

    public void theMethod() {
        System.out.println("SingletonPatternHungry---theMethod");
    }
}
