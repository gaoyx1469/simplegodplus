package top.trial.designPattern.factoryMethod;

/**
 * 工厂方法实体类子类，实际生产中应该有多个类
 *
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public class FactoryMethodEntity2 extends FactoryMethodBaseEntity {

    @Override
    public void getRealName() {
        System.out.println("FactoryMethodEntity2");
    }
}
