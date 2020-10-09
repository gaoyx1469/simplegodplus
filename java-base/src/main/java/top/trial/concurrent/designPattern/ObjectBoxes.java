package top.trial.concurrent.designPattern;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 存储GuardedObject对象
 *
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class ObjectBoxes {
    private static final Map<Integer, GuardedObject> map = new Hashtable<>();

    private static int index = 1;

    private static synchronized int getIndex() {
        return index++;
    }

    /**
     * 生成一个GuardedObject对象，并存入map集合
     *
     * @return GuardedObject
     */
    public static GuardedObject createGuardedObject() {
        GuardedObject guardedObject = new GuardedObject(getIndex());
        map.put(guardedObject.getId(), guardedObject);
        return guardedObject;
    }

    /**
     * 获取所有map的id
     *
     * @return Set<Integer>
     */
    public static Set<Integer> getIds() {
        return map.keySet();
    }

    /**
     * 根据id获取GuardedObject且在map中删除
     *
     * @param id int
     * @return GuardedObject
     */
    public static GuardedObject getGuardedObject(int id) {
        return map.remove(id);
    }
}
