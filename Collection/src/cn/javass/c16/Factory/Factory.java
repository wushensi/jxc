package cn.javass.c16.Factory;

public class Factory {
	public static Api createApi(int type){
		
		if(type==1){
			return new ApiImpl1();
		}
		if(type==2){
			return new ApiImpl2();
		}
		
		return null;
		
	}
}
