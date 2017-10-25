package cn.javass.jxc.common.dao.impl;

import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.vo.UuidModel;
import cn.javass.jxc.user.UuidEnum;

public class UuidDAOImpl implements UuidDAO{

	private final static String USER_UUID = "USER_UUID.txt";
	private int result=0;
	@Override
	/**
	 * 把原有的读出来
	 * 循环去找，找到，就返回 +1
	 * 若没有找到，返回1
	 */
	public String getNextNum(String modelName) {
		// TODO Auto-generated method stub
		UuidModel uuidModel=new UuidModel();
		List<UuidModel>list=SerialUtil.readFromFile(USER_UUID);
		if(list.size()==0){
			result=1;
			uuidModel.setCurrentNum(1);
			uuidModel.setModelName(modelName);
		}
		for(UuidModel model:list){
			if(model.getModelName().equals(modelName)){
				result=model.getCurrentNum()+1;
				model.setCurrentNum(result);
				uuidModel=model;
			}
		}
		if(uuidModel.getModelName()==null){
			uuidModel.setModelName(modelName);
			uuidModel.setCurrentNum(1);
			result=1;
		}
		list.removeAll(list);
		list.add(uuidModel);
		SerialUtil.writeToFile(list, USER_UUID);
		return String.valueOf(result);
	}
	
	public static void main(String[] args){
		UuidDAO dao=new UuidDAOImpl();
		System.out.println(dao.getNextNum(UuidEnum.BOOK_UUID.toString()));
	}

}
