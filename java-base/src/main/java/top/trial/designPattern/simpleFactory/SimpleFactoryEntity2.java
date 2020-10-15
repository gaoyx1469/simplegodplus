package top.trial.designPattern.simpleFactory;

/**
 * 简单工厂实体类子类，实际生产中应该有多个类
 *
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public class SimpleFactoryEntity2 extends SimpleFactoryBaseEntity {

    @Override
    public void getRealName() {
        System.out.println("SimpleFactoryEntity2");
    }
}
