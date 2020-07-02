package model;

public class Admin extends Users {
	public Admin(String fname, String lname, String uname, String pw, int ID, String city, String country, String j, String gender) {
		Admin.super.firstname = fname;
		Admin.super.lastname = lname;
		Admin.super.username = uname;
		Admin.super.setPassword(pw);
		Admin.super.ID = ID;
		Admin.super.city = city;
		Admin.super.country = country;
		Admin.super.job = j;
		Admin.super.gender = gender;
	}
	

}
