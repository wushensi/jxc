package cn.javass.c12.awt.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class testObjectInputStream {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testObjectInputStream test=new testObjectInputStream();
		String fileName="E:/JAVAWEB/UP/Java私塾Java开发初中高项目光盘/Java私塾—Java中级/3/gui_database.conf";
		//String fileName="D:/六壬网安/0922/test.txt";
		test.readObject(fileName);
	}
	
	public void readObject(String fileName) throws Exception{
		FileInputStream fis=new FileInputStream(fileName);
		ObjectInputStream bis=new ObjectInputStream(fis);
		List list=new ArrayList();
		list=(List)bis.readObject();
		//System.out.println("object---"+bis.readObject());
		System.out.println("list---"+list);
		bis.close();
		//return null;
	}

}
