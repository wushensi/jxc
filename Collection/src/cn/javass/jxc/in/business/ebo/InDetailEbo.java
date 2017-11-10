package cn.javass.jxc.in.business.ebo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.javass.jxc.in.business.ebi.InDetailEbi;
import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.factory.InDetailEbiFactory;
import cn.javass.jxc.in.business.factory.InMainEbiFactory;
import cn.javass.jxc.in.dao.dao.InDetailDAO;
import cn.javass.jxc.in.dao.factory.InDetailDAOFactory;
import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryDetail;

public class InDetailEbo implements InDetailEbi{

	private List <InDetail> inDetailList;
	private InDetailDAO dao=InDetailDAOFactory.getInQueryDetailDAO(inDetailList);
	
	public InDetailEbo(){
		
	}
	
	public InDetailEbo(List <InDetail> inDetailList){
		this.inDetailList=inDetailList;
	}

	@Override
	public boolean create(InDetail inDetail) {
		// TODO Auto-generated method stub
		return dao.create(inDetail);
	}

	@Override
	public boolean update(InDetail inDetail) {
		// TODO Auto-generated method stub
		return dao.update(inDetail);
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		return dao.delete(uuid);
	}

	@Override
	public InDetail getByUuid(String uuid) {
		// TODO Auto-generated method stub
		return dao.getByUuid(uuid);
	}

	@Override
	public Collection<InDetail> getByAll() {
		// TODO Auto-generated method stub
		return dao.getByAll();
	}

	@Override
	public Collection<InDetail> getByCondition(InQueryDetail inQueryDetail) {
		// TODO Auto-generated method stub
		return dao.getByCondition(inQueryDetail);
	}
	
	

}
