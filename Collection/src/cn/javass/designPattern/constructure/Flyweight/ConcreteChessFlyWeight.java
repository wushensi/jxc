package cn.javass.designPattern.constructure.Flyweight;

public class ConcreteChessFlyWeight implements ChessFlyWeight{

	private String color;
	
	public ConcreteChessFlyWeight(String color){
		this.color=color;
	}
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(Coordinate c) {
		// TODO Auto-generated method stub
		System.out.println("棋子的颜色："+color);
		System.out.println("棋子的横坐标位置："+c.getX()+"棋子的纵坐标位置："+c.getY());
	}

	@Override
	public String toString() {
		return "ConcreteChessFlyWeight [color=" + color + "]";
	}

	

}
