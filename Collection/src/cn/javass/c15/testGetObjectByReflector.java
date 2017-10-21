package cn.javass.c15;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class testGetObjectByReflector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class c=Class.forName("cn.javass.c14.testUrl");
			
			Class ps[]=new Class[3];
			
			ps[0]=java.lang.String.class;
			ps[1]=java.lang.String.class;
			ps[2]=java.lang.String.class;
			
			Constructor con=c.getConstructor(ps);
			
			
			Object[] objects=new Object[3];
			objects[0]="a234501l345";
			objects[1]="user1";
			objects[2]="123123";
			
			Object obj=con.newInstance(objects);
			
			//目的意义是动态的创建对象
			
			Class mps[]=new Class[1];
			mps[0]=String.class;
			
			//Method m1=c.getMethod("run", mps);
			Method m1=c.getMethod("run");
			
			Object mos[]=new Object[1];
			mos[0]="hello";
			
			m1.invoke(obj);//调用obj对象的m1方法，参数是mos
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
