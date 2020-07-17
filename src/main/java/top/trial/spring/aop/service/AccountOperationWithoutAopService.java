package top.trial.spring.aop.service;

import top.trial.spring.aop.entity.AccountEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public interface AccountOperationWithoutAopService {

    /**
     * 根据id查询账户信息
     *
     * @return List<AccountEntity>
     */
    List<AccountEntity> getAllAccounts();

    /**
     * 根据id查询账户信息
     *
     * @param id 账户id
     * @return AccountEntity
     */
    AccountEntity getAccountById(int id);

    /**
     * 添加账户
     *
     * @param accountEntity 账户信息
     */
    void addAccount(AccountEntity accountEntity);

    /**
     * 更新账户信息
     *
     * @param accountEntity 账户信息
     */
    void updateAccount(AccountEntity accountEntity);

    /**
     * 删除账户
     *
     * @param id 账户id
     */
    void deleteAccount(int id);

    /**
     * 转账模拟操作
     *
     * @param fromId 转出方id
     * @param toId   转入方id
     * @param amount 转账金额
     */
    void transfer(int fromId, int toId, BigDecimal amount);

}
