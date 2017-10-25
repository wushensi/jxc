package cn.javass.jxc.user.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.user.dao.dao.UserDAO;
import cn.javass.jxc.user.vo.UserModel;
import cn.javass.jxc.user.vo.UserQueryModel;

/**
 * 用序列化/反序列化的方式，如何添加 序列号/反序列化，相当于可以把对象放到文件中，把对象从文件中读出来 对于create
 * 
 * @author wushensi
 * 
 */

public class UserDAOImpl implements UserDAO {

	private final static String FILE_NAME = "User.txt";

	@Override
	public boolean create(UserModel user) {
		// TODO Auto-generated method stub
		// 1、想把已经有的读出出来
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);

		// 2、查看下uuid是否重复
		for (UserModel model : list) {
			if (model.getUuid().equals(user.getUuid())) {
				return false;
			}
		}

		// 2.1若重复，返回false
		// 2.2若不重复，则添加到usermode的list并返回true
		list.add(user);

		// 序列化
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(UserModel user) {
		// TODO Auto-generated method stub
		// 修改一个uuid，如果不存在，返回false
		// 1、获取list，遍历list 判断uuid是否存在
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (UserModel model : list) {
			if (model.getUuid().equals(user.getUuid())) {
				// 修改
				model.setName(user.getName());
				model.setPwd(user.getPwd());
				model.setType(user.getType());
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
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (UserModel model : list) {
			if (model.getUuid().equals(uuid)) {
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
	public UserModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1、查询所有的list，判断uuid是否存在
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (UserModel model : list) {
			if (model.getUuid().equals(uuid)) {
				return model;
			}
		}
		// 1.1存在则返回object
		// 1.2不存在 放回null
		return null;
	}

	@Override
	public Collection<UserModel> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<UserModel> getByCondition(UserQueryModel user) {
		// TODO Auto-generated method stub
		// 1、循环所有对象
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		List<UserModel> queryResult = new ArrayList<UserModel>();
		// 2、把符合条件的model加入list
		System.out.println("------"+list);
		for (UserModel model : list) {
			// 正逻辑
			if(user.getType()>0){
				if (user.getType() == model.getType()) {
					queryResult.add(model);
				}
			}else if(model.getUuid().equals(user.getUuid())){
				queryResult.add(model);
			}else if(model.getName().indexOf(user.getName())>=0) {
				if(user.getName().equals("")){
					continue;
				}
				queryResult.add(model);
			}
			
			// 卫条件
			// 内外层
		}
		// 3、返回list
		return queryResult;
	}

	public static void main(String[] args) {
		UserDAO userdao = new UserDAOImpl();
		// UserModel user=new UserModel();
		UserQueryModel query = new UserQueryModel();
		query.setUuid("");
		query.setName("");
		query.setType(4);
		System.out.println("------"+userdao.getByCondition(query));
		
	
	}

}
