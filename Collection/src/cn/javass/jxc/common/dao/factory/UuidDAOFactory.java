package cn.javass.jxc.common.dao.factory;

import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.impl.UuidDAOImpl;

public class UuidDAOFactory {
	public static UuidDAO getUuidDAO(){
		return new UuidDAOImpl();
	}
}
