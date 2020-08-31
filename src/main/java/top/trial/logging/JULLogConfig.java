package top.trial.logging;

import top.util.properties.PropertiesUtil;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * 测试使用配置文件
 *
 * @Author gaoyx1469
 * @Date 2020/8/31
 * @Version 1.0
 */
public class JULLogConfig {
    public static void main(String[] args) throws IOException {

        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(PropertiesUtil.getPropertiesInputStreamByClassloader("logging.properties"));

        Logger logger = Logger.getLogger("top.trial.myLog");

        logger.log(Level.INFO, "INFO");
        logger.log(Level.WARNING, "WARNING");
        logger.log(Level.CONFIG, "CONFIG");
        logger.log(Level.FINE, "FINE");
    }
}
