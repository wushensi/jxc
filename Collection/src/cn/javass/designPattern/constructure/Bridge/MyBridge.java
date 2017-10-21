package cn.javass.designPattern.constructure.Bridge;

public class MyBridge extends Bridge{
	@Override
	public void method(){
		this.getSource().method();
	}
}
