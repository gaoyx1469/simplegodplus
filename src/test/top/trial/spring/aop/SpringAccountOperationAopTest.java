package top.trial.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.trial.spring.aop.service.AccountOperationService;

import javax.annotation.Resource;

/**
 * @Author gaoyx1469
 * @Date 2020/7/17
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:top/trial/spring/bean_aop.xml")
@ContextConfiguration(locations = "classpath:top/trial/spring/bean_aop_annotation.xml")
public class SpringAccountOperationAopTest {

    @Resource(name = "accountOperationAopServiceImpl")
    AccountOperationService accountService;

    @Test
    public void solution() {
        System.out.println(accountService.getAccountById(1));
    }

}
