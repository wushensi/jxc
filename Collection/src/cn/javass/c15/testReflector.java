package cn.javass.c15;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class testReflector{

	/**
	 * @param args
	 */
	private String name;
	private int age;
	private boolean sex;
	private long uuid;
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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public testReflector() {

	}

	public testReflector(String user_id,String username,int age) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testReflector reflector = new testReflector();
		reflector.myReflector();
	}
	
	public void exception(String name,int age,boolean sex,long uuid) throws Exception{
		
	}
	
	public void OutputStream(InputStream in,OutputStream out) throws IOException{
		
	}

	public void myReflector() {
		try {
			// Class c=Class.forName("java.util.Stack");
			// Class
			// c=Class.forName("cn.javass.c12.awt.panel.UpdatePanel");//第一种装载
			Class c = Class.forName("cn.javass.c14.testReflector");
			// Class c=int.class;//第二种装载
			// Class c=Integer.TYPE;//第三种装载
			System.out.println(c.isInstance(new testReflector()));
			Field[] f = c.getDeclaredFields();
			Method[] m = c.getDeclaredMethods();
			Class[] clss = c.getClasses();
			Constructor[] constr = c.getConstructors();
			for (Class cls : clss) {
				System.out.println("类--->" + cls);
			}
			for (Constructor c1 : constr) {
				System.out.println("构造函数--->" + c1);
			}
			for (Field field : f) {
				System.out.println("属性--->" + field);
			}
			System.out.println("----------------");
			for (Method method : m) {
				System.out.println("修饰符--->"
						+ Modifier.toString(method.getModifiers())
						+ "---返回值--->" + method.getReturnType() + "---名称--->"
						+ method.getName());
				Class[] parameterTypes = method.getParameterTypes();
				for (Class param : parameterTypes) {
					System.out.println("---参数类型--->" + param.getName());
				}
				Class[] exceptionTypes = method.getExceptionTypes();
				if (exceptionTypes.length != 0) {
					for (Class exception : exceptionTypes) {
						System.out.println("---异常类型--->" + exception.getName());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
