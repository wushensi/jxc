package cn.javass.c16.Singleton;

//加载机制角度

//线程安全角度


public class AA {
	//1 收回new AA（）权限
	private AA(){
		
	}
	// static 变量在生命周期中只会创建一个地址空间
	private static AA aa=new AA();
	//2 主动给外部调用提供自己的实例
	public AA getInstance(){
		
		return aa;
	}
}
