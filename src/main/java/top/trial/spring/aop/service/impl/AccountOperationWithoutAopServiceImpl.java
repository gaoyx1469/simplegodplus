package top.trial.spring.aop.service.impl;

import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.aop.service.AccountOperationWithoutAopService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public class AccountOperationWithoutAopServiceImpl implements AccountOperationWithoutAopService {


    @Override
    public List<AccountEntity> getAllAccounts() {
        return null;
    }

    @Override
    public AccountEntity getAccountById(int id) {
        return null;
    }

    @Override
    public void addAccount(AccountEntity accountEntity) {

    }

    @Override
    public void updateAccount(AccountEntity accountEntity) {

    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void transferWithoutTransaction(int fromId, int toId, BigDecimal amount) {

    }

    @Override
    public void transferWithTransaction(int fromId, int toId, BigDecimal amount) {

    }
}
