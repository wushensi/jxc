package cn.javass.jxc.in.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * @author wushensi
 *
 */
public class InMain implements Serializable{
	/**
	 * 
	 */
	public InMain(){
		
	}
	private static final long serialVersionUID = 1L;
	
	private String id,inUserId;
	private long inDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInUserId() {
		return inUserId;
	}
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}
	public long getInDate() {
		return inDate;
	}
	public void setInDate(long inDate) {
		this.inDate = inDate;
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
		InMain other = (InMain) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		Date date=new Date();
		date.setTime(inDate);
		return "InMain [id=" + id + ", inUserId=" + inUserId + ", inDate="
				+ sdf.format(date) + "]";
	}
	
	
}
