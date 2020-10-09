package top.trial.spring.tx.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.trial.spring.aop.entity.AccountEntity;
import top.trial.spring.tx.dao.AccountOperationTxDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/18
 * @Version 1.0
 */
public class AccountOperationTxDaoXmlImpl extends JdbcDaoSupport implements AccountOperationTxDao {

    @Override
    public AccountEntity getAccountById(int id) {
        List<AccountEntity> accountEntities = getJdbcTemplate().query("select * from SG_ACCOUNT_TEST where SAT_ID = ?",
                new RowMapper<AccountEntity>() {
                    @Override
                    public AccountEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                        AccountEntity accountEntity = new AccountEntity();
                        accountEntity.setAccountId(resultSet.getInt("SAT_ID"));
                        accountEntity.setAccountName(resultSet.getString("SAT_NAME"));
                        accountEntity.setAccountMoney(resultSet.getBigDecimal("SAT_VALUE"));
                        return accountEntity;
                    }
                }, id);
        if (!accountEntities.isEmpty())
            return accountEntities.get(0);
        else
            return null;
    }

    @Override
    public void updateAccount(AccountEntity accountEntity) {
        getJdbcTemplate().update("UPDATE SG_ACCOUNT_TEST SET SAT_VALUE = ? WHERE SAT_ID = ?", accountEntity.getAccountMoney(), accountEntity.getAccountId());
    }
}
