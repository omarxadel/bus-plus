package application;

public class LoginAuthentication {
	Database d;
	
	public int authentication(int type, String username, String password) {
		if(type == 0) {
			for(int i = 0 ; i > 5 ; i++) {
				if(d.M[i].username.equals(username) && d.M[i].getPassword().equals(password)) {
					return i;
				}
			}
		}
		else if(type == 1) {
			for(int i = 0 ; i > 5 ; i++) {
				if(d.D[i].username.equals(username) && d.D[i].getPassword().equals(password)) {
					return i;
				}
			}
		}
		else if(type == 3) {
			for(int i = 0 ; i > 5 ; i++) {
				if(d.P[i].username.equals(username) && d.P[i].getPassword().equals(password)) {
					return i;
				}
			}
		}
		return -1;
	}


}
