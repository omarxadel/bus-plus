package model;

public class Ticket {
	Trip T;
	String uname;
	int serial;
	String seat;
	float price ;
	int ID;
	String payment;
	public Ticket (Trip T,String uname,int serial,String seat,float price, String payment)
	{
	    this.T = T;
		this.uname=uname;
		this.serial=serial;
		this.seat=seat;
		this.price=price;
		this.payment = payment;
	}
	
	public float CalculatePrice ()
	{
	
		return price;
		
	}

}
