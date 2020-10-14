package top.trial.designPattern.singletonPattern;

/**
 * 单例模式测试类
 *
 * @Author gaoyx1469
 * @Date 2020/10/14
 * @Version 1.0
 */
public class SingletonPatternTest {
    public static void main(String[] args) {

        System.out.println("---==================---");

        SingletonPatternHungry hungry1 = SingletonPatternHungry.getInstance();
        SingletonPatternHungry hungry2 = SingletonPatternHungry.getInstance();
        System.out.println("hungry---" + (hungry1 == hungry2));
        hungry1.theMethod();

        System.out.println("---==================---");

        SingletonPatternLazy lazy1 = SingletonPatternLazy.getInstance();
        SingletonPatternLazy lazy2 = SingletonPatternLazy.getInstance();
        System.out.println("lazy---" + (lazy1 == lazy2));
        lazy1.theMethod();

        System.out.println("---==================---");

        SingletonPatternEnum enum1 = SingletonPatternEnum.SINGLETON_PATTERN_ENUM;
        SingletonPatternEnum enum2 = SingletonPatternEnum.SINGLETON_PATTERN_ENUM;
        System.out.println("enum---" + (enum1 == enum2));
        enum1.theMethod();

        System.out.println("---==================---");

        SingletonPatternStaticInnerClass sic1 = SingletonPatternStaticInnerClass.getInstance();
        SingletonPatternStaticInnerClass sic2 = SingletonPatternStaticInnerClass.getInstance();
        System.out.println("innerClass---" + (sic1 == sic2));
        sic1.theMethod();

    }
}
