package top.trial.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.aop.service.AccountOperationService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:top/trial/spring/springAnnotation.xml")
public class SpringAccountOperationWithoutAopTest {

    @Resource(name = "accountOperationWithoutAopServiceTransactionImpl")
    AccountOperationService serviceWithTransaction;

    @Resource(name = "accountOperationWithoutAopServiceImpl")
    AccountOperationService serviceWithoutTransaction;

    @Resource(name = "getProxy")
    AccountOperationService serviceWithProxy;

    @Test
    public void solution() {
        //AccountEntity accountEntity1 = serviceWithProxy.getAccountById(1);
        //AccountEntity accountEntity2 = serviceWithProxy.getAccountById(2);
        //accountEntity1.setAccountMoney(new BigDecimal("20000"));
        //accountEntity2.setAccountMoney(new BigDecimal("30000"));
        //serviceWithProxy.updateAccount(accountEntity1);
        //serviceWithProxy.updateAccount(accountEntity2);


        //事务没控制住
        //serviceWithoutTransaction.transfer(1, 2, new BigDecimal("100"));

        //事务控制住了
        //serviceWithTransaction.transfer(1, 2, new BigDecimal("200"));

        //事务同样控制住了，且service实现类比上个简洁，因为事务增强代码由动态代理实现，此处使用的事代理工厂生成service的代理对象
        serviceWithProxy.transfer(1, 2, new BigDecimal("300"));
    }
}
