package cn.javass.c9.collection;

public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1=new Person();
		p1.setId("1");
		p1.setName("user1");
		p1.setAge(21);
		Person p2=new Person();
		p2.setId("2");
		p2.setName("user2");
		p2.setAge(22);
		Person p3=new Person();
		p3.setId("3");
		p3.setName("user3");
		p3.setAge(23);
		
		MyList list=new MyList();
		list.push(p1);
		list.push(p2);
		list.push(p3);
		
		list.iterator();
		System.out.println("======");
		list.pop();
		list.iterator();
		System.out.println("======");
		list.pop();
		list.iterator();
		System.out.println("======");
		list.pop();
		list.iterator();

	}

}