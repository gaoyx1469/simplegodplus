package top.trial.spring.tx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.trial.spring.tx.service.AccountOperationTxService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author gaoyx1469
 * @Date 2020/7/18
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:top/trial/spring/spring_tx.xml")
public class SpringAccountOperationTxWithXmlTest {

    @Resource(name = "accountOperationTxService")
    AccountOperationTxService service;

    @Test
    public void solution() {
        service.transfer(1, 2, new BigDecimal("1000"));
    }
}
