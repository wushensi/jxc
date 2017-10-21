package cn.javass.c16.dao.impl.a;

import cn.javass.c16.dao.dao.DepDAO;
import cn.javass.c16.dao.impl.a.file.AFileF3Factory;
import cn.javass.c16.dao.impl.a.rdb.ARDBF3Factory;

public class AF2Factory {
	public static DepDAO getDepDAO(){
		int type=1;
		if(type==1){
			return ARDBF3Factory.getDepDAO();
		}else if(type==2){
			return AFileF3Factory.getDepDAO();
		}else{
			return null;
		}
	}
}
