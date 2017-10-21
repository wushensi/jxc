package cn.javass.c13;

public class testMyThread implements Runnable{
	String myString="YES";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMyThread t=new testMyThread();
		new Thread(t).start();
		for(int i=0;i<1000;i++){
			System.out.println(t.myString);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.myString="NO";
	}

}
