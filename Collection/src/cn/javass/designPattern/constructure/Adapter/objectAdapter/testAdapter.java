package cn.javass.designPattern.constructure.Adapter.objectAdapter;

public class testAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Source source=new Source();
		Targetable target=new Adapter(source);
		target.method1();
		target.method2();
	}

}
