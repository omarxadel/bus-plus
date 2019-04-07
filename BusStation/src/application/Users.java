package application;

public abstract class Users {
	String username;
	private String password;
	String firstname;
	String lastname;
	String city;
	String country;
	String job;
	String gender;
	int ID;
	
	String getPassword() {
		return password;
	}
	
	void setPassword(String password) {
		this.password=password;
	}
}
