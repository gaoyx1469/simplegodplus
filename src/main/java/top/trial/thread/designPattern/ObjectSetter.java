package top.trial.thread.designPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class ObjectSetter implements Runnable {
    Logger logger = LoggerFactory.getLogger(ObjectSetter.class);

    private final int id;
    private final Object msg;

    public ObjectSetter(int id, Object msg) {
        this.id = id;
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GuardedObject guardedObject = ObjectBoxes.getGuardedObject(id);
        logger.info("setter start" + id);
        guardedObject.put(msg);
        logger.info("setter end" + id);
    }
}
