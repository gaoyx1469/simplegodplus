package top.trial.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * log4j快速入门
 *
 * @Author gaoyx1469
 * @Date 2020/9/1
 * @Version 1.0
 */
public class Log4jQuickStart {
    public static void main(String[] args) {

        BasicConfigurator.configure();//不使用配置文件的情况下，初始化默认的配置信息，如果使用配置文件，此句可省略

        Logger logger = Logger.getLogger(Log4jQuickStart.class);//可使用全限定类名，也可以使用类的字节码对象

        logger.info("info");//输出INFO级别日志信息
    }
}
