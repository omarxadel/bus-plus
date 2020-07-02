package model;
import java.util.*;

public class Driver extends Users {
	//private HashMap<Integer, Trip> trip = new HashMap<>();
	private float credit;
	//private float salary;
	
	public Driver(String fname, String lname, String uname, String pw, int ID, String city, String country, String job) {
		Driver.super.setFirstname(fname);
		Driver.super.setLastname(lname);
		Driver.super.setUsername (uname) ;
		Driver.super.setPassword(pw);
		Driver.super.setID (ID);
		Driver.super.setCity (city) ;
		Driver.super.setCountry (country) ;
		Driver.super.setJob (job) ;

	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {

		this.credit = credit;
	}

	public HashMap<Integer , Trip> getTrip () {
		return trip;
	}

	public void setTrip(HashMap<Intege , Trip>){
		this.trip=trip;
	}
	
	
}
