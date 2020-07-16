package top.trial.spring.aop.dao;

import top.trial.spring.aop.entity.AccountEntity;

import java.sql.Connection;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public interface AccountOperationWithoutAopDao {

    /**
     * 根据id查询账户信息
     *
     * @return List<AccountEntity>
     */
    List<AccountEntity> getAllAccounts();

    /**
     * 根据id查询账户信息
     *
     * @param conn 数据库连接
     * @return List<AccountEntity>
     */
    List<AccountEntity> getAllAccounts(Connection conn);

    /**
     * 根据id查询账户信息
     *
     * @param id 账户id
     * @return AccountEntity
     */
    AccountEntity getAccountById(int id);

    /**
     * 根据id查询账户信息
     *
     * @param conn 数据库连接
     * @param id   账户id
     * @return AccountEntity
     */
    AccountEntity getAccountById(Connection conn, int id);

    /**
     * 添加账户
     *
     * @param accountEntity 账户信息
     */
    void addAccount(AccountEntity accountEntity);

    /**
     * 添加账户
     *
     * @param conn          数据库连接
     * @param accountEntity 账户信息
     */
    void addAccount(Connection conn, AccountEntity accountEntity);

    /**
     * 更新账户信息
     *
     * @param accountEntity 账户信息
     */
    void updateAccount(AccountEntity accountEntity);

    /**
     * 更新账户信息
     *
     * @param conn          数据库连接
     * @param accountEntity 账户信息
     */
    void updateAccount(Connection conn, AccountEntity accountEntity);

    /**
     * 删除账户
     *
     * @param id 账户id
     */
    void deleteAccount(int id);

    /**
     * 删除账户
     *
     * @param conn 数据库连接
     * @param id   账户id
     */
    void deleteAccount(Connection conn, int id);

}
