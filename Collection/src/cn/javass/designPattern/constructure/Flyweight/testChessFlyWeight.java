package cn.javass.designPattern.constructure.Flyweight;

public class testChessFlyWeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessFlyWeightFactory factory=new ChessFlyWeightFactory();
		ChessFlyWeight flyWeight1=factory.getChess("red");
		ChessFlyWeight flyWeight2=factory.getChess("red");
		System.out.println(flyWeight1);
		System.out.println(flyWeight2);
	}

}
