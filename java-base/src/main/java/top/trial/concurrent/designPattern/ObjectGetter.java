package top.trial.concurrent.designPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class ObjectGetter implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(ObjectGetter.class);

    @Override
    public void run() {
        GuardedObject guardedObject = ObjectBoxes.createGuardedObject();
        logger.info("getter start" + guardedObject.getId());
        Object obj = guardedObject.get(5000);
        logger.info("getter end" + guardedObject.getId() + obj);
    }
}
