package top.trial.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.aop.service.AccountOperationWithoutAopService;

import java.math.BigDecimal;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springAnnotation.xml")
public class SpringAccountOperationWithoutAopTest {

    @Autowired
    AccountOperationWithoutAopService service;

    @Test
    public void solution() {
        //System.out.println(service.getAccountById(1));
        //System.out.println(service.getAccountById(2));
        /*AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(3);
        accountEntity.setAccountName("小孙");
        accountEntity.setAccountMoney(new BigDecimal("3000"));
        service.addAccount(accountEntity);*/

        //事务没控制住
        service.transferWithoutTransaction(1, 2, new BigDecimal("100.01"));

        //事务控制住了
        //service.transferWithTransaction(2, 3, new BigDecimal("200.02"));


    }
}
