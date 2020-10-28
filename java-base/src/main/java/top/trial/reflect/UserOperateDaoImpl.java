package top.trial.reflect;

public class UserOperateDaoImpl implements UserOperateDao {

	@Override
	public boolean addUser() {
		System.out.println("UserOperateDaoImpl:	调用addUser()成功");
		return true;
	}

	@Override
	public boolean deleteUser() {
		System.out.println("UserOperateDaoImpl:	调用deleteUser()成功");
		return true;
	}

	@Override
	public UserDomain getUser() {
		UserDomain ud = new UserDomain();
		ud.setUserId(1);
		ud.setUsername("演示用户一");
		System.out.println("UserOperateDaoImpl:	调用getUser()成功");
		return ud;
	}

}
