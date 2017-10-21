package cn.javass.c16.Factory;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//可以改造，从配置文件中读取1，或者2的值，动态创建对象
		Api api=Factory.createApi(1);
		api.method();
	}

}
