package top.trial.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * log4j的日志级别
 *
 * @Author gaoyx1469
 * @Date 2020/9/1
 * @Version 1.0
 */
public class Log4jLogLevel {
    public static void main(String[] args) {
        BasicConfigurator.configure();//不使用配置文件的情况下，初始化默认的配置信息

        Logger logger = Logger.getLogger(Log4jLogLevel.class);//可使用全限定类名，也可以使用类的字节码对象

        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        logger.log(Level.OFF, "a");
    }
}
