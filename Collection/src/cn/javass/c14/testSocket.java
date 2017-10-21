package cn.javass.c14;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class testSocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//1、与服务器简历连接
			Socket s1=new Socket("127.0.0.1",9999);
			OutputStream out=s1.getOutputStream();
			out.write("Hello Server".getBytes());
			
			InputStream in=s1.getInputStream();
			DataInputStream din=new DataInputStream(in);
			System.out.println(din.readUTF());
			din.close();
			s1.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
