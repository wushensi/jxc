package cn.javass.designPattern.constructure.Bridge;

public abstract class Bridge implements Sourceable{
	private Sourceable source;

	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}
	
	@Override
	public void method(){
		source.method();
	}
	
	
}
