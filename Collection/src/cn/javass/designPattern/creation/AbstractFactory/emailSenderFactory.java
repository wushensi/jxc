package cn.javass.designPattern.creation.AbstractFactory;

public class emailSenderFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new emailSender();
	}

}
