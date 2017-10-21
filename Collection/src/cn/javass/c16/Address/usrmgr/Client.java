package cn.javass.c16.Address.usrmgr;

import cn.javass.c16.Address.usrmgr.business.ebi.UserEbi;
import cn.javass.c16.Address.usrmgr.business.factory.UserEbiFactory;
import cn.javass.c16.Address.usrmgr.dao.dao.UserDAO;
import cn.javass.c16.Address.usrmgr.dao.factory.UserDaoFactory;
import cn.javass.c16.Address.usrmgr.vo.UserVO;

public class Client {
	public static void main(String[] args) {
		UserEbi userEbi=UserEbiFactory.getUserEbi();
		UserDAO userDao=UserDaoFactory.getUserDAO();
		UserVO userVo=new UserVO();
		userVo.setUserid("111");
		userVo.setUsername("zhangsan");
		userDao.init(userVo);
	}
}
