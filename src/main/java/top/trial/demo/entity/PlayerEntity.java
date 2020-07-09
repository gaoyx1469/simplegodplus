package top.trial.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * 
 * @author Gaoyx
 *
 */
public class PlayerEntity implements Serializable {// TODO wait for using

	private String name;
	private int age;
	private Date birthday;
	private int level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "PlayerEntity [name=" + name + ", age=" + age + ", birthday=" + birthday + ", level=" + level + "]";
	}

}
