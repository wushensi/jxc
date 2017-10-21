package cn.javass.c13;

public class testRunnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 t=new MyThread1();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class MyThread1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<300;i++){
			System.out.println("i= "+i+" name= "+Thread.currentThread().getName());
		}
	}
	
}
