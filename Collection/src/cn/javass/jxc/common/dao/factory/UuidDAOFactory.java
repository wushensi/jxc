package cn.javass.jxc.common.dao.factory;

import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.impl.DetailIDDAOImpl;
import cn.javass.jxc.common.dao.impl.MainIDDAOImpl;
import cn.javass.jxc.common.dao.impl.UuidDAOImpl;

public class UuidDAOFactory {
	public static UuidDAO getUuidDAO(){
		return new UuidDAOImpl();
	}
	
	public static UuidDAO getDetailIdDAO(){
		return new DetailIDDAOImpl();
	}
	
	public static UuidDAO getMainIdDAO(){
		return new MainIDDAOImpl();
	}
}
