package cn.javass.c16.Address.usrmgr.dao.factory;

import cn.javass.c16.Address.usrmgr.dao.dao.UserDAO;
import cn.javass.c16.Address.usrmgr.dao.impl.UserDAOImpl;

public class UserDaoFactory {
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
}
