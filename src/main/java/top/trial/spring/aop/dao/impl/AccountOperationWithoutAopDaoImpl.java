package top.trial.spring.aop.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import top.trial.spring.aop.dao.AccountOperationWithoutAopDao;
import top.trial.spring.aop.entity.AccountEntity;

import java.sql.Connection;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public class AccountOperationWithoutAopDaoImpl implements AccountOperationWithoutAopDao {

    @Autowired
    QueryRunner qr;

    @Override
    public List<AccountEntity> getAllAccounts() {
        return null;
    }

    @Override
    public List<AccountEntity> getAllAccounts(Connection conn) {
        return null;
    }

    @Override
    public AccountEntity getAccountById(int id) {
        return null;
    }

    @Override
    public AccountEntity getAccountById(Connection conn, int id) {
        return null;
    }

    @Override
    public void addAccount(AccountEntity accountEntity) {

    }

    @Override
    public void addAccount(Connection conn, AccountEntity accountEntity) {

    }

    @Override
    public void updateAccount(AccountEntity accountEntity) {

    }

    @Override
    public void updateAccount(Connection conn, AccountEntity accountEntity) {

    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void deleteAccount(Connection conn, int id) {

    }
}
