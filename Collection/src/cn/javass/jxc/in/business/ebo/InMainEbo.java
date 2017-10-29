package cn.javass.jxc.in.business.ebo;

import java.util.Collection;

import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.dao.factory.InMainDAOFactory;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryMain;

public class InMainEbo implements InMainEbi{

	private InMainDAO dao=InMainDAOFactory.getInMainDAO();
	@Override
	public boolean create(InMain inMain) {
		// TODO Auto-generated method stub
		return dao.create(inMain);
	}

	@Override
	public boolean update(InMain inMain) {
		// TODO Auto-generated method stub
		return dao.update(inMain);
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		return dao.delete(uuid);
	}

	@Override
	public InMain getByUuid(String uuid) {
		// TODO Auto-generated method stub
		return dao.getByUuid(uuid);
	}

	@Override
	public Collection<InMain> getByAll() {
		// TODO Auto-generated method stub
		return dao.getByAll();
	}

	@Override
	public Collection<InMain> getByCondition(InQueryMain inQueryMain) {
		// TODO Auto-generated method stub
		return dao.getByCondition(inQueryMain);
	}

}
