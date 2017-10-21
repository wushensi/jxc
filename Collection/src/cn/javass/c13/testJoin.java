package cn.javass.c13;

public class testJoin {

	/**
	 * @param args
	 */
	
	//t1.join()这句话会让当前线程main线程与他
	//线程合并，也就是说知道t1线程执行完成，main线程才会继续向下运行
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Runner();
		Thread t2=new Runner();
		t1.start();
		try{
			t1.join();
		}catch (InterruptedException e){
			
		}
		System.out.println("main go on -------------------->"+Thread.currentThread().getName());
		t2.start();
	}

}

class Runner extends Thread {
	public void run() {
		int i = 0;
		System.out.println(Thread.currentThread().getName());
		for (; i < 100; i++) {
			System.out.println("i = " + i + "-----"
					+ Thread.currentThread().getName());
		}
	}
}
