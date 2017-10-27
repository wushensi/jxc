package cn.javass.jxc.in.dao.factory;

import cn.javass.jxc.in.dao.dao.InDetailDAO;
import cn.javass.jxc.in.dao.impl.InDetailDAOImpl;

public class InDetailDAOFactory {
	public static InDetailDAO getInDetailDAO(){
		return new InDetailDAOImpl();
	}
}
