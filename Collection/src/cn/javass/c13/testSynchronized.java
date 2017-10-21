package cn.javass.c13;

public class testSynchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyStack{
	int idx=0;
	char[] data=new char[6];
	
	public void push(char c){
		synchronized(this){
			data[idx]=c;
			idx++;
		}
	}
	
	public synchronized char pop(){
		idx--;
		return data[idx];
	}
}
