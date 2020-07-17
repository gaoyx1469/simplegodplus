package top.trial.spring.aop.service.impl;

import org.springframework.stereotype.Service;
import top.trial.spring.aop.dao.AccountOperationDao;
import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.aop.service.AccountOperationService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * 无事务版本实现类
 *
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@Service
public class AccountOperationWithoutAopServiceImpl implements AccountOperationService {

    @Resource(name = "AccountOperationWithoutAopDao")
    AccountOperationDao dao;

    @Override
    public List<AccountEntity> getAllAccounts() {
        try {
            return dao.getAllAccounts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AccountEntity getAccountById(int id) {
        try {
            return dao.getAccountById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addAccount(AccountEntity accountEntity) {
        try {
            dao.addAccount(accountEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(AccountEntity accountEntity) {
        try {
            dao.updateAccount(accountEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(int id) {
        try {
            dao.deleteAccount(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        try {
            AccountEntity fromAccount = dao.getAccountById(fromId);
            AccountEntity toAccount = dao.getAccountById(toId);
            amountCheck(amount, fromAccount, toAccount);
            dao.updateAccount(fromAccount);
            int i = 1 / 0;
            dao.updateAccount(toAccount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void amountCheck(BigDecimal amount, AccountEntity fromAccount, AccountEntity toAccount) {
        if (fromAccount.getAccountMoney().compareTo(amount) < 0) {//balance < amount时返回-1，应报错
            throw new IllegalArgumentException(fromAccount.getAccountId() + "账户余额不足");
        }
        BigDecimal fromAmount = fromAccount.getAccountMoney().subtract(amount);
        BigDecimal toAmount = toAccount.getAccountMoney().add(amount);
        fromAccount.setAccountMoney(fromAmount);
        toAccount.setAccountMoney(toAmount);
    }
}
