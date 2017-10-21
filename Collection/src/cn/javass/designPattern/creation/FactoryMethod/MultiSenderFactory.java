package cn.javass.designPattern.creation.FactoryMethod;

public class MultiSenderFactory {
	public static Sender produceEmailSender(){
		return new emailSenderImpl();
	}
	
	public static Sender produceSmsSender(){
		return new smsSenderImpl();
	}
}
