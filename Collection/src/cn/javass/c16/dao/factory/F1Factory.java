package cn.javass.c16.dao.factory;

import cn.javass.c16.dao.dao.DepDAO;
import cn.javass.c16.dao.impl.a.AF2Factory;
import cn.javass.c16.dao.impl.b.BF2Factory;

public class F1Factory {
	public static DepDAO getDepDAO(){
		//return null;
		//type 通常卸载配置文件中
		int type=1;
		if(type==1){
			return AF2Factory.getDepDAO();
		}else if(type==2){
			return BF2Factory.getDepDAO();
		}else{
			return null;
		}
	}
}
