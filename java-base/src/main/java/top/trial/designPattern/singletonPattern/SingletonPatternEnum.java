package top.trial.designPattern.singletonPattern;

/**
 * 枚举方式的单例模式
 *
 * @Author gaoyx1469
 * @Date 2020/10/13
 * @Version 1.0
 */
public enum SingletonPatternEnum {
    SINGLETON_PATTERN_ENUM;

    SingletonPatternEnum(){
        System.out.println("SingletonPatternEnum初始化");
    }
    public void theMethod() {
        System.out.println("SINGLETON_PATTERN_ENUM---theMethod");
    }
}
