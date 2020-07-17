package top.trial.spring.aop.service.impl;

import org.springframework.stereotype.Service;
import top.trial.spring.aop.dao.AccountOperationDao;
import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.aop.service.AccountOperationService;
import top.util.jdbc.TransactionUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * 手动调用事务控制版本实现类
 *
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@Service
public class AccountOperationWithoutAopServiceTransactionImpl implements AccountOperationService {

    @Resource(name = "accountOperationDao")
    AccountOperationDao dao;

    @Override
    public List<AccountEntity> getAllAccounts() {

        List<AccountEntity> accounts;
        try {
            TransactionUtil.startTransaction();
            accounts = dao.getAllAccounts(TransactionUtil.getConnection());
            TransactionUtil.commit();
        } catch (SQLException e) {
            TransactionUtil.rollback();
            throw new RuntimeException();
        } finally {
            TransactionUtil.release();
        }
        return accounts;
    }

    @Override
    public AccountEntity getAccountById(int id) {

        AccountEntity account;
        try {
            TransactionUtil.startTransaction();
            account = dao.getAccountById(TransactionUtil.getConnection(), id);
            TransactionUtil.commit();
        } catch (Exception e) {
            TransactionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.release();
        }
        return account;
    }

    @Override
    public void addAccount(AccountEntity accountEntity) {
        try {
            TransactionUtil.startTransaction();
            dao.addAccount(TransactionUtil.getConnection(), accountEntity);
            TransactionUtil.commit();
        } catch (Exception e) {
            TransactionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.release();
        }
    }

    @Override
    public void updateAccount(AccountEntity accountEntity) {
        try {
            TransactionUtil.startTransaction();
            dao.updateAccount(TransactionUtil.getConnection(), accountEntity);
            TransactionUtil.commit();
        } catch (Exception e) {
            TransactionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.release();
        }
    }

    @Override
    public void deleteAccount(int id) {
        try {
            TransactionUtil.startTransaction();
            dao.deleteAccount(TransactionUtil.getConnection(), id);
            TransactionUtil.commit();
        } catch (Exception e) {
            TransactionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.release();
        }
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        try {
            TransactionUtil.startTransaction();
            AccountEntity fromAccount = dao.getAccountById(TransactionUtil.getConnection(), fromId);
            AccountEntity toAccount = dao.getAccountById(TransactionUtil.getConnection(), toId);
            amountCheck(amount, fromAccount, toAccount);
            dao.updateAccount(TransactionUtil.getConnection(), fromAccount);
            int i = 1 / 0;
            dao.updateAccount(TransactionUtil.getConnection(), toAccount);
            TransactionUtil.commit();
        } catch (Exception e) {
            TransactionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.release();
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
