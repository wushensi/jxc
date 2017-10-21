package cn.javass.c13;

import java.awt.Frame;
import java.awt.Label;
import java.util.Calendar;

public class testSleep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("My Watch");
		Label lable=new Label();
		f.add(lable);
		f.setSize(100, 50);
		f.setVisible(true);
		while(true){
			Calendar c=Calendar.getInstance();
			lable.setText(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
		}
		
	}

}
