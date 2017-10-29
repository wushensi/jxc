package cn.javass.jxc.in.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryMain;



/**
 * 用序列化/反序列化的方式，如何添加 序列号/反序列化，相当于可以把对象放到文件中，把对象从文件中读出来 对于create
 * 
 * @author wushensi
 * 
 */

public class InMainDAOImpl implements InMainDAO {

	private final static String FILE_NAME = "InMain.txt";

	@Override
	public boolean create(InMain inMain) {
		// TODO Auto-generated method stub
		// 1、想把已经有的读出出来
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		System.out.println(inMain);
		// 2、查看下uuid是否重复
		for (InMain model : list) {
			if (model.getId().equals(inMain.getId())) {
				return false;
			}
		}
		// 2.1若重复，返回false
		// 2.2若不重复，则添加到usermode的list并返回true
		list.add(inMain);

		// 序列化
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(InMain inMain) {
		// TODO Auto-generated method stub
		// 修改一个uuid，如果不存在，返回false
		// 1、获取list，遍历list 判断uuid是否存在
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		for (InMain model : list) {
			if (model.getId().equals(inMain.getId())) {
				// 修改
				model.setInDate(inMain.getInDate());
				model.setInUserId(inMain.getInUserId());
				// 序列化到文件
				SerialUtil.writeToFile(list, FILE_NAME);
				// 返回true
				return true;
			}
		}
		// 1.1 若不存在，放回false
		// 1.2 找到对应的list usermode对象并把usermodel更新 在序列化到文件
		return false;
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		// 1 先把原来的全部读取出来
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		for (InMain model : list) {
			if (model.getId().equals(uuid)) {
				// 删除list元素
				list.remove(model);
				// 序列化到文件
				SerialUtil.writeToFile(list, FILE_NAME);
				return true;
			}
		}
		// 2 查看下uuid是否存在
		// 2.1 若存在，这把这个user删除，并返回true
		// 2.2 若不存在，则返回false
		return false;
	}

	@Override
	public InMain getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1、查询所有的list，判断uuid是否存在
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		for (InMain model : list) {
			if (model.getId().equals(uuid)) {
				return model;
			}
		}
		// 1.1存在则返回object
		// 1.2不存在 放回null
		return null;
	}

	@Override
	public Collection<InMain> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<InMain> getByCondition(InQueryMain inQueryMain) {
		// TODO Auto-generated method stub
		// 1、循环所有对象
		List<InMain> list=SerialUtil.readFromFile(FILE_NAME);
		List<InMain> queryResult=new ArrayList<InMain>();
		for(InMain model:list){
			if(model.getId().equals(inQueryMain.getId())||model.getInUserId().equals(inQueryMain.getInUserId())){
				queryResult.add(model);
				System.out.println("1");
			}
			if(inQueryMain.getInDate()!=0&&inQueryMain.getInDate()<=model.getInDate() && model.getInDate()<=inQueryMain.getInQueryDate()){
				queryResult.add(model);
				System.out.println("2");
			}
			if(inQueryMain.getInDate()>model.getInDate()&&inQueryMain.getInQueryDate()==0){
				queryResult.add(model);
				System.out.println("3");
			}
			if(inQueryMain.getInDate()==0&&inQueryMain.getInQueryDate()<model.getInDate()){
				queryResult.add(model);
				System.out.println("4");
			}
		}
		// 2、把符合条件的model加入list
		// 正逻辑
		// 卫条件
		// 内外层
		// 3、返回list
		return queryResult;
	}

	public static void main(String[] args) {
//		InMain inMain=new InMain();
//		inMain.setId("2");
//		inMain.setInDate(90000000);
//		inMain.setInUserId("3");
		InQueryMain query=new InQueryMain();
		query.setId("1");
		//query.setInUserId("5");
		Date date=new Date();
		//query.setInDate(0);
		//query.setInQueryDate(date.getTime());
		System.out.println(date.getTime());
		InMainDAO dao=new InMainDAOImpl();
		//System.out.println(dao.update(inMain));
		System.out.println(dao.getByCondition(query));
	}

}
