package top.trial.springmvc.entity;

import java.io.Serializable;

/**
 * @Author gaoyx1469
 * @Date 2020/7/22
 * @Version 1.0
 */
public class RequestParamsInnerBindingEntity implements Serializable {
    private int intVal;
    private String stringVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    @Override
    public String toString() {
        return "RequestParamsInnerBindingEntity{" +
                "intVal=" + intVal +
                ", stringVal='" + stringVal + '\'' +
                '}';
    }
}
