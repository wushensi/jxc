package cn.javass.c14;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class testUDPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			go();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static byte[] getTime(){
		Date d=new Date();
		return d.toString().getBytes();
	}
	
	public static void go() throws IOException{
		DatagramSocket datagramSocket;
		DatagramPacket inDataPacket;
		DatagramPacket outDataPacket;
		InetAddress clientAddress;
		int clientPort;
		byte[] msg=new byte[10];
		byte[] time;
		datagramSocket=new DatagramSocket(65530);
		System.out.println("UDP Server active on---> "+datagramSocket.getLocalPort());
		while(true){
			inDataPacket=new DatagramPacket(msg,msg.length);
			datagramSocket.receive(inDataPacket);
			clientAddress=inDataPacket.getAddress();
			clientPort=inDataPacket.getPort();
			System.out.println("msg==="+new String(inDataPacket.getData()));
			time="helloUDPClient".getBytes();//getTime();
			outDataPacket=new DatagramPacket(time,time.length,clientAddress,clientPort);
			datagramSocket.send(outDataPacket);
		}
	}

}
