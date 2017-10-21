package cn.javass.designPattern.constructure.Proxy;

public class Proxy implements Sourceable{

	private Sourceable source;
	
	public Proxy(){
		source=new Source();
	}
	
	public void proxyMethodA(){
		System.out.println("this is proxyMethodA ---before");
	}
	
	public void proxyMethodB(){
		System.out.println("this is proxyMethodB ---after");
	}
	
	@Override
	public void method() {
		// TODO Auto-generated method stub
		this.proxyMethodA();
		source.method();
		this.proxyMethodB();
	}

}
