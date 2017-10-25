package cn.javass.jxc.book.dao.impl;

import java.util.Collection;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.book.dao.dao.BookDAO;
import cn.javass.jxc.book.vo.BookModel;
import cn.javass.jxc.book.vo.BookQueryModel;
import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.factory.UuidDAOFactory;
import cn.javass.jxc.common.vo.UuidModel;
import cn.javass.jxc.user.UuidEnum;


/**
 * 用序列化/反序列化的方式，如何添加 序列号/反序列化，相当于可以把对象放到文件中，把对象从文件中读出来 对于create
 * 
 * @author wushensi
 * 
 */

public class BookDAOImpl implements BookDAO {

	private final static String FILE_NAME = "Book.txt";

	@Override
	public boolean create(BookModel book) {
		// TODO Auto-generated method stub
		// 1、想把已经有的读出出来
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		System.out.println(book);
		System.out.println("book uuid---------"+book.getUuid());
		// 2、查看下uuid是否重复
		for (BookModel model : list) {
			if (model.getUuid().equals(book.getUuid())) {
				
				return false;
			}
		}

		// 2.1若重复，返回false
		// 2.2若不重复，则添加到usermode的list并返回true
		list.add(book);

		// 序列化
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(BookModel book) {
		// TODO Auto-generated method stub
		// 修改一个uuid，如果不存在，返回false
		// 1、获取list，遍历list 判断uuid是否存在
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (BookModel model : list) {
			if (model.getUuid().equals(book.getUuid())) {
				// 修改
				model.setName(book.getName());
				model.setInPrice(book.getInPrice());
				model.setSalePrice(book.getSalePrice());
				// 序列化到文件
				SerialUtil.writeToFile(list, FILE_NAME);
				// 返回true
				return true;
			}
		}
		// 1.1 若不存在，放回false
		// 1.2 找到对应的list usermode对象并把usermodel更新 在序列化到文件
		return false;
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		// 1 先把原来的全部读取出来
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (BookModel model : list) {
			if (model.getUuid().equals(uuid)) {
				// 删除list元素
				list.remove(model);
				// 序列化到文件
				SerialUtil.writeToFile(list, FILE_NAME);
				return true;
			}
		}
		// 2 查看下uuid是否存在
		// 2.1 若存在，这把这个user删除，并返回true
		// 2.2 若不存在，则返回false
		return false;
	}

	@Override
	public BookModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1、查询所有的list，判断uuid是否存在
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (BookModel model : list) {
			if (model.getUuid().equals(uuid)) {
				return model;
			}
		}
		// 1.1存在则返回object
		// 1.2不存在 放回null
		return null;
	}

	@Override
	public Collection<BookModel> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<BookModel> getByCondition(BookQueryModel book) {
		// TODO Auto-generated method stub
		// 1、循环所有对象
		
		// 2、把符合条件的model加入list
		
			// 正逻辑
			
			// 卫条件
			// 内外层
		// 3、返回list
		return null;
	}

	public static void main(String[] args) {
		BookDAO dao = new BookDAOImpl();
		// UserModel user=new UserModel();
		BookModel book=new BookModel();
		UuidModel uuid=new UuidModel();
		//使用离散值enum枚举，对一个类 只限定生成特定几个的实例，重新实现uuid自动生产
		uuid.setModelName(UuidEnum.BOOK_UUID.toString());
		UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
		book.setUuid(uuidDao.getNextNum(uuid.getModelName()));
		book.setName("Thinking in java");
		book.setInPrice(110.01);
		book.setSalePrice(213.2);
		//System.out.println(dao.create(book));
		System.out.println(dao.getByAll());
		
		//System.out.println("------"+userdao.getByCondition(query));
		
	
	}

}
