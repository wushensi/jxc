package cn.javass.c12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ReaderWriter {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//writeFile();
		//readFile();
		String str="abc123世界";
		String s=new String(str.getBytes("ISO8859-1"),"GB2312");
		System.out.println(s);
	}

	public static void writeFile() {
		try {
			// 1 构建管道
			FileWriter out = new FileWriter("C:/Users/wushensi/Desktop/img/text.txt");
			// 2 读出流
			//byte[] bytes = { 1, 2, 3, 4, 5, 6, 7, 8, 'a' };
			String str="hello world FileOutputStream 你好 世界";
			out.write(str);
			out.close();
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
			// 1 构建管道
			FileReader in = new FileReader("C:/Users/wushensi/Desktop/img/text.txt");
			// 2 读出流
			char [] cs=new char[100];
			in.read(cs);
			
			//System.out.println();
			System.out.println(new String(cs));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
