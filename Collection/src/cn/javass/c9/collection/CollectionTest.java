package cn.javass.c9.collection;

import java.util.*;

public class CollectionTest {
	public void updateCollection(Collection collection) {
		Object[] object = collection.toArray();
		UserModel um=null;
		for (int i = 0; i < object.length; i++) {
			if(object[i] instanceof UserModel){
				um=(UserModel)object[i];
				if(um.getUserId().equals("1")){
					um.setUserId("8");
					object[i]=um;
				}
			}
		}
		collection.clear();
		for(int i=0;i<object.length;i++){
			collection.add(object[i]);
		}
	}
	
	public void deleteCollection(Collection collection,int index){
		collection.remove(index);
	}
	@java.lang.SuppressWarnings(value={"uncheck"})
	public void setCollection(Collection collection,UserModel um,int index){
		ArrayList list=(ArrayList)collection;
		list.set(index, um);
	}

	public Collection initCollection() {
		Collection collection = new ArrayList();
		UserModel um1=new UserModel();
		um1.setUserId("1");
		um1.setName("user1");
		um1.setAge(12);
		UserModel um2=new UserModel();
		um2.setUserId("2");
		um2.setName("user1");
		um2.setAge(12);
		UserModel um3=new UserModel();
		um3.setUserId("3");
		um3.setName("user1");
		um3.setAge(12);
		// add
		/*collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(3);
		collection.add(3);
		collection.add(new Test());
		collection.add("abc");*/
		collection.add(um1);
		collection.add(um2);
		collection.add(um3);
		return collection;
	}

	public void iteratorCollection(Collection collection) {
		// iterator
		Iterator it = collection.iterator();
		Object o = null;
		while (it.hasNext()) {
			o = it.next();
			if (o instanceof Test) {
				Test t = (Test) o;
				System.out.println(t.getId() + "\t" + t.getName() + "\t"+ t.getAge());
			} else {
				System.out.println(o);
			}

		}
	}
	
	

	public static void main(String[] args) {
		CollectionTest ct = new CollectionTest();
		Collection collection=ct.initCollection();
		ct.iteratorCollection(collection);
		ct.updateCollection(collection);
		ct.iteratorCollection(collection);
		ct.deleteCollection(collection, 5);
		UserModel um=new UserModel();
		um.setUserId("1000");
		ct.setCollection(collection, um, 2);
		ct.iteratorCollection(collection);
		
		
	}
}

class Test {
	private String id = "1";
	private String name = "Test";
	private int age = 23;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
