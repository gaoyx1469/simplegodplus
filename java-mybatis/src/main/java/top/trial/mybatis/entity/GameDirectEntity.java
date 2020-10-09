package top.trial.mybatis.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author gaoyx1469
 * @Date 2020/7/9
 * @Version 1.0
 */
public class GameDirectEntity implements Serializable {
    private String sgi_id;
    private String sgi_name;
    private String sgi_describe;

    public String getSgi_id() {
        return sgi_id;
    }

    public void setSgi_id(String sgi_id) {
        this.sgi_id = sgi_id;
    }

    public String getSgi_name() {
        return sgi_name;
    }

    public void setSgi_name(String sgi_name) {
        this.sgi_name = sgi_name;
    }

    public String getSgi_describe() {
        return sgi_describe;
    }

    public void setSgi_describe(String sgi_describe) {
        this.sgi_describe = sgi_describe;
    }

    @Override
    public String toString() {
        return "GameDirectEntity{" +
                "sgi_id='" + sgi_id + '\'' +
                ", sgi_name='" + sgi_name + '\'' +
                ", sgi_describe='" + sgi_describe + '\'' +
                '}';
    }
}
