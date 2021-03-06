package top.trial.spring.tx.service.impl;

import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.tx.dao.AccountOperationTxDao;
import top.trial.spring.tx.service.AccountOperationTxService;

import java.math.BigDecimal;

/**
 * @Author gaoyx1469
 * @Date 2020/7/18
 * @Version 1.0
 */
public class AccountOperationTxServiceXmlImpl implements AccountOperationTxService {

    AccountOperationTxDao dao;

    public void setDao(AccountOperationTxDao dao) {
        this.dao = dao;
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        AccountEntity fromAccount = dao.getAccountById(fromId);
        AccountEntity toAccount = dao.getAccountById(toId);
        if (fromAccount == null || toAccount == null) {
            throw new RuntimeException("客户不存在");
        }
        if (fromAccount.getAccountMoney().compareTo(amount) < 0)
            throw new IllegalArgumentException("金额不足");
        fromAccount.setAccountMoney(fromAccount.getAccountMoney().subtract(amount));
        toAccount.setAccountMoney(toAccount.getAccountMoney().add(amount));
        dao.updateAccount(fromAccount);
        //int i = 1 / 0;
        dao.updateAccount(toAccount);
    }
}
