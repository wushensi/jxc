package cn.javass.c10.awt.panel;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list1=new ArrayList();
		List list2=new ArrayList();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		//System.out.println(list1.size());
		Object[] objs=list1.toArray();
		for(Object obj:objs){
			list2.add(obj);
		}
		
		System.out.println(list1);
		System.out.println(list2);
		list1.add("6");
		System.out.println(list1);
		System.out.println(list2);
	}

}
