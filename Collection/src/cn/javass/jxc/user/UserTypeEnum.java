package cn.javass.jxc.user;

/**
 * 1 它可以像类一样可以有自己的属性和方法
 * 2 他的对象只能是在所有的语法单元出现之前定义，且为public static final的属性
 * 3 values方法要注意
 * @author wushensi
 *
 */
public enum UserTypeEnum {
	ADMIN(1,"超级管理员"),BOOK(2,"图书管理员"),IN(3,"进货管理员"),OUT(4,"出货管理员"),STOCK(5,"库存管理员"),USER(6,"普通用户"),;
	
	private final int type;
	private final String name;
	private UserTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	
	public static String getUserType(int type){
		for(UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getType()==type){
				return userType.getName();
			}
		}
		return "输入参数不存在";
	}
	
	public static int getUserName(String name){
		for(UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getName().equals(name)){
				return userType.getType();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		//System.out.println(UserTypeEnum.getUserType(8));
		System.out.println(UserTypeEnum.getUserName("进货管理员"));
	}
	
}
