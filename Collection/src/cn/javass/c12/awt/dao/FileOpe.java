package cn.javass.c12.awt.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import cn.javass.c12.awt.business.MyArrayList;

public class FileOpe {
	public static void writeList(List list,String fileName){
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(list);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List readList(String fileName){
		List list=new ArrayList();
		try {
			System.out.println("fileName---"+fileName);
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
			//System.out.println("in.readObject()---"+in.readObject());
			list=(List) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list==null){
			System.out.println("list is null");
			return new MyArrayList();
		}
		System.out.println("list is ---"+list);
		return list;
	}
}
