package top.trial.concurrent.designPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.util.download.Downloader;

import java.io.IOException;

/**
 * 同步模式--保护性暂停，GuardedObject类测试
 *
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class GuardedObjectTest {
    private static final Logger logger = LoggerFactory.getLogger(GuardedObjectTest.class);

    public static void main(String[] args) throws InterruptedException {
        GuardedObject go = new GuardedObject(0);
        new Thread(() -> {
            logger.info("t1线程get前");
            logger.info("" + go.get(3000));
            logger.info("t1线程get后");
        }, "t1").start();

        Thread.sleep(2000);

        new Thread(() -> {
            logger.info("t2线程put前");
            try {
                go.put(Downloader.download("https://www.baidu.com/").size());
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("t2线程put后");
        }, "t2").start();
    }
}
