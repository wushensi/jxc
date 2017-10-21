package cn.javass.designPattern.constructure.Bridge;

public class testBridge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bridge bridge=new MyBridge();
		

		bridge.setSource(new SourceSub1());
		
		bridge.method();

		bridge.setSource(new SourceSub2());
		
		bridge.method();
		
		bridge.setSource(new SourceSub3());
		
		bridge.method();
	}

}
