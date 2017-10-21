package cn.javass.c15;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class testAnnotation {
	public static void main(String[] args){
		try {
			Class clz=Class.forName("cn.javass.c15.UserModelB");
			boolean flag=clz.isAnnotationPresent(MyAnno.class);
			//System.out.println(clz.isAnnotation());
			//System.out.println("flag---"+flag);
			if(flag){
				MyAnno ma=(MyAnno)clz.getAnnotation(MyAnno.class);
				System.out.println(ma.schoolName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

