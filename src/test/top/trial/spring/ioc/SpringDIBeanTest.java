package top.trial.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入Bean的测试
 *
 * @author Gaoyx
 */
public class SpringDIBeanTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 全构造器注入
        SpringDIBean sdib = (SpringDIBean) ac.getBean("ditest");
        System.out.println(sdib.toString());
        // 构造器与set方法共同注入
        sdib = (SpringDIBean) ac.getBean("ditestnew");
        System.out.println(sdib.toString());
    }

}
