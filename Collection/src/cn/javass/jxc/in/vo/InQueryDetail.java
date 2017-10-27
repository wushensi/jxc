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
public class InQueryDetail extends InDetail{
	private int sumQueryNum;
	private long sumQueryMoney;
	public int getSumQueryNum() {
		return sumQueryNum;
	}
	public void setSumQueryNum(int sumQueryNum) {
		this.sumQueryNum = sumQueryNum;
	}
	public long getSumQueryMoney() {
		return sumQueryMoney;
	}
	public void setSumQueryMoney(long sumQueryMoney) {
		this.sumQueryMoney = sumQueryMoney;
	}
	
}
