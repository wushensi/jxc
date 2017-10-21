package cn.javass.designPattern.constructure.Facade;

public class Computer {
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer(){
		this.cpu=new CPU();
		this.memory=new Memory();
		this.disk=new Disk();
	}
	
	public void startup(){
		System.out.println("Computer is startup------");
		this.cpu.startup();
		this.memory.startup();
		this.disk.startup();
	}
	
	public void shutdown(){
		System.out.println("Computer is shutdown------");
		this.disk.shutdown();
		this.memory.shutdown();
		this.cpu.shutdown();
		
	}

}
