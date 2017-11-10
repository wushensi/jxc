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
	private List <InDetail> inDetailList;
	
	public InDetailDAOImpl(List <InDetail> inDetailList){
		this.inDetailList=inDetailList;
	}
	
	public InDetailDAOImpl(){
		
	}

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
				List<InDetail> list=null;
				if(inDetailList!=null){
					list=inDetailList;
				}else{
					list=(List<InDetail>) this.getByAll();
				}
				List<InDetail> queryResult=new ArrayList<InDetail>();
				boolean flag_detailID,flag_BookID,flag_UserID,flag_detailSumNum,flag_detailSumMoney;
				
				boolean flag_detail_book,flag_detail_user,flag_book_user;
				
				boolean flag_detail_sum,flag_detail_moeny,flag_book_sum,flag_book_money,flag_user_num,flag_user_money,flag_sum_money;
				
				boolean flag_detail_book_sum,flag_detail_user_sum,flag_book_user_sum,flag_detail_book_money,flag_detail_user_money,flag_book_user_money;
				
				boolean flag_only_detailID,flag_only_BookID,flag_only_UserID,flag_only_detailSumNum,flag_only_detailSumMoney;
				
				boolean flag_detail,flag_user,flag_book,flag_money,flag_sum;
				
				boolean flag_null_detail,flag_null_book,flag_null_user,flag_null_sum,flag_null_money;
				
				flag_null_detail=inQueryDetail.getId()==null;
				flag_null_book=inQueryDetail.getBookId()==null;
				flag_null_user=inQueryDetail.getInId()==null;
				flag_null_sum=inQueryDetail.getSumNum()==0d&&inQueryDetail.getSumQueryNum()==0d;
				flag_null_money=inQueryDetail.getSumMoney()==0d&&inQueryDetail.getSumQueryMoney()==0d;
				
				flag_only_detailID=flag_null_book&&flag_null_user&&inQueryDetail.getSumMoney()==0d&&flag_null_sum;
				flag_only_BookID=flag_null_detail&&flag_null_user&&inQueryDetail.getSumMoney()==0d&&flag_null_sum;
				flag_only_UserID=flag_null_book&&flag_null_detail&&inQueryDetail.getSumMoney()==0d&&flag_null_sum;
				flag_only_detailSumNum=flag_null_book&&flag_null_detail&&flag_null_user&&flag_null_money;
				flag_only_detailSumMoney=flag_null_book&&flag_null_detail&&flag_null_user&&flag_null_sum;
				
				
				for(InDetail model:list){
					
					flag_detail=model.getId().equals(inQueryDetail.getId());
					flag_book=model.getBookId().equals(inQueryDetail.getBookId());
					flag_user=model.getInId().equals(inQueryDetail.getInId());
					flag_sum=model.getSumNum()>=inQueryDetail.getSumNum()&&model.getSumNum()<=inQueryDetail.getSumQueryNum();
					flag_money=model.getSumMoney()>=inQueryDetail.getSumMoney()&&model.getSumMoney()<=inQueryDetail.getSumQueryMoney();
					
					
					
					flag_detailID=flag_detail&&flag_only_detailID;
					flag_BookID=flag_book&&flag_only_BookID;
					flag_UserID=flag_user&&flag_only_UserID;
					flag_detailSumNum=flag_sum&&flag_only_detailSumNum;
					flag_detailSumMoney=flag_money&&flag_only_detailSumMoney;
					
					flag_detail_book=flag_detail&&flag_book&&flag_null_sum&&flag_null_money&&flag_null_user;
					flag_detail_user=flag_detail&&flag_user&&flag_null_sum&&flag_null_money&&flag_null_book;
					flag_book_user=flag_book&&flag_user&&flag_null_sum&&flag_null_money&&flag_null_detail;
					
					flag_detail_sum=flag_detail&&flag_sum&&flag_null_book&&flag_null_money&&flag_null_user;
					flag_detail_moeny=flag_detail&&flag_money&&flag_null_book&&flag_null_sum&&flag_null_user;
					
					flag_book_sum=flag_book&&flag_sum&&flag_null_detail&&flag_null_user&&flag_null_money;
					flag_book_money=flag_book&&flag_money&&flag_null_detail&&flag_null_user&&flag_null_sum;
					
					flag_user_num=flag_user&&flag_sum&&flag_null_detail&&flag_null_book&&flag_null_money;
					flag_user_money=flag_user&&flag_money&&flag_null_detail&&flag_null_book&&flag_null_sum;
					
					flag_sum_money=flag_sum&&flag_money&&flag_null_detail&&flag_null_book&&flag_null_user;;
					
					flag_detail_book_sum=flag_detail&&flag_book&&flag_sum;
					flag_detail_user_sum=flag_detail&&flag_user&&flag_sum;
					flag_book_user_sum=flag_book&&flag_user&&flag_sum;
					 
					flag_detail_book_money=flag_detail&&flag_book&&flag_money;
					flag_detail_user_money=flag_detail&&flag_user&&flag_money;
					flag_book_user_money=flag_detail&&flag_user&&flag_money;
					
					
					if(flag_detailID){
						queryResult.add(model);
						System.out.println("1");
					}
					
					if(flag_BookID){
						queryResult.add(model);
						System.out.println("2");
					}
					if(flag_UserID){
						queryResult.add(model);
						System.out.println("3");
					}
					if(flag_detailSumNum){
						queryResult.add(model);
						System.out.println("4");
					}
					if(flag_detailSumMoney){
						queryResult.add(model);
						System.out.println("5");
					}
					if(flag_detail_book){
						queryResult.add(model);
						System.out.println("6");
					}
					if(flag_detail_user){
						queryResult.add(model);
						System.out.println("7");
					}
					if(flag_book_user){
						queryResult.add(model);
						System.out.println("8");
					}
					if(flag_detail_sum){
						queryResult.add(model);
						System.out.println("9");
					}
					if(flag_detail_moeny){
						queryResult.add(model);
						System.out.println("10");
					}
					if(flag_book_sum){
						queryResult.add(model);
						System.out.println("11");
					}
					if(flag_book_money){
						queryResult.add(model);
						System.out.println("12");
					}
					if(flag_user_num){
						queryResult.add(model);
						System.out.println("13");
					}
					if(flag_user_money){
						queryResult.add(model);
						System.out.println("14");
					}
					if(flag_sum_money){
						queryResult.add(model);
						System.out.println("15");
					}
					if(flag_detail_book_sum){
						queryResult.add(model);
						System.out.println("16");
					}
					if(flag_detail_user_sum){
						queryResult.add(model);
						System.out.println("17");
					}
					if(flag_book_user_sum){
						queryResult.add(model);
						System.out.println("18");
					}
					if(flag_detail_book_money){
						queryResult.add(model);
						System.out.println("19");
					}
					if(flag_detail_user_money){
						queryResult.add(model);
						System.out.println("20");
					}
					if(flag_book_user_money){
						queryResult.add(model);
						System.out.println("21");
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
		/*InDetail inDetail=new InDetail();
		inDetail.setId("1");
		inDetail.setBookId("1");
		inDetail.setInId("1");
		inDetail.setSumNum(15);
		inDetail.setSumMoney(153.5d);
		InDetailDAO dao=new InDetailDAOImpl();*/
		//System.out.println(dao.create(inDetail));
		//dao.delete("2");
		InDetailDAO dao=new InDetailDAOImpl();
		InQueryDetail query=new InQueryDetail();
		//query.setId("8");
		//query.setBookId("2");
		query.setInId("1");
		//query.setSumNum(1);
		//query.setSumQueryNum(1);
		//query.setSumMoney(70);
		//query.setSumQueryMoney(300);
		System.out.println(dao.getByCondition(query));
		System.out.println(dao.getByAll());
	}

}
