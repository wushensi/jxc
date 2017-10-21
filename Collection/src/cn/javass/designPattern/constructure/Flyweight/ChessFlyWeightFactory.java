package cn.javass.designPattern.constructure.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFlyWeightFactory {
	//ÏíÔª³Ø
	
	private static Map<String,ChessFlyWeight> map=new HashMap<String,ChessFlyWeight>();
	
	public ChessFlyWeight getChess(String color){
		if(map.get(color)!=null){
			return map.get(color);
		}else{
			ChessFlyWeight cfw=new ConcreteChessFlyWeight(color);
			map.put(color, cfw);
			return cfw;
		}
	}
}
