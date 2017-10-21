package cn.javass.jxc.user.business.factory;

import cn.javass.jxc.user.business.ebi.UserEbi;
import cn.javass.jxc.user.business.ebo.UserEbo;

public class UserEbiFactory {
	public static UserEbi getUserEbi(){
		return new UserEbo();
	}
}
