package cn.javass.c16.dao.impl.a.rdb;

import cn.javass.c16.dao.dao.DepDAO;
import cn.javass.c16.dao.impl.a.rdb.oracle.AOracleF4Factory;

public class ARDBF3Factory {
	public static DepDAO getDepDAO(){
		return AOracleF4Factory.getDepDAO();
	}
}
