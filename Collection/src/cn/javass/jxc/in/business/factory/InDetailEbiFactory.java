package cn.javass.jxc.in.business.factory;

import cn.javass.jxc.in.business.ebi.InDetailEbi;
import cn.javass.jxc.in.business.ebo.InDetailEbo;

public class InDetailEbiFactory {
	public static InDetailEbi getInDetailEbi(){
		return new InDetailEbo();
	}
}
