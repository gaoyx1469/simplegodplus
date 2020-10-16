package top.trial.designPattern.prototypePattern;

import java.io.*;

/**
 * 深拷贝示例代码，实现Cloneable接口
 *
 * @Author gaoyx1469
 * @Date 2020/10/16
 * @Version 1.0
 */
public class DeepCopy implements Cloneable, Serializable {

    public DeepCopy() {
        System.out.println("调用DeepCopy无参构造");
    }

    public DeepCopy(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("调用DeepCopy带参构造");
    }

    private int id;
    private String name;
    private DeepCopy copy;

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

    public DeepCopy getCopy() {
        return copy;
    }

    public void setCopy(DeepCopy copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "DeepCopy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", copy=" + copy +
                '}';
    }

    /**
     * 使用Object自带的clone方法实现深拷贝
     *
     * @return DeepCopy
     * @throws CloneNotSupportedException 当没有继承Cloneable接口会抛出该异常
     */
    @Override
    protected DeepCopy clone() throws CloneNotSupportedException {
        DeepCopy instance = (DeepCopy) super.clone();//浅拷贝结束
        if (instance.copy != null) {
            instance.copy = this.copy.clone();
        }
        return instance;
    }

    /**
     * 使用序列化反序列化的方式实现深拷贝
     *
     * @return DeepCopy
     */
    protected DeepCopy copy() {
        DeepCopy instance = null;
        ObjectInputStream ois = null;
        //ByteArrayOutputStream缓存流，将数据保存到内存中的字节数组中
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            //序列化
            oos.writeObject(this);

            //反序列化
            //ByteArrayInputStream从内存中的字节数组加载数据
            ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

            instance = (DeepCopy) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
