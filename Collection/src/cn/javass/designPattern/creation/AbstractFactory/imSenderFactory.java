package cn.javass.designPattern.creation.AbstractFactory;

public class imSenderFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new imSender();
	}

}
