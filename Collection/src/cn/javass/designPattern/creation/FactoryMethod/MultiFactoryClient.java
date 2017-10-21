package cn.javass.designPattern.creation.FactoryMethod;

public class MultiFactoryClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sender sender=MultiSenderFactory.produceEmailSender();
		sender.send();
	}

}
