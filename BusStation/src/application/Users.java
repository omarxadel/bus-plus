package application;

public abstract class Users {
	String username;
	private String password;
	String firstname;
	String lastname;
	String address;
	String city;
	String country;
	String job;
	int ID;
	
	String getPassword() {
		return password;
	}
	
	void setPassword(String password) {
		this.password=password;
	}
}
