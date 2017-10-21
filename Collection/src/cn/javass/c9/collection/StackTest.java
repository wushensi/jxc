package cn.javass.c9.collection;

public class StackTest {

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
		
		MyStack stack=new MyStack();
		stack.push(p1);
		stack.push(p2);
		stack.push(p3);
		
		stack.iterator();
		System.out.println("======");
		stack.pop1();
		stack.iterator();
		System.out.println("======");
		stack.pop1();
		stack.iterator();
		System.out.println("======");
		stack.pop1();
		stack.iterator();

	}

}

class Person{
	private String id;
	private String name;
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
	private int age;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
