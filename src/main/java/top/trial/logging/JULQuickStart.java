package top.trial.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JUL日志快速入门
 *
 * @Author gaoyx1469
 * @Date 2020/8/31
 * @Version 1.0
 */
public class JULQuickStart {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("top.trial.logging.JULQuickStart");//获取日志记录器

        logger.info("第一种INFO级别日志输出方式");

        logger.log(Level.INFO, "第二种INFO级别日志输出方式");

        int num = 666;
        String str = "日志记录str";

        logger.log(Level.INFO, "带参日志：{0}&{1}", new Object[]{num, str});
    }
}
