package cn.javass.c13;

public class testQuestion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncTest t=new SyncTest();
		Thread thread1=new Thread(t);
		Thread thread2=new Thread(t);
		thread1.start();
		thread2.start();
		System.out.println(Thread.currentThread().getName()+" x="+t.getX()+" ,y="+t.getY());
	}

}

class SyncTest implements Runnable{
	private int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	private int y;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this){
			x++;
			y++;
		}
		System.out.println(Thread.currentThread().getName()+" x="+x+" , y="+y);
	}
	
}
