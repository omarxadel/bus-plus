package application;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.ParseException;

public class Database {
	private Formatter x;
	private FileWriter f, fr;
	Scanner i, inp;
	Manager[] M;
	Driver [] D;
	Passenger [] P;
	Trip [] T;
	Seat [] S;
	Vehicle vehicle;
	
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
			String gender = i.next();
			M[J] = new Manager (fname, lname, uname, pword, ID, city, country, job, gender);
			J++;
			//System.out.println(M[J-1].username);
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
			String gender = i.next();
			P[J] = new Passenger (fname, lname, uname, pword, ID, city, country, gender);
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
		S = new Seat [100];
		
		while(i.hasNext()) {
			m = i.nextInt();
			//System.out.println(m);
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
			int ID = i.nextInt();
			String start = i.next();
			String dest = i.next();
			String vehicle = i.next();
			int vnum = i.nextInt();
			String driver = i.next();
			String date = i.next();
			String time = i.next();
			float ticket = i.nextFloat();
			Seat seat = S[J];
			T[J] = new Trip (ID, start, dest, vehicle, vnum, driver, date, time, ticket, seat);
			//System.out.println(T[J].ID);
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
	
	public Passenger addPassengerData(String fname, String lname, String uname, String pw, String city, String country, String gender) throws IOException{
			try {
				f = new FileWriter("PassengerData.txt", true);
			} catch (IOException e) {
				e.printStackTrace();
			}

		int ID = 5544;
		int i=0;
		while(P[i]!=null) {
			if(P[i].ID == ID){
				ID++;
				i++;
				continue;
			}
			else { 
				break;
			}
		}
		f.write("\r\n" + fname + " " + lname + " " + uname + " " + pw + " " + ID + " " + city + " " + country + " " + gender);
		Passenger p = new Passenger(fname, lname, uname, pw, ID, city, country, gender);
		f.close();
		return p;
	}
	
	public Trip addTripData(String start, String dest, String vehicle, String vnum, String drivername, String date, String time, String ticketprice) throws IOException{
		int ID=0;
		switch(start) {
			case "District1":
				ID = 105000;
				break;
			case "District2":
				ID = 115000;
				break;
			case "District3":
				ID = 125000;
				break;
			case "District4":
				ID = 135000;
				break;
			case "District5":
				ID = 145000;
				break;
			case "District6":
				ID = 155000;
				break;
			case "District7":
				ID = 165000;
				break;
			case "District8":
				ID = 175000;
				break;
			case "District9":
				ID = 185000;
				break;
			case "District10":
				ID = 195000;
				break;
		}
		int j=0;
		while(T[j]!= null) {
			if(T[j].ID == ID) {
				ID++;
				j++;
				continue;
			}
		}
		try {
			f = new FileWriter("TripsData.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	f.write("\r\n" + start + " " + dest + " " + vehicle + " " + vnum + " " + drivername + " " + date + " " + ticketprice);
	float tp = Float.parseFloat(ticketprice);
	int num = Integer.parseInt(vnum);
	this.vehicle = new Vehicle(vehicle);
	Trip t = new Trip(ID, start, dest, vehicle, num, drivername, date, time, tp, this.vehicle.getSeats());
	f.close();
	
	try {
		fr = new FileWriter("Seats.txt", true);
	} catch (IOException e) {
		e.printStackTrace();
	}	
	
	int cap = this.vehicle.getCap();
	System.out.println(cap);
	fr.write("\r\n" + cap);
	while(cap!=0) {
		fr.write(" 0");
		cap--;
	}
	fr.close();
	return t;
}

	public void saveTripData() throws IOException {
		String ID, start, dest, vehicle, vnum, drivername, date, time, ticketprice;
		int i=0;
		try {	
				
				x = new Formatter("TripsData.txt");
				fr = new FileWriter("TripsData.txt", true);
				inp = new Scanner(new File("TripsData.txt"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
		while(T[i] != null) {
			ID = Integer.toString(T[i].ID);
			start = T[i].start;
			dest = T[i].destination;
			vehicle = T[i].vmodel;
			vnum = Integer.toString(T[i].vnum);
			drivername = T[i].driverName;
			date = T[i].date;
			time = T[i].time;
			ticketprice = Float.toString(T[i].ticket);
			if(!inp.hasNext()) {
				x.format(ID + " " + start + " " + dest + " " + vehicle + " " + vnum + " " + drivername + " " + date + " " + time + " "+ ticketprice);
			}
			else fr.write("\r\n" + ID + " " + start + " " + dest + " " + vehicle + " " + vnum + " " + drivername + " " + date + " " + time + " "+ ticketprice);
			i++;
		}
		fr.close();
	
	try {
		x = new Formatter("Seats.txt");
		fr = new FileWriter("Seats.txt", true);
		inp = new Scanner(new File("Seats.txt"));
	} catch (IOException e) {
		e.printStackTrace();
	}	
	
	int row, col;
	i = 0;
		while(T[i] != null) {
			if(inp.hasNext())fr.write("\r\n" + T[i].vehicle.s.capacity);
			row = T[i].seat.seat.length;
			col = T[i].seat.seat[i].length;
			for(int iterator = 0; iterator < row ; iterator++) {
				for(int iterator2 = 0; iterator2 < col ; iterator2 ++) {
						if(T[i].seat.seat[iterator][iterator2]) fr.write(" 1");
						else fr.write(" 0");					
				}
			}
			i++;
		}
	fr.close();
	}
	public Trip[] getTrips() {
		return T;
	}
	
	public void cancelTrip(int index) throws IOException {
		int i = index;
		while(T[i+1] != null) {
			T[i] = T[i+1];
			i++;
		}
		T[i] = null;
		saveTripData();
	}
	
}
  