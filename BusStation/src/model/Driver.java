package model;
import java.util.*;

public class Driver extends Users {
	private float credit;

	public Driver(String firstname, String lastname, String username, String pw, int ID, String city, String country, String job) {
		Driver.super.setFirstname(firstname);
		Driver.super.setLastname(lastname);
		Driver.super.setUsername(username);
		Driver.super.setPassword(pw);
		Driver.super.setID(ID);
		Driver.super.setCity(city);
		Driver.super.setCountry(country);
		Driver.super.setJob(job);
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}
}
