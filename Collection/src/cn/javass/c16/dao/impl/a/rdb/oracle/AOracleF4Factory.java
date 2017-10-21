package cn.javass.c16.dao.impl.a.rdb.oracle;

import cn.javass.c16.dao.dao.DepDAO;
import cn.javass.c16.dao.impl.a.rdb.oracle.ejb.Impl1;
import cn.javass.c16.dao.impl.a.rdb.oracle.hibernate.Impl2;
import cn.javass.c16.dao.impl.a.rdb.oracle.jdbc.Impl3;
import cn.javass.c16.dao.impl.a.rdb.oracle.jpa.Impl4;

public class AOracleF4Factory {
	public static DepDAO getDepDAO(){
		int type=3;
		if(type==1){
			return new Impl1();
		}else if(type==2){
			return new Impl2();
		}else if(type==3){
			return new Impl3();
		}else if(type==4){
			return new Impl4();
		}else{
			return null;
		}
		
	}
}
