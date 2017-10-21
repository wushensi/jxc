package cn.javass.c13;

public class testPersistLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S s =new S();
		Thread b=new Thread(new ThreadB(s));
		Thread a=new Thread(new ThreadA(s,b));
		b.start();
		a.start();
	}

}
class S{
	public int a=0;
}
class ThreadA implements Runnable{
	private S s=null;
	private Thread b=null;
	public ThreadA(S s,Thread b){
		this.s=s;
		this.b=b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("now begin ThreadA===");
		synchronized(s){
			System.out.println("synchronize ThreadA------>"+Thread.currentThread().getName());
			try{
				b.join();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("    a------>"+s.a);
		}
	}
	
}

class ThreadB implements Runnable{
	private S s=null;
	public ThreadB(S s){
		this.s=s;
	}
	
	@Override
	public void run() {
		System.out.println("now begin ThreadB===");
		// TODO Auto-generated method stub
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("ThreadB go on");
		synchronized(s){
			s.a=6;
			System.out.println("synchronize ThreadB--->"+Thread.currentThread().getName()+"   s.a is--->"+s.a);
		}
	}
	
}
