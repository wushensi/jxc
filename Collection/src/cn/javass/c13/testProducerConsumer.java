package cn.javass.c13;

import java.util.ArrayList;
import java.util.List;

public class testProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynStack stack=new SynStack();
		
		Producer p1=new Producer(stack);
		Thread producerT=new Thread(p1);
		producerT.start();
		
		Producer p2=new Producer(stack);
		Thread producerT2=new Thread(p2);
		producerT2.start();
		
		Consumer c1=new Consumer(stack);
		Thread consumerT=new Thread(c1);
		consumerT.start();
		
		Consumer c2=new Consumer(stack);
		Thread consumerT2=new Thread(c2);
		consumerT2.start();
		
		
		
	}

}

class Consumer implements Runnable{
	private SynStack theStack;
	private int num;
	private static int counter=1;
	public Consumer(SynStack s){
		this.theStack=s;
		num=counter++;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		char c;
		for(int i=0;i<20;i++){
			c=theStack.pop();
			System.out.println("Consumer------>"+num+":"+c);
			try {
				Thread.sleep((int)(Math.random()*300));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Producer implements Runnable{
	private SynStack theStack;
	private int num;
	private static int counter=1;
	public Producer(SynStack s){
		this.theStack=s;
		num=counter++;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		char c;
		for(int i=0;i<20;i++){
			c=(char)(Math.random()*26+'A');
			theStack.push(c);
			System.out.println("Producer------>"+num+":"+c);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class SynStack{
	private List buffer=new ArrayList();
	public synchronized char pop(){
		char c;
		while(buffer.size()==0){
			try {
				System.out.println("now wait thread is--->"+Thread.currentThread().getName());
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		c=((Character)buffer.get(buffer.size()-1)).charValue();
		buffer.remove(buffer.size()-1);
		return c;
	}
	
	public synchronized void push(char c){
		this.notify();
		Character charObj=new Character(c);
		buffer.add(charObj);
	}
}
