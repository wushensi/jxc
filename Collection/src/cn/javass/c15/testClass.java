package cn.javass.c15;

public class testClass {

	/**
	 * @param args
	 */
	public String a="hello--->";
	public String b="world--->";
	public String c="---reflector";
	
	public testClass() {

	}

	public testClass(String user_id,String name,int age) {
		System.out.println("user_id--->"+user_id+"---name--->"+name+"---age---"+age);
		this.user_id=user_id;
		this.name=name;
		this.age=age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String string(String string) {
		return "";
	}

	public int integer(int integer) {
		return 0;
	}

	public void run() throws Exception {

	}

	private String name;

	private String user_id;

	private int age;

	public String getName() {
		System.out.println("---getName--->"+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		System.out.println("---getUser_id--->"+user_id);
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getAge() {
		System.out.println("---getAge--->"+age);
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
