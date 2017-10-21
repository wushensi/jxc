package cn.javass.jxc.user.dao.factory;

import cn.javass.jxc.user.dao.dao.UserDAO;
import cn.javass.jxc.user.dao.impl.UserDAOImpl;

public class UserDAOFactory {
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
}
