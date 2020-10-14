package top.trial.designPattern.singletonPattern;

/**
 * 私有静态内部类的单例模式
 *
 * @Author gaoyx1469
 * @Date 2020/10/14
 * @Version 1.0
 */
public class SingletonPatternStaticInnerClass {

    private SingletonPatternStaticInnerClass() {
        System.out.println("SingletonPatternStaticInnerClass初始化");
    }

    private static class SingletonPatternStaticInnerClassProduct {
        private static final SingletonPatternStaticInnerClass instance = new SingletonPatternStaticInnerClass();
    }

    public static SingletonPatternStaticInnerClass getInstance() {
        return SingletonPatternStaticInnerClassProduct.instance;
    }

    public void theMethod() {
        System.out.println("SingletonPatternStaticInnerClass---theMethod");
    }

}
