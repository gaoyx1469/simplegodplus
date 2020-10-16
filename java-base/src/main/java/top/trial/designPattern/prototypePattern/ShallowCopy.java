package top.trial.designPattern.prototypePattern;

/**
 * 浅拷贝示例代码，实现Cloneable接口
 *
 * @Author gaoyx1469
 * @Date 2020/10/16
 * @Version 1.0
 */
public class ShallowCopy implements Cloneable {

    public ShallowCopy() {
        System.out.println("调用ShallowCopy无参构造");
    }

    public ShallowCopy(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("调用ShallowCopy带参构造");
    }

    private int id;
    private String name;
    private ShallowCopy copy;

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

    public ShallowCopy getCopy() {
        return copy;
    }

    public void setCopy(ShallowCopy copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "ShallowCopy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", copy=" + copy +
                '}';
    }

    /**
     * 使用Object自带的clone方法实现浅拷贝
     *
     * @return ShallowCopy
     * @throws CloneNotSupportedException 当没有继承Cloneable接口会抛出该异常
     */
    @Override
    protected ShallowCopy clone() throws CloneNotSupportedException {
        return (ShallowCopy) super.clone();
    }
}
