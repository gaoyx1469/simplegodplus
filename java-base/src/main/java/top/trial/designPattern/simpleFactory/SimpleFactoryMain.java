package top.trial.designPattern.simpleFactory;

/**
 * 简单工厂测试类
 * <p>
 * 使用简单工厂，实际上是将根据type创建不同子类的行为封装到工厂类中，因此在使用时，解除了使用方与子类的耦合。
 * 缺点是当增加子类时，简单工厂类同样需要修改，违反开闭原则，
 *
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public class SimpleFactoryMain {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        factory.getEntity("TYPE1").getRealName();
        factory.getEntity("TYPE2").getRealName();
    }
}
