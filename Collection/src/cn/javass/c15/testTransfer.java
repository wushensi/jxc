package cn.javass.c15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.javass.c15.util.valueTransfer;

public class testTransfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("uuid", "UserModelA_uuid");
		map.put("uname", "UserModelA_name");
		map.put("age", "UserModelA_age");
		map.put("id", "UserModelB_id");
		map.put("name", "UserModelB_name");
		map.put("password", "UserModelB_password");
		map.put("Hello_WorldA", "UserModelA_Hello_World");
		map.put("Hello_WorldB", "UserModelB_Hello_World");
		
		UserModelA a=(UserModelA) valueTransfer.getModelObjectByMap(map, UserModelA.class);
		
		UserModelB b=(UserModelB) valueTransfer.getModelObjectByMap(map, UserModelB.class);
		
		System.out.println(a);
		
		System.out.println(b);
		
		
	}

}
