package top.trial.designPattern.factoryMethod;

/**
 * 工厂方法模式测试类
 * 可以看出，在使用时依然耦合了抽象工厂类及其子类
 *
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        MethodFactory factory = new MethodFactory1();
        factory.getEntity().getRealName();
        factory = new MethodFactory2();
        factory.getEntity().getRealName();
    }
}
