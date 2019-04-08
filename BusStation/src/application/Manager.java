package application;

public class Manager extends Users {
	public Manager(String fname, String lname, String uname, String pw, int ID, String city, String country, String j, String gender) {
		Manager.super.firstname = fname;
		Manager.super.lastname = lname;
		Manager.super.username = uname;
		Manager.super.setPassword(pw);
		Manager.super.ID = ID;
		Manager.super.city = city;
		Manager.super.country = country;
		Manager.super.job = j;
		Manager.super.gender = gender;
	}
	

	public Trip createTrip(String start, String destination, String vehicle, int vnum, String dr, String da, float ticket) {
		Seat S = new Seat(vehicle);
		Trip trip = new Trip(start, destination, vehicle, vnum, dr, da, ticket, S);

		return trip;
		
	}
}
