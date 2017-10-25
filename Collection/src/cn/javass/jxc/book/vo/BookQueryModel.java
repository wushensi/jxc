package cn.javass.jxc.book.vo;

import java.io.Serializable;

import cn.javass.jxc.user.UserTypeEnum;

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
public class BookQueryModel extends BookModel{
	
}
