package top.trial.designPattern.simpleFactory;

/**
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public class SimpleFactory {
    SimpleFactoryBaseEntity getEntity(String type) {
        if ("TYPE1".equals(type))
            return new SimpleFactoryEntity1();
        else if ("TYPE2".equals(type))
            return new SimpleFactoryEntity2();
        else
            return null;
    }
}
