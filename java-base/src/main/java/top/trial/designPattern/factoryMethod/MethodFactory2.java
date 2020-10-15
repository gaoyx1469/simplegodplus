package top.trial.designPattern.factoryMethod;

/**
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public class MethodFactory2 extends MethodFactory {
    @Override
    FactoryMethodBaseEntity getEntity() {
        return new FactoryMethodEntity2();
    }
}
