package application;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.ParseException;

public class Database {
	private Formatter x;
	Scanner i;
	Manager[] M;
	Driver [] D;
	Passenger [] P;
	Trip [] T;
	Seat [] S;
	
	public Database() {
		getManagerData();
		getDriverData();
		getPassengerData();
		getSeats();
		getTripData();
	}
	
	public void getManagerData() {
		
		try{
		i = new Scanner(new File("ManagersData.txt"));
		}
		catch(Exception e) {
		try {
			x = new Formatter("ManagersData.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		}
		M = new  Manager [5];
		int J = 0;
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			String job = i.next();
			M[J] = new Manager (fname, lname, uname, pword, ID, city, country, job);
			J++;
			System.out.println(M[J-1].username);
		}
	}
	
	
	public void getPassengerData() {
		try{
			i = new Scanner(new File("PassengerData.txt"));
			}
			catch(Exception e) {	
				try {
					x = new Formatter("PassengerData.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		
		int J=0;
		P = new  Passenger [25];
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			P[J] = new Passenger (fname, lname, uname, pword, ID, city, country);
			J++;
		}

	}
	

	public void getDriverData() {
		try{
			i = new Scanner(new File("DriversData.txt"));
			}
			catch(Exception e) {	
				try {
					x = new Formatter("DriversData.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		
		int J = 0;
		D = new  Driver [25];
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			String job = i.next();
			D[J] = new Driver (fname, lname, uname, pword, ID, city, country, job);
			
			J++;
		}

	}
	
	public void getSeats() {
		try{
			i = new Scanner(new File("Seats.txt"));
			}
			catch(Exception e) {	
				try {
					x = new Formatter("Seats.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		int[] J;
		int m, k=0, l=0;
		S = new  Seat [100];
		
		
		while(i.hasNext()) {
			m = i.nextInt();
			System.out.println(m);
			J = new int[m];
			for(int ind = 0 ; ind < m ; ind++) {
				J[ind]=i.nextInt();
			}
			if(m == 48) {
				l=0;
				S[k] = new Seat("Bus");
				for(int row = 0 ; row < 4 ; row++) {
					for(int col = 0 ; col  < 12 ; col++ )
						if(l<m) {
							if(J[l] == 1) S[k].bookSeat(row, col);
							l++;
						}
				}
				continue;
			}
			else if(m == 36) {
				l=0;
				S[k] = new Seat("Midbus");
				for(int row = 0 ; row < 4 ; row++) {
					for(int col = 0 ; col < 9; col++) {
						if(l<m) {
						if(J[l] == 1) S[k].bookSeat(row, col);
						l++;
						}
					}
				}
				continue;
			}
			else if(m == 12) {
				l=0;
				S[k] = new Seat("Minibus");
				for(int row = 0 ; row < 3 ; row++) {
					for(int col = 0 ; col < 4; col++) {
						if(l<m) {
							if(J[l++] == 1) S[k].bookSeat(row, col);
						}
					}
				}	
				continue;
			}
			else if (m == 3) {
				S[k] = new Seat("Limo");
				for(int row = 0 ; row < 1 ; row++) {
				for(int col = 0 ; col < 3; col++) {
					S[k].bookAllSeats();
				}
			}	continue;
			}
			else {
				System.out.println("Error in files");
				break;
			}
		}
		k++;
	}
	
	public void getTripData() {
		try{
			i = new Scanner(new File("TripsData.txt"));
			}
			catch(Exception e) {	
				try {
					x = new Formatter("TripsData.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		
		int J = 0;
		T = new  Trip [100];
		while(i.hasNext()) {
			String start = i.next();
			String dest = i.next();
			String vehicle = i.next();
			int vnum = i.nextInt();
			String driver = i.next();
			String date = i.next();
			float ticket = i.nextFloat();
			Seat seat = S[J];
			try {
				T[J] = new Trip (start, dest, vehicle, vnum, driver, date, ticket, seat);
			} catch (Exception e) {
				
			}
			System.out.println(start);
			J++;
		}


		
	}
	
	
	public void addDriverData(String fname, String lname, String uname, String pw, int ID, String city, String country) {
		try {
			x = new Formatter("DriversData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.format("%s %s %s %s %d %s %s", fname, lname , uname, pw , ID, city, country , "Driver");
	}
	
	public void addManagerData(String fname, String lname, String uname, String pw, int ID, String city, String country) {
		try {
			x = new Formatter("ManagersData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.format("%s %s %s %s %d %s %s", fname, lname , uname, pw , ID, city, country , "Manager");
	}
	
	public void addPassengerData(String fname, String lname, String uname, String pw, int ID, String city, String country) {
		try {
			x = new Formatter("PassengerData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.format("%s %s %s %s %d %s %s", fname, lname , uname, pw , ID, city, country , "Driver");
	}
	
	public void closeFiles() {
		try {
			x = new Formatter("ManagersData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.close();
		try {
			x = new Formatter("DriversData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.close();
		try {
			x = new Formatter("PassengerData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		x.close();
	}
}
  