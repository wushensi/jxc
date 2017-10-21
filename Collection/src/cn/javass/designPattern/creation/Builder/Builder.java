package cn.javass.designPattern.creation.Builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	private List<Sender> list=new ArrayList<Sender>();
	
	public void produceEmailSender(int count){
		for(int i=0;i<count;i++){
			list.add(new emailSender());
		}
	}
	
	public void produceSmeSender(int count){
		for(int i=0;i<count;i++){
			list.add(new smsSender());
		}
	}

	public List<Sender> getList() {
		return list;
	}
	
	
}
