package cn.javass.jxc.in.business.factory;

import java.util.List;

import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.ebo.InMainEbo;
import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InMain;

public class InMainEbiFactory {
	public static InMainEbi getInMainEbi(){
		return new InMainEbo();
	}
	
	public static InMainEbi getInMainEbi(List<InMain> mainList,List<InDetail> detailList){
		return new InMainEbo(mainList,detailList);
	}
}
