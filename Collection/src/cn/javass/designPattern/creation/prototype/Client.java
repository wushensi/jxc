package cn.javass.designPattern.creation.prototype;

public class Client {

	/**
	 * @param args
	 */
	
	//原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类
	//似的新对象。本小结会通过对象的复制，进行讲解。在Java中，复制对象是通过clone()实现的，先创建一个原型类：
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		UserModel um=new UserModel();
		Prototype p=new Prototype();
		Prototype p1=new Prototype();
		um.setAge(27);
		um.setUuid("1");
		um.setUname("user");
		p.setObj(um);
		p.setStr("helloworld");
		
		p1=(Prototype) p.deepClone();
		System.out.println(p1.getStr()+"------"+p1.getObj());
		
		
		
	}

}
