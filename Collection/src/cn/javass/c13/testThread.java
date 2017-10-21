package cn.javass.c13;

public class testThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		Thread t3=new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}

}

class MyThread extends Thread{
	public void run(){
		for(int i=0;i<300;i++){
			System.out.println("i= "+i+" name= "+Thread.currentThread().getName());
		}
	}
}
