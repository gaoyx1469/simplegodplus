package top.trial.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j日志门面的快速入门，使用slf4j的简单实现
 *
 * @Author gaoyx1469
 * @Date 2020/9/2
 * @Version 1.0
 */
    public class Slf4jQuickStart {

    public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jQuickStart.class);

    public static void main(String[] args) {

        //五种日志级别，内置实现默认打印到info级别
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        //占位符
        LOGGER.info("info:{}---{}", 20, "字符串");


        //打印报错
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            //e.printStackTrace();
            LOGGER.error("有报错", e);
        }

    }
}
