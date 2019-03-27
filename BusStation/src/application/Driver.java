package application;
import java.util.*;

public class Driver extends Users {
	HashMap<Integer, Trip> trip = new HashMap<>();
	
	public Driver(String fname, String lname, String uname, String pw, int ID) {
		Driver.super.firstname = fname;
		Driver.super.lastname = lname;
		Driver.super.username = uname;
		Driver.super.setPassword(pw);
		Driver.super.ID = ID;
	}
	
	public void setAddress(String city, String country) {
		Driver.super.city = city;
		Driver.super.country = country;
	}

	public void setCity(String city) {
		Driver.super.city = city;
	}
	
	public void setCountry(String country) {
		Driver.super.country = country;
	}
	
	
	
}
