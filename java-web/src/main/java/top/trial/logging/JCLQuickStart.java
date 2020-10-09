package top.trial.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JCL日志门面快速入门
 *
 * @Author gaoyx1469
 * @Date 2020/9/2
 * @Version 1.0
 */
public class JCLQuickStart {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(JCLQuickStart.class);
        log.info("JCL 输出");
    }
}
