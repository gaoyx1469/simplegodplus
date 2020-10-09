package top.trial.spring.jdbcTemplate;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import top.trial.spring.aop.entity.AccountEntity;

/**
 * JdbcTemplate使用Demo，主要涉及update、query以及queryForObject方法，以及BeanPropertyRowMapper类
 * 若实体类的set方法与表的列名不一致，可以自己写实现类实现RowMapper接口，重写方法自己封装
 *
 * @author Gaoyx
 */
public class JdbcTemplateCRUDDemo {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("top/trial/spring/bean_jdbcTemplate.xml");

        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // jt.execute("insert into sg_account_test (SAT_ID,SAT_NAME,SAT_VALUE) values
        // (6,'JdbcTemplateIoC',5000.00)");

        // 增
        create(jt);

        // 查
        queryPlus(jt);
        System.out.println("===================");

        // 改
        update(jt);

        // 查全部
        queryAllPlus(jt);
        count(jt);
        System.out.println("===================");

        // 删
        delete(jt);

        // 查全部
        queryAllPlus(jt);
    }

    private static void create(JdbcTemplate jt) {
        jt.update("insert into SG_ACCOUNT_TEST (SAT_ID,SAT_NAME,SAT_VALUE) values (?,?,?)", 8, "JdbcTemplateIoC",
                new BigDecimal("10000"));
    }

    private static void update(JdbcTemplate jt) {
        jt.update("update SG_ACCOUNT_TEST set SAT_VALUE = ? where SAT_ID = ?", new BigDecimal("8000"), 8);

    }

    private static void delete(JdbcTemplate jt) {
        jt.update("delete from SG_ACCOUNT_TEST where SAT_ID = ?", 8);

    }

    /**
     * BeanPropertyRowMapper<AccountEntity>(AccountEntity.class)
     * 自动封装，要求AccountEntity内的settings方法与数据库的列名保持一致
     *
     * @param jt JdbcTemplate
     */
    private static void query(JdbcTemplate jt) {
        List<AccountEntity> aes = jt.query("select * from SG_ACCOUNT_TEST where SAT_ID = ?",
                new BeanPropertyRowMapper<>(AccountEntity.class), 8);
        if (!aes.isEmpty()) {
            System.out.println(aes.get(0));
        }
    }

    /**
     * 使用RowMapper的匿名内部类方式自己手动封装
     *
     * @param jt JdbcTemplate
     */
    private static void queryPlus(JdbcTemplate jt) {
        List<AccountEntity> aes = jt.query("select * from SG_ACCOUNT_TEST where SAT_ID = ?",
                new RowMapper<AccountEntity>() {
                    @Override
                    public AccountEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                        AccountEntity accountEntity = new AccountEntity();
                        accountEntity.setAccountId(resultSet.getInt("SAT_ID"));
                        accountEntity.setAccountName(resultSet.getString("SAT_NAME"));
                        accountEntity.setAccountMoney(resultSet.getBigDecimal("SAT_VALUE"));
                        return accountEntity;
                    }
                }, 8);
        if (!aes.isEmpty()) {
            System.out.println(aes.get(0));
        }
    }

    /**
     * BeanPropertyRowMapper<AccountEntity>(AccountEntity.class)
     * 自动封装，要求AccountEntity内的settings方法与数据库的列名保持一致
     *
     * @param jt JdbcTemplate
     */
    private static void queryAll(JdbcTemplate jt) {
        List<AccountEntity> aes = jt.query("select * from SG_ACCOUNT_TEST",
                new BeanPropertyRowMapper<>(AccountEntity.class));
        for (AccountEntity ae : aes) {
            System.out.println(ae);
        }
    }

    /**
     * 使用RowMapper的匿名内部类方式自己手动封装
     *
     * @param jt JdbcTemplate
     */
    private static void queryAllPlus(JdbcTemplate jt) {
        List<AccountEntity> aes = jt.query("select * from SG_ACCOUNT_TEST",
                new RowMapper<AccountEntity>() {
                    @Override
                    public AccountEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                        AccountEntity accountEntity = new AccountEntity();
                        accountEntity.setAccountId(resultSet.getInt("SAT_ID"));
                        accountEntity.setAccountName(resultSet.getString("SAT_NAME"));
                        accountEntity.setAccountMoney(resultSet.getBigDecimal("SAT_VALUE"));
                        return accountEntity;
                    }
                });
        for (AccountEntity ae : aes) {
            System.out.println(ae);
        }
    }

    /**
     * 聚合函数返回单行单列数据，使用queryForObject方法
     *
     * @param jt JdbcTemplate
     */
    private static void count(JdbcTemplate jt) {
        System.out.println(jt.queryForObject("select count(*) from sg_account_test", Integer.class));

    }
}
