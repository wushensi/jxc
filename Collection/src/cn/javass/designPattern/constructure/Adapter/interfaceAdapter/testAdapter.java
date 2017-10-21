package cn.javass.designPattern.constructure.Adapter.interfaceAdapter;

public class testAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sourceable wrapper1=new SourceSub1();
		Sourceable wrapper2=new SourceSub2();
		wrapper1.method1();
		wrapper2.method2();
	}

}
