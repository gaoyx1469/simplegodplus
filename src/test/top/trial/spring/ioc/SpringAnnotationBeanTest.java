package top.trial.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.trial.spring.ioc.service.AnnotationService;

public class SpringAnnotationBeanTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("top/trial/spring/springAnnotation.xml");
        AnnotationService as = (AnnotationService) ac.getBean("annotationService");
        as.gameUpdate(null);
        as.getAllGames();
        as.getGameById(3);
    }
}
