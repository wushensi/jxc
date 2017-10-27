package cn.javass.jxc.in.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.in.dao.dao.InDetailDAO;
import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryDetail;



/**
 * 用序列化/反序列化的方式，如何添加 序列号/反序列化，相当于可以把对象放到文件中，把对象从文件中读出来 对于create
 * 
 * @author wushensi
 * 
 */

public class InDetailDAOImpl implements InDetailDAO {

	private final static String FILE_NAME = "InDetail.txt";

	@Override
	public boolean create(InDetail inDetail) {
		// TODO Auto-generated method stub
		// 1、想把已经有的读出出来
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		System.out.println(inDetail);
		// 2、查看下uuid是否重复
		for (InDetail model : list) {
			if (model.getId().equals(inDetail.getId())) {
				return false;
			}
		}
		// 2.1若重复，返回false
		// 2.2若不重复，则添加到usermode的list并返回true
		list.add(inDetail);

		// 序列化
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(InDetail inDetail) {
		// TODO Auto-generated method stub
		// 修改一个uuid，如果不存在，返回false
		// 1、获取list，遍历list 判断uuid是否存在
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		for (InDetail model : list) {
			if (model.getId().equals(inDetail.getId())) {
				// 修改
				model.setBookId(inDetail.getBookId());
				model.setInId(inDetail.getInId());
				model.setSumMoney(inDetail.getSumMoney());
				model.setSumNum(inDetail.getSumNum());
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
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		for (InDetail model : list) {
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
	public InDetail getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1、查询所有的list，判断uuid是否存在
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		for (InDetail model : list) {
			if (model.getId().equals(uuid)) {
				return model;
			}
		}
		// 1.1存在则返回object
		// 1.2不存在 放回null
		return null;
	}

	@Override
	public Collection<InDetail> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<InDetail> getByCondition(InQueryDetail inQueryDetail) {
		// TODO Auto-generated method stub
		// 1、循环所有对象
		List<InDetail> list=SerialUtil.readFromFile(FILE_NAME);
		List<InDetail> queryResult=new ArrayList<InDetail>();
		for(InDetail model:list){
			
		}
		// 2、把符合条件的model加入list
		
			// 正逻辑
			
			// 卫条件
			// 内外层
		// 3、返回list
		return queryResult;
	}

	public static void main(String[] args) {
		InDetail inDetail=new InDetail();
		inDetail.setId("1");
		inDetail.setBookId("1");
		inDetail.setInId("1");
		inDetail.setSumNum(15);
		inDetail.setSumMoney(153.5d);
		InDetailDAO dao=new InDetailDAOImpl();
		//System.out.println(dao.create(inDetail));
		//dao.delete("2");
		System.out.println(dao.update(inDetail));
		System.out.println(dao.getByAll());
		
	
	}

}
