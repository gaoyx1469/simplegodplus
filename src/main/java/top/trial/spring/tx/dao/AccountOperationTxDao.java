package top.trial.spring.tx.dao;

import top.trial.spring.aop.entity.AccountEntity;

/**
 * 测试Spring事务控制DAO
 *
 * @Author gaoyx1469
 * @Date 2020/7/18
 * @Version 1.0
 */
public interface AccountOperationTxDao {

    /**
     * 根据id查询账户信息
     *
     * @param id 账户id
     * @return AccountEntity
     */
    AccountEntity getAccountById(int id);

    /**
     * 更新账户信息
     *
     * @param accountEntity 账户信息
     */
    void updateAccount(AccountEntity accountEntity);
}
