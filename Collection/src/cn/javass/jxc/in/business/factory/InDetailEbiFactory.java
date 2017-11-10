package cn.javass.jxc.in.business.factory;

import java.util.List;

import cn.javass.jxc.in.business.ebi.InDetailEbi;
import cn.javass.jxc.in.business.ebo.InDetailEbo;
import cn.javass.jxc.in.vo.InDetail;

public class InDetailEbiFactory {
	public static InDetailEbi getInDetailEbi(){
		return new InDetailEbo();
	}
	
	public static InDetailEbi getInQueryDetailEbi(List <InDetail> inDetailList){
		return new InDetailEbo(inDetailList);
	}
}
