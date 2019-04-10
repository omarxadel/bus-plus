package application;
import java.util.*;

public class Driver extends Users {
	HashMap<Integer, Trip> trip = new HashMap<>();
	private float credit;
	String salary;
	
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
	
	
}
