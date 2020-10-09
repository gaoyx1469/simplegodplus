package top.trial.springmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author gaoyx1469
 * @Date 2020/7/22
 * @Version 1.0
 */
public class RequestParamsBindingEntity implements Serializable {

    private int intParam;
    private String stringParam;
    private BigDecimal bigDecimal;

    private RequestParamsInnerBindingEntity beanParam;
    private List<RequestParamsInnerBindingEntity> listParam;
    private Map<String, RequestParamsInnerBindingEntity> mapParam;

    public int getIntParam() {
        return intParam;
    }

    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }

    public String getStringParam() {
        return stringParam;
    }

    public void setStringParam(String stringParam) {
        this.stringParam = stringParam;
    }


    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public RequestParamsInnerBindingEntity getBeanParam() {
        return beanParam;
    }

    public void setBeanParam(RequestParamsInnerBindingEntity beanParam) {
        this.beanParam = beanParam;
    }

    public List<RequestParamsInnerBindingEntity> getListParam() {
        return listParam;
    }

    public void setListParam(List<RequestParamsInnerBindingEntity> listParam) {
        this.listParam = listParam;
    }

    public Map<String, RequestParamsInnerBindingEntity> getMapParam() {
        return mapParam;
    }

    public void setMapParam(Map<String, RequestParamsInnerBindingEntity> mapParam) {
        this.mapParam = mapParam;
    }

    @Override
    public String toString() {
        return "RequestParamsBindingEntity{" +
                "intParam=" + intParam +
                ", stringParam='" + stringParam + '\'' +
                ", bigDecimal=" + bigDecimal +
                ", beanParam=" + beanParam +
                ", listParam=" + listParam +
                ", mapParam=" + mapParam +
                '}';
    }
}
