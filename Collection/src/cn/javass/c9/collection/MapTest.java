package cn.javass.c9.collection;
import java.util.*;
import java.util.Map.Entry;
public class MapTest implements Comparator{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest test=new MapTest();
		Map map=test.initMap();
		test.add(map);
		test.query(map);
		test.remove(map);
		System.out.println("------");
		//test.query(map);
		test.entryQuery(map);
		
	}
	public Map initMap(){
		Map map=new TreeMap();
		map.put("admin", "admin");
		return map;
	}
	public void add(Map map){
		map.put("1", "bkwa1");
		map.put("2", "bkwa2");
		map.put("3", "bkwa3");
		map.put("4", "bkwa4");
		map.put("5", "bkwa5");
	}
	public void remove(Map map){
		map.remove("admin");
	}
	public void query(Map map){
		Set set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			String key=(String)it.next();
			System.out.println("key="+key+"\t value="+map.get(key));
		}
	}
	
	public void entryQuery(Map map){
		Set set=map.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			Entry entry=(Entry)it.next();
			System.out.println("KEY="+entry.getKey()+"   VALUE="+entry.getValue());
		}
	}
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
