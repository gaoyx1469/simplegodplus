package top.trial.designPattern.factoryMethod;

/**
 * 工厂方法模式实体类基类
 *
 * @Author gaoyx1469
 * @Date 2020/10/15
 * @Version 1.0
 */
public abstract class FactoryMethodBaseEntity {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void getRealName();
}
