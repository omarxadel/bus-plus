package application;

public class Ticket {
	Trip T;
	String uname;
	int serial;
	String seat;
	float price ;
	int ID;
	public Ticket (Trip T,String uname,int serial,String seat,float price)
	{
	    this.T = T;
		this.uname=uname;
		this.serial=serial;
		this.seat=seat;
		this.price=price;
	}
	
	public float CalculatePrice ()
	{
	
		return price;
		
	}

}
