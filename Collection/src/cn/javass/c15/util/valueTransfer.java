package cn.javass.c15.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
/**
 * 
 * @author wushensi
 *
 */
public class valueTransfer {
	@java.lang.SuppressWarnings(value={"uncheck"})
	public static Object getModelObjectByMap(Map map,Class clz){
		Object object=null;
		try {
			//1、分解类并获得类的属性名称
			object=clz.newInstance();
			Field[] fields=clz.getDeclaredFields();
			String methodName="";
			for(Field field:fields){
				//2、通过属性名称，查询map中的对应key 并得到value
				Object obj=map.get(field.getName());
				methodName="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
				Class[] parameter=new Class[1];
				parameter[0]=field.getType();
				//3、分解得到类的方法名称并动态调用setter方法
				Method method=clz.getDeclaredMethod(methodName, parameter);
				method.invoke(object, obj);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		//4、返回更新后的object
		return object;
	}
}
