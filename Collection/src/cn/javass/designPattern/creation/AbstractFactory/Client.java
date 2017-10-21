package cn.javass.designPattern.creation.AbstractFactory;

public class Client {

	/**
	 * @param args
	 * 
	 * 其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口
	 * ，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provider provider=new imSenderFactory();//抽象工厂，emailSenderFactory指定具体的工厂实现
		Sender sender=provider.produce();//创建对象使用工厂方法produce
		sender.send();
	}

}
