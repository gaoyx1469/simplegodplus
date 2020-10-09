package top.trial.logging;

import java.util.logging.Logger;

/**
 * logger对象进阶
 *
 * @Author gaoyx1469
 * @Date 2020/8/31
 * @Version 1.0
 */
public class JULLoggerMsg {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("top.trial.logging.JULLoggerMsg");
        Logger logger1 = Logger.getLogger("top.trial.logging");
        Logger logger2 = Logger.getLogger("top.trial");
        Logger logger3 = Logger.getLogger("top");

        System.out.println(logger.getParent() == logger1);//true
        System.out.println(logger1.getParent() == logger2);//true
        System.out.println(logger2.getParent() == logger3);//true

        System.out.println("logger:" + logger + "---" + logger.getName());//logger:java.util.logging.Logger@5b37e0d2---top.trial.logging.JUCLoggerMsg
        System.out.println("logger3:" + logger3 + "---" + logger3.getName());//logger3:java.util.logging.Logger@4459eb14---top
        System.out.println("logger3Parent:" + logger3.getParent() + "---" + logger3.getParent().getName());//logger3Parent:java.util.logging.LogManager$RootLogger@5a2e4553---
    }
}
