package cn.javass.c16.Address.usrmgr.dao.impl;

import java.util.Collection;

import cn.javass.c16.Address.usrmgr.dao.dao.UserDAO;
import cn.javass.c16.Address.usrmgr.vo.UserQueryVO;
import cn.javass.c16.Address.usrmgr.vo.UserVO;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean init(UserVO uservo) {
		// TODO Auto-generated method stub
		System.out.println("userid------"+uservo.getUserid()+"------username------"+uservo.getUsername());
		return false;
	}

	@Override
	public boolean create(UserVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVO getByUid(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<UserVO> getByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<UserVO> getByCondition(UserQueryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
