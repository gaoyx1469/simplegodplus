package top.trial.spring.aop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Spring AOP 测试实体类，关联数据库SG_ACCOUNT_TEST表
 *
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public class AccountEntity implements Serializable {

    private int accountId;
    private String accountName;
    private BigDecimal accountMoney;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountMoney=" + accountMoney +
                '}';
    }
}
