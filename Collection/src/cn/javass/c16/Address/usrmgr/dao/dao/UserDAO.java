package cn.javass.c16.Address.usrmgr.dao.dao;

import java.util.Collection;

import cn.javass.c16.Address.usrmgr.vo.UserQueryVO;
import cn.javass.c16.Address.usrmgr.vo.UserVO;

public interface UserDAO {
	public boolean init(UserVO uservo);
	
	public boolean create(UserVO vo);
	public boolean update(UserVO vo);
	public boolean delete(UserVO vo);
	
	public UserVO getByUid(String userid);
	public Collection<UserVO> getByAll();
	public Collection<UserVO> getByCondition(UserQueryVO vo);
}
