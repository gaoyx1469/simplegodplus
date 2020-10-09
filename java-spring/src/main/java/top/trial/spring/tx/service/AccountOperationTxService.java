package top.trial.spring.tx.service;

import java.math.BigDecimal;

/**
 * 测试Spring事务控制SERVICE
 *
 * @Author gaoyx1469
 * @Date 2020/7/18
 * @Version 1.0
 */
public interface AccountOperationTxService {

    /**
     * 转账测试--Spring事务控制
     *
     * @param fromId 转出账户ID
     * @param toId   转入账户ID
     * @param amount 转账金额
     */
    void transfer(int fromId, int toId, BigDecimal amount);
}
