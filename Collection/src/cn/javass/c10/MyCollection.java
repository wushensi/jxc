package cn.javass.c10;

import java.util.ArrayList;
import java.util.List;

public class MyCollection {
	private boolean flag;
	public boolean add(Object obj){
		List list = new ArrayList();
		list.add(obj);
		if(list!=null){
			return true;
		}else{
			return false;
		}
		
	}
}
