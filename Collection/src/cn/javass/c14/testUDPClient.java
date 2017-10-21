package cn.javass.c14;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class testUDPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			go();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void go() throws Exception{
		//用于做连接
		DatagramSocket datagramSocket;
		
		DatagramPacket outDataPacket;
		DatagramPacket inDataPacket;
		InetAddress serverAddress;
		byte[] msg="test".getBytes();
		String receivedMsg;
		datagramSocket=new DatagramSocket();
		serverAddress=InetAddress.getLocalHost();
		outDataPacket=new DatagramPacket(msg,msg.length,serverAddress,65530);
		datagramSocket.send(outDataPacket);
		byte[] temp=new byte[1024];
		inDataPacket=new DatagramPacket(temp,temp.length);
		datagramSocket.receive(inDataPacket);
		receivedMsg=new String(inDataPacket.getData(),0,inDataPacket.getLength());
		System.out.println("receivedMsg--->"+receivedMsg);
		datagramSocket.close();
	}

}
