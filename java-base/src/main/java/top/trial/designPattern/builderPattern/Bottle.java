package top.trial.designPattern.builderPattern;

/**
 * 打包方式实现类，采用瓶装形式打包
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class Bottle implements Packing {
    @Override
    public String packing() {
        System.out.println("执行瓶装打包流程");
        return "瓶装";
    }
}
