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
//注意观察两种方式，环绕通知和其它四个通知出现的顺序，以及后置通知和最终通知是否颠倒的情况【跟xml中标签配置顺序有关，详见bean_aop.xml中说明】
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
