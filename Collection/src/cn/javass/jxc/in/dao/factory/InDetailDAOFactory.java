package cn.javass.jxc.in.dao.factory;

import java.util.List;

import cn.javass.jxc.in.dao.dao.InDetailDAO;
import cn.javass.jxc.in.dao.impl.InDetailDAOImpl;
import cn.javass.jxc.in.vo.InDetail;

public class InDetailDAOFactory {
	public static InDetailDAO getInDetailDAO(){
		return new InDetailDAOImpl();
	}
	public static InDetailDAO getInQueryDetailDAO(List <InDetail> inDetailList){
		return new InDetailDAOImpl(inDetailList);
	}
}
