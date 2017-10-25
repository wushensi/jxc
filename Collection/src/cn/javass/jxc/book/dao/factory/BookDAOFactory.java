package cn.javass.jxc.book.dao.factory;

import cn.javass.jxc.book.dao.dao.BookDAO;
import cn.javass.jxc.book.dao.impl.BookDAOImpl;

public class BookDAOFactory {
	public static BookDAO getBookDAO(){
		return new BookDAOImpl();
	}
}
