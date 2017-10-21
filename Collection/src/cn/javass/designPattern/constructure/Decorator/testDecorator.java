package cn.javass.designPattern.constructure.Decorator;

public class testDecorator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sourceable source = new Source();
		Sourceable sourceable=new Decorator(source);
		sourceable.method();
	}

}
