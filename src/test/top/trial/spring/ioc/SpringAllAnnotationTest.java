package top.trial.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.trial.spring.SpringXml;
import top.trial.spring.service.AnnotationService;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public class SpringAllAnnotationTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringXml.class);
        AnnotationService as = ac.getBean("allAnnotationService", AnnotationService.class);
        as.getAllGames();
        as.getGameById(0);
        as.gameUpdate(null);
    }
}
