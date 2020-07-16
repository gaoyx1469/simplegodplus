package top.trial.spring.aop.service.impl;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.trial.spring.aop.dao.AccountOperationWithoutAopDao;
import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.aop.service.AccountOperationWithoutAopService;
import top.util.jdbc.TransactionUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@Service
public class AccountOperationWithoutAopServiceImpl implements AccountOperationWithoutAopService {

    @Autowired
    AccountOperationWithoutAopDao dao;

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
    public void transferWithoutTransaction(int fromId, int toId, BigDecimal amount) {
        try {
            AccountEntity fromAccount = dao.getAccountById(fromId);
            AccountEntity toAccount = dao.getAccountById(toId);
            amountCheck(fromId, amount, fromAccount, toAccount);
            dao.updateAccount(fromAccount);
            //int i = 1 / 0;
            dao.updateAccount(toAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void transferWithTransaction(int fromId, int toId, BigDecimal amount) {
        try {
            TransactionUtil.startTransaction();
            AccountEntity fromAccount = dao.getAccountById(TransactionUtil.getConnection(), fromId);
            AccountEntity toAccount = dao.getAccountById(TransactionUtil.getConnection(), toId);
            amountCheck(fromId, amount, fromAccount, toAccount);
            dao.updateAccount(TransactionUtil.getConnection(), fromAccount);
            //int i = 1 / 0;
            dao.updateAccount(TransactionUtil.getConnection(), toAccount);
            TransactionUtil.commit();
        } catch (Exception e) {
            TransactionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.release();
        }
    }

    private void amountCheck(int fromId, BigDecimal amount, AccountEntity fromAccount, AccountEntity toAccount) {
        if (fromAccount.getAccountMoney().compareTo(amount) < 0) {//balance < amount时返回-1，应报错
            throw new IllegalArgumentException(fromId + "账户余额不足");
        }
        BigDecimal fromAmount = fromAccount.getAccountMoney().subtract(amount);
        BigDecimal toAmount = toAccount.getAccountMoney().add(amount);
        fromAccount.setAccountMoney(fromAmount);
        toAccount.setAccountMoney(toAmount);
    }
}
