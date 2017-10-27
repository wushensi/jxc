package cn.javass.jxc.in.dao.factory;

import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.dao.impl.InMainDAOImpl;

public class InMainDAOFactory {
	public static InMainDAO getInMainDAO(){
		return new InMainDAOImpl();
	}
}
