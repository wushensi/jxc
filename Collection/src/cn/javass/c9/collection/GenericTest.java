package cn.javass.c9.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		//list.add("123");
		list.add(new Student());
		list.add(new Student());
		list.add(new Student());
		iteratorList(list);
		MyGen<Integer> MG=new MyGen<Integer>();
		MG.setV(new Integer(99));
		System.out.println(MG.getV());
	}
	
	public static void iteratorList(List list){
		Iterator it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}

class Student{
	private String stuId;
	private String stuName;
	private int stuAge;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAge="
				+ stuAge + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stuId == null) ? 0 : stuId.hashCode());
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
		Student other = (Student) obj;
		if (stuId == null) {
			if (other.stuId != null)
				return false;
		} else if (!stuId.equals(other.stuId))
			return false;
		return true;
	}
	
}

class MyGen<V>{
	V v;
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
}