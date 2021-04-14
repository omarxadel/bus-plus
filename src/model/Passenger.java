package model;

public class Passenger extends Users {
	
		public Passenger(String fname, String lname, String uname, String pw, int ID, String city, String country, String gender) {
			Passenger.super.setFirstname(fname);
			Passenger.super.setLastname(lname);
			Passenger.super.setUsername(uname);
			Passenger.super.setPassword(pw);
			Passenger.super.setID(ID);
			Passenger.super.setCity(city);
			Passenger.super.setCountry(country);
			Passenger.super.setGender(gender);
		}
}
