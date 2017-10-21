package cn.javass.designPattern.creation.AbstractFactory;

public class smsSenderFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new smsSender();
	}

}
