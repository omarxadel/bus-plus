package model;
import java.util.*;

public class Driver extends Users {
	private HashMap<Integer, Trip> trip = new HashMap<>();
	private float credit;
	//private float salary;
	
	public Driver(String fname, String lname, String uname, String pw, int ID, String city, String country, String job) {
		Driver.super.firstname = fname;
		Driver.super.lastname = lname;
		Driver.super.username = uname;
		Driver.super.setPassword(pw);
		Driver.super.ID = ID;
		Driver.super.city = city;
		Driver.super.country = country;
		Driver.super.job = job;
		
		
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {

		this.credit = credit;
	}

	public HashMap<Integer , Trip> getTrip {
		return trip;
	}

	public void setTrip(HashMap<Intege , Trip>){
		this.trip=trip;
	}
	
	
}
