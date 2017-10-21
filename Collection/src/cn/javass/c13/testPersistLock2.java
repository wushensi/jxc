package cn.javass.c13;

public class testPersistLock2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S1 s1=new S1();
		S2 s2=new S2();
		Thread b=new Thread(new ThreadBB(s1,s2));
		Thread a=new Thread(new ThreadAA(s1,s2));
		b.start();
		a.start();
	}

}
class S1{
	public int a=1;
}

class S2{
	public int a=2;
}

class ThreadAA implements Runnable{
	private S1 s1=null;
	private S2 s2=null;
	public ThreadAA(S1 s1,S2 s2){
		this.s1=s1;
		this.s2=s2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("now begin ThreadAA------>");
		synchronized(s1){
			System.out.println("ThreadAA s1.a="+s1.a);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread AA get s1 lock,wait s2 lock");
			synchronized(s2){
				System.out.println("ThreadAA s2.a="+s2.a);
			}
		}
		
	}
	
}

class ThreadBB implements Runnable{
	private S1 s1=null;
	private S2 s2=null;
	public ThreadBB(S1 s1,S2 s2){
		this.s1=s1;
		this.s2=s2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("now begin ThreadBB------>");
		synchronized(s2){
			System.out.println("ThreadBB s2.a="+s2.a);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread BB get s2 lock,wait s1 lock");
			synchronized(s1){
				System.out.println("ThreadAA s1.a="+s1.a);
			}
		}
	}
	
}