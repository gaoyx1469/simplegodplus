package top.trial.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.trial.spring.ioc.entity.SpringBean;

/**
 * Spring 快速入门演示
 *
 * @author gaoyx
 */
public class SpringQuickStartDemo {

    public static void main(String[] args) {
        // 读取spring主配置文件
        // ApplicationContext接口是BeanFactory的子子接口
        // ApplicationContext采用立即加载策略，在读取xml文件时就直接将对象创建出来，
        // 实现类使用ClassPathXmlApplicationContext【通过读取类路径下的文件创建spring容器】
        // FileSystemXmlApplicationContext【通过读取文件系统下的文件创建spring容器】
        // BeanFactory采用延迟加载策略，在使用时才将对象创建出来，实现类使用XmlBeanFactory
        System.out.println("容器初始化开始");
        System.out.println("----------------------");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("----------------------");
        System.out.println("容器初始化完毕");
        System.out.println("----------------------");
        // 上送对象类型可不用强转
        // SpringBean sb = (SpringBean)ac.getBean("what");
        SpringBean sb = ac.getBean("what", SpringBean.class);
        sb.service();
    }

}
