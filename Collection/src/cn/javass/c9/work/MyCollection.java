/*1：定义一个类，类里面有一个属性 col,类型是集合类型 Collection，实现下列方法：可以
向 col 里面添加数据、修改数据、查询数据、删除数据。也就是把这个 col 当作一个数据存
储的容器，对其实现数据的增删改查的方法。*/
package cn.javass.c9.work;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollection {
	private Object[] objs=new Object[0];
	public boolean add(Object object){
		for(Object obj:objs){
			if(object.equals(obj)){
				return false;
			}
			Object[] tempObjs=new Object[objs.length+1];
			System.arraycopy(objs, 0, tempObjs, 0, objs.length);
			tempObjs[objs.length]=object;
			objs=tempObjs;
		}
		return true;
	}
	
	public void edit(String id){
		MyCollection mycollection=new MyCollection();
	}
	
	public Object query(){
		return null;
	}
	
	public Collection getAll(){
		Collection col=null;
		for(int i=0;i<objs.length;i++){
			col.add(objs[i]);
		}
		return col;
	}
	
	public MyCollection remove(Object object){
		MyCollection mycollection=new MyCollection();
		for(int i=0;i<objs.length;i++){
			if(object.equals(objs[i])){
				continue;
			}{
				mycollection.add(objs[i]);
			}
		}
		return mycollection;
	}
	/*
	0 1 2 3 4 5
	0 1 2 3*/
	
}
