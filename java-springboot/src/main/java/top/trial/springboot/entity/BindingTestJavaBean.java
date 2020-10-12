package top.trial.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author gaoyx1469
 * @Date 2020/10/12
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "binding")
public class BindingTestJavaBean {
    private String bindingName;
    private Integer bindingValue;
    private Map<String, Object> bindingMap;
    private String[] bindingWords;
    private Date date;
    private List<Integer> bindList;

    public String getBindingName() {
        return bindingName;
    }

    public void setBindingName(String bindingName) {
        this.bindingName = bindingName;
    }

    public Integer getBindingValue() {
        return bindingValue;
    }

    public void setBindingValue(Integer bindingValue) {
        this.bindingValue = bindingValue;
    }

    public Map<String, Object> getBindingMap() {
        return bindingMap;
    }

    public void setBindingMap(Map<String, Object> bindingMap) {
        this.bindingMap = bindingMap;
    }

    public String[] getBindingWords() {
        return bindingWords;
    }

    public void setBindingWords(String[] bindingWords) {
        this.bindingWords = bindingWords;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Integer> getBindList() {
        return bindList;
    }

    public void setBindList(List<Integer> bindList) {
        this.bindList = bindList;
    }

    @Override
    public String toString() {
        return "BindingTestJavaBean{" +
                "bindingName='" + bindingName + '\'' +
                ", bindingValue=" + bindingValue +
                ", bindingMap=" + bindingMap +
                ", bindingWords=" + Arrays.toString(bindingWords) +
                ", date=" + date +
                ", bindList=" + bindList +
                '}';
    }
}
