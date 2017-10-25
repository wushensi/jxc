package cn.javass.jxc.book.business.ebo;

import java.util.Collection;

import cn.javass.jxc.book.business.ebi.BookEbi;
import cn.javass.jxc.book.dao.dao.BookDAO;
import cn.javass.jxc.book.dao.factory.BookDAOFactory;
import cn.javass.jxc.user.vo.UserModel;
import cn.javass.jxc.user.vo.UserQueryModel;

public class BookEbo implements BookEbi {

	private static BookDAO dao= BookDAOFactory.getBookDAO();
	@Override
	public boolean create(UserModel book) {
		// TODO Auto-generated method stub
		return dao.create(book);
	}

	@Override
	public boolean update(UserModel book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<UserModel> getByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<UserModel> getByCondition(UserQueryModel book) {
		// TODO Auto-generated method stub
		return null;
	}

}
