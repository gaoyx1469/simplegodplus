package top.trial.spring.aop.dao;

import top.trial.spring.aop.entity.AccountEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public interface AccountOperationDao {

    /**
     * 查询所有账户信息
     *
     * @return List<AccountEntity>
     */
    List<AccountEntity> getAllAccounts() throws SQLException;

    /**
     * 查询所有账户信息
     *
     * @param conn 数据库连接
     * @return List<AccountEntity>
     */
    List<AccountEntity> getAllAccounts(Connection conn) throws SQLException;

    /**
     * 根据id查询账户信息
     *
     * @param id 账户id
     * @return AccountEntity
     */
    AccountEntity getAccountById(int id) throws SQLException;

    /**
     * 根据id查询账户信息
     *
     * @param conn 数据库连接
     * @param id   账户id
     * @return AccountEntity
     */
    AccountEntity getAccountById(Connection conn, int id) throws SQLException;

    /**
     * 添加账户
     *
     * @param accountEntity 账户信息
     */
    void addAccount(AccountEntity accountEntity) throws SQLException;

    /**
     * 添加账户
     *
     * @param conn          数据库连接
     * @param accountEntity 账户信息
     */
    void addAccount(Connection conn, AccountEntity accountEntity) throws SQLException;

    /**
     * 更新账户信息
     *
     * @param accountEntity 账户信息
     */
    void updateAccount(AccountEntity accountEntity) throws SQLException;

    /**
     * 更新账户信息
     *
     * @param conn          数据库连接
     * @param accountEntity 账户信息
     */
    void updateAccount(Connection conn, AccountEntity accountEntity) throws SQLException;

    /**
     * 删除账户
     *
     * @param id 账户id
     */
    void deleteAccount(int id) throws SQLException;

    /**
     * 删除账户
     *
     * @param conn 数据库连接
     * @param id   账户id
     */
    void deleteAccount(Connection conn, int id) throws SQLException;

}
