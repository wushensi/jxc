package cn.javass.c15;


@MyAnno(schoolName = "ABC")
public class UserModelA {
	private String uuid,uname,age;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserModelA [uuid=" + uuid + ", uname=" + uname + ", age=" + age
				+ "]";
	}

	
}
