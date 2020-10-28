package top.trial.reflect;


/**
 * 此类作为一个Demo接口，为各个trial提供接口引用实例
 *
 * @author Gaoyx
 */
public interface UserOperateDao {

    boolean addUser();

    boolean deleteUser();

    UserDomain getUser();

}
