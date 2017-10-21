package cn.javass.c9.collection;
import java.util.*;
public class MyStack {
	private List list=new ArrayList();
	private int index=0;
	
	public void push(Object obj){
		list.add(index, obj);
		index++;
	}
	
	public Object pop(){
		index--;
		return list.get(index);
	}
	
	public void pop1(){
		index--;
		list.remove(index);
	}

	public void iterator(){
		Iterator it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
	
	
}
