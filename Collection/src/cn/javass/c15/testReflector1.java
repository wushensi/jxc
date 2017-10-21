package cn.javass.c15;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class testReflector1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testReflector1 reflector=new testReflector1();
		reflector.invokeMethod();
		reflector.getObject();
		reflector.getField();
	}
	
	public void invokeMethod(){
		try {
			Class class1=Class.forName("cn.javass.c14.testClass");
			//this.getConstructor(class1);
			Class[] objs=new Class[3];
			objs[0]=String.class;
			objs[1]=String.class;
			objs[2]=int.class;
			Constructor constructor=class1.getConstructor(objs);
			
			Object[] params=new Object[3];
			params[0]="hello world";
			params[1]="reflector";
			params[2]=7;
			Object object=constructor.newInstance(params);
			
			Method m1=class1.getMethod("getName");
			Method m2=class1.getMethod("getUser_id");
			Method m3=class1.getMethod("getAge");
			
			System.out.println(m1.invoke(object));
			System.out.println(m2.invoke(object));
			System.out.println(m3.invoke(object));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getObject(){
		Object object=null;
		try{
			Class class1=Class.forName("cn.javass.c14.testClass");
			//this.getConstructor(class1);
			Class[] objs=new Class[3];
			objs[0]=String.class;
			objs[1]=String.class;
			objs[2]=int.class;
			Constructor constructor=class1.getConstructor(objs);
			Object[] params=new Object[3];
			params[0]="hello world";
			params[1]="reflector";
			params[2]=7;
			object=constructor.newInstance(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Object ---> "+object);
		return object;
	}
	
	public void getField(){
		Object object=null;
		try{
			Class class1=Class.forName("cn.javass.c14.testClass");
			//this.getConstructor(class1);
			Class[] objs=new Class[3];
			objs[0]=String.class;
			objs[1]=String.class;
			objs[2]=int.class;
			Constructor constructor=class1.getConstructor(objs);
			Object[] params=new Object[3];
			params[0]="hello world";
			params[1]="reflector";
			params[2]=7;
			object=constructor.newInstance(params);
			
			Field field1=class1.getField("a");
			Field field2=class1.getField("b");
			Field field3=class1.getField("c");
			
			System.out.println(field1.get(object));
			System.out.println(field2.get(object));
			System.out.println(field3.get(object));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("Object ---> "+object);
		//return object;
	}
	
	public void getConstructor(Class class1){
		Constructor[] constructor=class1.getConstructors();
		for(Constructor c:constructor){
			System.out.println(c);
		}
	}

}
