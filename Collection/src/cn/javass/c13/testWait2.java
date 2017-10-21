package cn.javass.c13;

public class testWait2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA3 thread = new ThreadA3(true);
		Thread b = new Thread(thread);
		Thread a = new Thread(thread);
		b.start();
		a.start();
	}

}

class ThreadA3 implements Runnable {
	private boolean needWait=false;
	public ThreadA3(boolean needWait) {
		this.needWait = needWait;
		System.out.println(needWait);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for (int i = 0; i < 30; i++) {
				System.out.println("synchronized "
						+ Thread.currentThread().getName() + "  i=" + i);
				try {
					if (needWait) {
						System.out.println("flag---" + needWait + " wait");
						needWait = false;
						wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.notify();
		}
	}
}
