package application;

public class LoginAuthentication {
	Database d = new Database();
	
	public int authenticateAdmin(String username, String password) {
		int i = 0;
			while(d.M[i]!=null) {
				if(d.M[i].username.equals(username) && d.M[i].getPassword().equals(password)) {
					System.out.println(i);
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
			if(d.D[i].username.equals(username) && d.D[i].getPassword().equals(password)) {
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
			System.out.println(d.P[i].username);
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
	
	public Manager getManager(int index) {
		return d.M[index];
	}
	public Driver getDriver(int index) {
		return d.D[index];
	}
	public Passenger getPassenger(int index) {
		return d.P[index];
	}
}