package cn.javass.c12;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInputStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStreamTest t=new DataInputStreamTest();
		t.testDataInputStream();
	}

	public void testDataInputStream() {
		String str = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:/¡˘»…Õ¯∞≤/0922/fileList.txt");
			InputStreamReader isr=new InputStreamReader(fis,"gb2312");
			//BufferedInputStream bin=new BufferedInputStream(fis);
			BufferedReader bfs=new BufferedReader(isr);
			//DataInputStream in = new DataInputStream(bfs);
			while((str = bfs.readLine())!=null){
					System.out.println(str);
			}
			bfs.close();
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
