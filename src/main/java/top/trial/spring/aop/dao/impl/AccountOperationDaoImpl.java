package top.trial.spring.aop.dao.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.trial.spring.aop.dao.AccountOperationDao;
import top.trial.spring.aop.entity.AccountEntity;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@Repository("AccountOperationDao")
public class AccountOperationDaoImpl implements AccountOperationDao {

    @Resource(name = "queryRunner")
    QueryRunner qr;

    Map<String, String> resultMapper;

    {
        resultMapper = new HashMap<>();
        resultMapper.put("SAT_ID", "accountId");
        resultMapper.put("SAT_NAME", "accountName");
        resultMapper.put("SAT_VALUE", "accountMoney");
    }

    @Override
    public List<AccountEntity> getAllAccounts() throws SQLException {
        return qr.query("SELECT * FROM SG_ACCOUNT_TEST ", new BeanListHandler<>(AccountEntity.class, new BasicRowProcessor(new BeanProcessor(resultMapper))));
    }

    @Override
    public List<AccountEntity> getAllAccounts(Connection conn) throws SQLException {
        return qr.query(conn, "SELECT * FROM SG_ACCOUNT_TEST ", new BeanListHandler<>(AccountEntity.class, new BasicRowProcessor(new BeanProcessor(resultMapper))));
    }

    @Override
    public AccountEntity getAccountById(int id) throws SQLException {
        return qr.query("SELECT * FROM SG_ACCOUNT_TEST where SAT_ID = ?", new BeanHandler<>(AccountEntity.class, new BasicRowProcessor(new BeanProcessor(resultMapper))), id);
    }

    @Override
    public AccountEntity getAccountById(Connection conn, int id) throws SQLException {
        return qr.query("SELECT * FROM SG_ACCOUNT_TEST where SAT_ID = ?", new BeanHandler<>(AccountEntity.class, new BasicRowProcessor(new BeanProcessor(resultMapper))), id);
    }

    @Override
    public void addAccount(AccountEntity accountEntity) throws SQLException {
        qr.update("INSERT INTO SG_ACCOUNT_TEST (SAT_ID, SAT_NAME, SAT_VALUE) VALUES (?,?,?)", accountEntity.getAccountId(), accountEntity.getAccountName(), accountEntity.getAccountMoney());
    }

    @Override
    public void addAccount(Connection conn, AccountEntity accountEntity) throws SQLException {
        qr.update(conn, "INSERT INTO SG_ACCOUNT_TEST (SAT_ID, SAT_NAME, SAT_VALUE) VALUES (?,?,?)", accountEntity.getAccountId(), accountEntity.getAccountName(), accountEntity.getAccountMoney());
    }

    @Override
    public void updateAccount(AccountEntity accountEntity) throws SQLException {
        qr.update("UPDATE SG_ACCOUNT_TEST SET SAT_NAME=?, SAT_VALUE=? WHERE SAT_ID=?", accountEntity.getAccountName(), accountEntity.getAccountMoney(), accountEntity.getAccountId());
    }

    @Override
    public void updateAccount(Connection conn, AccountEntity accountEntity) throws SQLException {
        qr.update(conn, "UPDATE SG_ACCOUNT_TEST SET SAT_NAME=?, SAT_VALUE=? WHERE SAT_ID=?", accountEntity.getAccountName(), accountEntity.getAccountMoney(), accountEntity.getAccountId());
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        qr.update("DELETE FROM SG_ACCOUNT_TEST WHERE SAT_ID=?", id);
    }

    @Override
    public void deleteAccount(Connection conn, int id) throws SQLException {
        qr.update(conn, "DELETE FROM SG_ACCOUNT_TEST WHERE SAT_ID=?", id);
    }
}
