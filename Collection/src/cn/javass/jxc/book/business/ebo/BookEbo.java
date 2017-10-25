package cn.javass.jxc.book.business.ebo;

import java.util.Collection;

import cn.javass.jxc.book.business.ebi.BookEbi;
import cn.javass.jxc.book.dao.dao.BookDAO;
import cn.javass.jxc.book.dao.factory.BookDAOFactory;
import cn.javass.jxc.book.vo.BookModel;
import cn.javass.jxc.book.vo.BookQueryModel;


public class BookEbo implements BookEbi {

	private static BookDAO dao= BookDAOFactory.getBookDAO();
	@Override
	public boolean create(BookModel book) {
		// TODO Auto-generated method stub
		return dao.create(book);
	}

	@Override
	public boolean update(BookModel book) {
		// TODO Auto-generated method stub
		return dao.update(book);
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		return dao.delete(uuid);
	}

	@Override
	public BookModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		return dao.getByUuid(uuid);
	}

	@Override
	public Collection<BookModel> getByAll() {
		// TODO Auto-generated method stub
		return dao.getByAll();
	}

	@Override
	public Collection<BookModel> getByCondition(BookQueryModel book) {
		// TODO Auto-generated method stub
		return dao.getByCondition(book);
	}

}
