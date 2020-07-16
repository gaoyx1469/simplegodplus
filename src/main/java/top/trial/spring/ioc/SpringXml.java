package top.trial.spring.ioc;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import top.util.jdbc.MysqlC3P0Util;

import javax.sql.DataSource;

/**
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
@ComponentScan("top.trial.spring")//扫描范围
public class SpringXml {

    @Bean
    public DataSource getDataSource() {
        return MysqlC3P0Util.getDataSource();
    }

    @Bean//没指定bean的name，则默认id是方法名
    //方法的参数是Autowired的，即按类型匹配，如果能匹配多个，在DataSource前加上@Qualifier指定id即可
    public QueryRunner getQueryRunner(DataSource ds) {
        return new QueryRunner(ds);
    }
}
