package cn.javass.c14;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class testServerSocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//1、建立服务器socket
			ServerSocket s=new ServerSocket(9999);
			while(true){
				//等待客户端连接
				Socket socket=s.accept();
				InputStream in=socket.getInputStream();
				byte [] bs=new byte[20];
				in.read(bs);
				System.out.println("read=="+new String(bs));
				
				OutputStream os=socket.getOutputStream();
				DataOutputStream dos=new DataOutputStream(os);
				dos.writeUTF("Hello, "+socket.getInetAddress()+" port "+socket.getPort()+"\nbye!");
				dos.close();
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
