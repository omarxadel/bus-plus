package application;

public class Passenger extends Users {
	
		public Passenger(String fname, String lname, String uname, String pw, int ID, String city, String country) {
			Passenger.super.firstname = fname;
			Passenger.super.lastname = lname;
			Passenger.super.username = uname;
			Passenger.super.setPassword(pw);
			Passenger.super.ID = ID;
			Passenger.super.city = city;
			Passenger.super.country = country;
		}
}
