package cn.javass.c13;

public class testWait {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S111 s1=new S111();
		Thread b=new Thread(new ThreadAAA(s1));
		Thread a=new Thread(new ThreadAAA(s1));
		b.start();
		a.start();
	}

}

class S111{
	public int a=1;
}
//虽然起了两个线程，但是就算第一个线程sleep 也不释放对象锁，而是一直等到它循环完成，退出同步块，第二个才开始运行
class ThreadAAA implements Runnable{
	private S111 s1 =null;
	public ThreadAAA(S111 s1){
		this.s1=s1;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(s1){
			for(int i=0;i<10;i++){
				System.out.println("synchronized "+Thread.currentThread().getName()+"  i="+i);
				try {
					Thread.sleep(125);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
}
