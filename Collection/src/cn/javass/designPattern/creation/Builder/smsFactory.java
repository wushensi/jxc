package cn.javass.designPattern.creation.Builder;

public class smsFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new smsSender();
	}

}
