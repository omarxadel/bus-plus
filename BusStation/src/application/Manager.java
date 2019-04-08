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
	

	public Trip addTrip(String s, String d, String v, String dr, String da, Seat S) {
		Trip trip = new Trip(s, d, v,   dr, da, S);
	}
	public Trip createTrip(String s, String d, String v, int vnum, String dr, String da, float ticket) {
		Seat S = new Seat(v);
		Trip trip = new Trip(s, d, v, vnum, dr, da, ticket, S);

		return trip;
		
	}
}
