package cn.javass.jxc.book.dao.dao;

import java.util.Collection;

import cn.javass.jxc.book.vo.BookModel;
import cn.javass.jxc.book.vo.BookQueryModel;

public interface BookDAO {
	/**
	 * 添加一个<br>
	 * 如果uuid重复，返回false <br>
	 * 1、想把已经有的读出出来
	 * 2、查看下uuid是否重复
	 * 2.1若重复，返回false
	 * 2.2若不重复，则添加到usermode的list并返回true
	 * @param user
	 * @return
	 */
	public boolean create(BookModel book);

	/**
	 * 修改一个uuid，如果不存在，返回false
	 * 1、获取list，遍历list 判断uuid是否存在
	 * 1.1 若不存在，放回false
	 * 1.2 找到对应的list usermode对象并把usermodel更新 在序列化到文件
	 * @param user
	 * @return
	 */
	public boolean update(BookModel book);

	/**
	 * 删除一个 如果不存在，返回false
	 * 1 先把原来的全部读取出来
	 * 2 查看下uuid是否存在
	 * 2.1 若存在，这把这个user删除，并返回true
	 * 2.2 若不存在，则返回false
	 * @param user
	 * @return
	 */
	public boolean delete(String uuid);

	/**
	 * 根据主键返回一个
	 * 1、查询所有的list，判断uuid是否存在
	 * 1.1存在则返回object
	 * 1.2不存在 放回null
	 * 
	 * @param uuid
	 * @return
	 */
	public BookModel getByUuid(String uuid);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public Collection<BookModel> getByAll();

	/**
	 * 按条件查找符合的对象集合
	 * 
	 * @param user
	 * @return
	 */
	public Collection<BookModel> getByCondition(BookQueryModel bookQueryModel);
}
