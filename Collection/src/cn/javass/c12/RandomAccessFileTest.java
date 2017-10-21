package cn.javass.c12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// writeFile();
		//readFile();
		readLine();
	}

	public static void readLine() {
		try {
			RandomAccessFile rf = new RandomAccessFile(
					"D:/¡˘»…Õ¯∞≤/0922/fileList.txt", "r");

			long pointer = 0L;

			long len = rf.length();
			byte[] bytes=new byte[2048];
			String str=null;
			while(pointer<=len){
				rf.read(bytes);
				str=new String(bytes,"gb2312");
				System.out.println("fileList---"+str);
				pointer=rf.getFilePointer();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readFile() {
		try {
			RandomAccessFile rf = new RandomAccessFile(
					"D:/¡˘»…Õ¯∞≤/0922/fileList.txt", "rw");
			byte[] bytes = new byte[1024];

			rf.read(bytes);

			System.out.println(new String(bytes, "gb2312"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeFile() {
		try {
			RandomAccessFile rf = new RandomAccessFile("D:/¡˘»…Õ¯∞≤/0922/abc.txt",
					"rw");
			rf.write("ƒ„∫√".getBytes("gb2312"));
			rf.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
