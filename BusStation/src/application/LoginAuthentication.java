package application;

public class LoginAuthentication {
	static Database d = new Database();
	
	public int authenticateAdmin(String username, String password) {
		int i = 0;
			while(d.M[i]!=null) {
				if(d.M[i].username.equals(username) && d.M[i].getPassword().equals(password)) {
					return i;
				}
				else { 
					i++;
					continue;
				}
			}
			return -1;
		
	}
	public int authenticateDriver(String username, String password) {
		int i = 0;
		while(d.D[i]!=null) {
			if(d.D[i].username.equals(username) && d.D[i].getPassword().equals(password)){
				return i;
			}
			else { 
				i++;
				continue;
			}
		}
		return -1;
	}
	
	public int authenticatePassenger(String username, String password) {
		int i = 0;
		while(d.P[i]!=null) {
			if(d.P[i].username.equals(username) && d.P[i].getPassword().equals(password)) {
				return i;
			}
			else { 
				i++;
				continue;
			}
		}
		return -1;
	}
	
	public boolean userExist(String username) {
	
		int i=0;
		while(d.P[i]!=null) {
			if(d.P[i].username.equals(username)) {
				return true;
			}
			else { 
				i++;
				continue;
			}
		}
		return false;
}
	public Manager getManager(int index) {
		return d.M[index];
	}
	public Manager [] getManagers() {
		return d.M;
	}
	public Driver getDriver(int index) {
		return d.D[index];
	}
	public Driver [] getDrivers() {
		return d.D;
	}
	public Passenger getPassenger(int index) {
		return d.P[index];
	}

}