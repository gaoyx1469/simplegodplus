package top.trial.spring.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import top.util.jdbc.MysqlC3P0Util;

public class JdbcTemplateDemo {

    public static void main(String[] args) {

        // JdbcTemplate使用演示
        JdbcTemplate jt = new JdbcTemplate(MysqlC3P0Util.getDataSource());

        //使用容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("top/trial/spring/bean_jdbcTemplate.xml");
        //JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        jt.execute("insert into SG_ACCOUNT_TEST (SAT_ID,SAT_NAME,SAT_VALUE) values (6,'JdbcTemplate',3000.00)");
    }

}
