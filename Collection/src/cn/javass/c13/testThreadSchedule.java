package cn.javass.c13;

public class testThreadSchedule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Runner3(true);
		Thread t2=new Runner3(false);;
		t1.setPriority(5);
		t2.setPriority(5);
		t1.start();
		t2.start();
		
	}

}

class Runner3 extends Thread{
	boolean flag=false;
	public Runner3(boolean flag){
		this.flag=flag;
	}
	public void run(){
		int i=0;
		
		try{
			if(flag){
				Thread.yield();
				System.out.println(Thread.currentThread().getName()+" is yield");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		for(;i<1000;i++){
			System.out.println("i = "+i+"-----"+Thread.currentThread().getName());
		}
	}
}
