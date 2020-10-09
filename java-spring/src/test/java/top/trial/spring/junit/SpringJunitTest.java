package top.trial.spring.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.trial.spring.ioc.SpringXml;
import top.trial.spring.ioc.service.AnnotationService;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringXml.class)
//@ContextConfiguration(locations="classpath:bean.xml")
public class SpringJunitTest {

    @Autowired
    @Qualifier("allAnnotationService")
    AnnotationService as;

    @Test
    public void testAllAnnotationService() {
        as.getAllGames();
        as.getGameById(0);
        as.gameUpdate(null);
    }
}
