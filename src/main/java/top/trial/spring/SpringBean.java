package top.trial.spring;

/**
 * Spring IoC 演示Bean
 *
 * @author gaoyx
 */
public class SpringBean {

    private String beanName;

    public SpringBean() {
        System.out.println("SpringBean 无参构造");
    }

    public SpringBean(String beanName) {
        this.beanName = beanName;
        System.out.println("SpringBean 带参构造");
    }

    public void service() {
        System.out.println("SpringBean service");
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}
