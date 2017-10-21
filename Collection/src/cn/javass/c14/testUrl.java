package cn.javass.c14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class testUrl {

	/**
	 * @param args
	 */
	public testUrl(){
		
	}
	public testUrl(String uuid,String name,String password){
		System.out.println("uuid--->"+uuid+"---name--->"+name+"---password--->"+password);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testUrl t=new testUrl();
		t.run();
	}
	
	public void run(){
		//System.out.println(string);
		URL readSource;
		try {
			readSource = new URL("http://www.ndasec.com");
			BufferedReader in=new BufferedReader(new InputStreamReader(readSource.openStream(),"utf8"));
			String str=null;
			while((str=in.readLine())!=null){
				System.out.println(str);
			}
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	

}
