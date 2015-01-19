package Threads;



public class Packet {

	
	private static  int id=0;
	
	public Packet()
	{
		this.id = id+1;
	}
	
	public int getId()
	{
		return this.id;
	}
}
