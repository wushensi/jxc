package cn.javass.c15;

//@MyAnno(schoolName="UserModelB---Java Annotation Hello World")
public class UserModelB {
	private String id,name,password;

	@MyAnno(schoolName = "Method")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserModelB [id=" + id + ", name=" + name + ", password="
				+ password + "]";
	}

	
}
