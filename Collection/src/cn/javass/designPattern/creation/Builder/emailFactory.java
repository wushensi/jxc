package cn.javass.designPattern.creation.Builder;

public class emailFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new emailSender();
	}

}
