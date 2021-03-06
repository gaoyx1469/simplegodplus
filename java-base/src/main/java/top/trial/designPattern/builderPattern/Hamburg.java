package top.trial.designPattern.builderPattern;

/**
 * 汉堡抽象类，实现食品接口，定下打包方式
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public abstract class Hamburg implements Meal {
    @Override
    public Packing getPacking() {
        return new Wrapper();
    }
}
