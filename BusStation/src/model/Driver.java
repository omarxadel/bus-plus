package model;
import java.util.*;

public class Driver extends Users {
	private HashMap<Integer, Trip> trip;
	private float credit;
	//private float salary;
	
	public Driver(String firstname, String lastname, String username, String pw, int ID, String city, String country, String job) {
		Driver.super.setFirstname(firstname);
		Driver.super.setLastname(lastname);
		Driver.super.setUsername(username);
		Driver.super.setPassword(pw);
		Driver.super.setID(ID);
		Driver.super.setCity(city);
		Driver.super.setCountry(country);
		Driver.super.setJob(job);
		trip = new HashMap<>();
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public HashMap<Integer, Trip> getTrip() {
		return trip;
	}

	public void setTrip(HashMap<Integer, Trip> trip){
		this.trip = trip;
	}
	
	
}
