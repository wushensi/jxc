package cn.javass.c9.collection;
import java.util.*;
public class MyList {
	private List list=new ArrayList();
	private int index=0;
	private int i=0;
	private int j=0;
	
	public void push(Object obj){
		list.add(index, obj);
		index++;
	}
	
	public void pop(){
		if(index!=0){
			list.remove((list.size()-index));
			index--;
		}
	}
	
	public void iterator(){
		Iterator it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
