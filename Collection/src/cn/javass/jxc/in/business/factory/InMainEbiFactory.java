package cn.javass.jxc.in.business.factory;

import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.ebo.InMainEbo;

public class InMainEbiFactory {
	public static InMainEbi getInMainEbi(){
		return new InMainEbo();
	}
}
