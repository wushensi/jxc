package cn.javass.jxc.in.vo;

import java.io.Serializable;

/**
 * 关于值对象模式
 * 每一种事务对应一个Model类，描述这个事务的属性作为这个类型的字段
 * 1、private Filed对应它的get和set
 * 
 * 2、用主键写equals和hashcode，表示区分对象
 * 
 * 3、实现可序列化用于保存对象
 * 
 * 4、 保存一个默认构造方法 public 无参
 * 
 * 这个类的固有属性 uuid,sumNum,sumMoeny
 * 这个类和其它对象的联系 inId,bookId
 * @author wushensi
 *
 */
public class InDetail implements Serializable{
	/**
	 * 
	 */
	public InDetail(){
		
	}
	private static final long serialVersionUID = 1L;
	
	private String id,inId,bookId,mainId;
	public String getMainId() {
		return mainId;
	}
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	private int sumNum;
	private double sumMoney;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInId() {
		return inId;
	}
	public void setInId(String inId) {
		this.inId = inId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double d) {
		this.sumMoney = d;
	}
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
		InDetail other = (InDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InDetail [id=" + id + ", inId=" + inId + ", bookId=" + bookId
				+ ", mainId=" + mainId + ", sumNum=" + sumNum + ", sumMoney="
				+ sumMoney + "]";
	}
	
	
}
