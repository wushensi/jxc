package cn.javass.designPattern.creation.prototype;

import java.io.Serializable;

public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String uname;
	private int age;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "UserModel [uuid=" + uuid + ", uname=" + uname + ", age=" + age
				+ "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
}
