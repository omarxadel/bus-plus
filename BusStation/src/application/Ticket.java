package application;

public class Ticket {
	Trip T;
	Passenger P;
	String uname;
	int serial;
	String seat;
	float price ;
	int ID;
	public Ticket (int ID,String uname,int serial,String seat,float price)
	{
	    this.ID=ID;
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
