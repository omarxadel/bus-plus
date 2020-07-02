package model;

public class Admin extends Users {
	public Admin(String firstname, String lastname, String username, String pw, int ID, String city, String country, String gender) {
		Admin.super.setFirstname(firstname);
		Admin.super.setLastname(lastname);
		Admin.super.setUsername(username);
		Admin.super.setPassword(pw);
		Admin.super.setID(ID);
		Admin.super.setCity(city);
		Admin.super.setCountry(country);
		Admin.super.setGender(gender);
	}
}
