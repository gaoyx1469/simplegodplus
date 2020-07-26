package top.trial.springmvc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试自定义类型转换器处理无法自动转换的请求参数
 *
 * @Author gaoyx1469
 * @Date 2020/7/26
 * @Version 1.0
 */
public class RequestParamsConvertEntity implements Serializable {
    private String name;
    private int id;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "RequestParamsConvertEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }
}
