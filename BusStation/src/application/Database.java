package application;
import java.io.*;
import java.util.*;

public class Database {
	private Formatter x;
	private FileWriter f, fr;
	Scanner i, inp;
	Manager[] M;
	Driver [] D;
	Passenger [] P;
	Trip [] T;
	Ticket [] Tk;
	Seat [] S;
	Vehicle vehicle;
	
	public Database() {
		getManagerData();
		getDriverData();
		getPassengerData();
		getSeats();
		getTripData();
		getTicketData();
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
				k++;
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
				k++;
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
				k++;
				continue;
			}
			else if (m == 3) {
				S[k] = new Seat("Limo");
				for(int row = 0 ; row < 1 ; row++) {
				for(int col = 0 ; col < 3; col++) {
					S[k].bookAllSeats();
				}
				
			}
				k++;
				continue;
			}
			else {
				break;
			}
		}
		
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
			String type = i.next();
			String start = i.next();
			String dest = i.next();
			String vehicle = i.next();
		    int vnum=i.nextInt();
			String driver = i.next();
			String date = i.next();
			String time = i.next();
			float ticket = i.nextFloat();
			Seat seat = S[J];
			T[J] = new Trip (ID, type, start, dest, vehicle, vnum, driver, date, time, ticket, seat);
			J++;
		}


		
	}
	
	public void getTicketData() {
		try{
			i = new Scanner(new File("Ticket.txt"));
			}
			catch(Exception e) {	
				try {
					x = new Formatter("Ticket.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		
		int J = 0, iterator = 0;
		Tk = new  Ticket [200];
		Trip thisTrip = null;
		while(i.hasNext()) {
			int ID_trip = i.nextInt();
			String uname = i.next();
			int serial = i.nextInt();
			String seat = i.next();
			float price = i.nextFloat();
			while(T[iterator] != null) {
				if(ID_trip == T[iterator].ID) {
					thisTrip = T[iterator];
					break;
				}
				else iterator++;
			}
			if (thisTrip == null) {
				
			}
			else {
			Tk [J] = new Ticket (thisTrip, uname, serial, seat, price);
			J++;
			}
		}
	
	}
	
	public Manager addManagerData(String fname, String lname, String uname, String pw, String city, String country, String gender) throws IOException{
		try {
			f = new FileWriter("ManagersData.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	int ID = 300;
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
	Manager m = new Manager(fname, lname, uname, pw, ID, city, country, gender, "Manager");
	f.close();
	return m;
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
	
	public Trip addTripData(String type, String start, String dest, String vehicle, String vnum, String drivername, String date, String time, String ticketprice) throws IOException{
		int ID=0;
		System.out.println(start + dest + vehicle + vnum + drivername + date + time + ticketprice);
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
			}
			else {
				j++;
				continue;
			}
		}
		try {
			f = new FileWriter("TripsData.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	f.write("\r\n" + ID + " " + type + " " + start + " " + dest + " " + vehicle + " " + vnum + " " + drivername + " " + date + " " + time + " " + ticketprice);
	float tp = Float.parseFloat(ticketprice);
	int num = Integer.parseInt(vnum);
	this.vehicle = new Vehicle(vehicle);
	Trip t = new Trip(ID, type, start, dest, vehicle, num, drivername, date, time, tp, this.vehicle.getSeats());
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
	getTripData();
	return t;
}
	
	
	public Driver addDriver(String fname, String lname, String uname, String pw, String city, String country) throws IOException {
	    int ID=5500;			
		int j=0;
		while(D[j]!= null) {
			if(D[j].ID == ID) {
				ID++;
				j++;
			}
			else {
				j++;
				continue;
			}
		}
		try {
			f = new FileWriter("DriversData.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	f.write("\r\n" + fname + " " + lname + " " + uname + " " + pw + " " + Integer.toString(ID) + " " + city + " " + country + " " + "Driver");
	Driver new_D = new Driver(fname, lname, uname, pw, ID, city, country, "Driver");
	f.close();
	getDriverData();
	return new_D;
	}

	public Ticket addTicket(Trip currentT, String uname, int serial, String seat, float price) throws IOException {
		fr = new FileWriter("Ticket.txt", true);
		inp = new Scanner("Ticket.txt");
		
		Ticket newTicket = new Ticket (currentT, uname, serial, seat, price);
		if(inp.hasNext()) {
			fr.write("\r\n" + currentT.ID + " " + uname + " " + serial + " " + seat + " " + price);
		}
		else fr.write("" + currentT.ID + " " + uname + " " + serial + " " + seat + " " + price);
			fr.close();
		getTicketData();
		return newTicket;
	}
	
	public void saveTicketData() {
		
	}
	

	public void saveTripData() throws IOException {
		String ID, type, start, dest, vehicle, vnum, drivername, date, time, ticketprice;
		int i=1;
		try {	
				fr = new FileWriter("TripsData.txt", false);
				inp = new Scanner(new File("TripsData.txt"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
		ID = Integer.toString(T[0].ID);
		type = T[0].type;
		start = T[0].start;
		dest = T[0].destination;
		vehicle = T[0].vmodel;
		vnum = Integer.toString(T[0].vnum);
		drivername = T[0].driverName;
		date = T[0].date;
		time = T[0].time;
		ticketprice = Float.toString(T[0].ticket);
		fr.write(ID + " " + type + " " + start + " " + dest + " " + vehicle + " " + vnum + " " + drivername + " " + date + " " + time + " "+ ticketprice);
		while(T[i] != null) {
			ID = Integer.toString(T[i].ID);
			type = T[i].type;
			start = T[i].start;
			dest = T[i].destination;
			vehicle = T[i].vmodel;
			vnum = Integer.toString(T[i].vnum);
			drivername = T[i].driverName;
			date = T[i].date;
			time = T[i].time;
			ticketprice = Float.toString(T[i].ticket);
			fr.write("\r\n" + ID + " " + type + " " + start + " " + dest + " " + vehicle + " " + vnum + " " + drivername + " " + date + " " + time + " "+ ticketprice);
			i++;
		}
		fr.close();
	
	try {
		fr = new FileWriter("Seats.txt", false);
		inp = new Scanner(new File("Seats.txt"));
	} catch (IOException e) {
		e.printStackTrace();
	}	
	int row, col;
	i=1;
	fr.write("" + T[0].seat.capacity);
	//System.out.println(T[0].seat.capacity);
	row = T[0].seat.seat.length;
	col = T[0].seat.seat[0].length;
	for(int iterator = 0; iterator < row ; iterator++) {
		for(int iterator2 = 0; iterator2 < col ; iterator2 ++) {
				if(T[0].seat.seat[iterator][iterator2]) fr.write(" 1");
				else fr.write(" 0");					
		}
	}
		while(T[i] != null) {
			fr.write("\r\n" + T[i].vehicle.s.capacity);
			System.out.println(T[i].seat.capacity);
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
			System.out.println(i);
		}
		T[i] = null;
		saveTripData();
	}
		public void saveDriversData() throws IOException {
		
			String ID;
			int i=1;
			try {	
					fr = new FileWriter("DriversData.txt", false);
					inp = new Scanner(new File("DriversData.txt"));
			} 
			catch (IOException e) {
				e.printStackTrace();
			}	
			ID = Integer.toString(D[0].ID);
			fr.write(""+ D[0].firstname + " " + D[0].lastname + " "+ D[0].username + " " + D[0].getPassword() + " " + ID + " " + D[0].city + " " + D[0].country + " " + D[0].job);
			while(D[i] != null) {
				ID = Integer.toString(D[i].ID);
				fr.write("\r\n"+ D[i].firstname + " " + D[i].lastname + " " + D[i].getPassword() + " " + ID + " " + D[i].city + " " + D[i].country + " " + D[i].job);
				i++;
			}
			fr.close();
		}
		
		public void saveManagerData() throws IOException {
			String ID;
			int i=1;
			try {	
					fr = new FileWriter("ManagersData.txt", false);
					inp = new Scanner(new File("ManagersData.txt"));
			} 
			catch (IOException e) {
				e.printStackTrace();
			}	
			ID = Integer.toString(M[0].ID);
			fr.write(""+ M[0].firstname + " " + M[0].lastname + " "+ M[0].username + " " + M[0].getPassword() + " " + ID + " " + M[0].city + " " + M[0].country + " " + M[0].job);
			while(M[i] != null) {
				ID = Integer.toString(M[i].ID);
				fr.write("\r\n"+ M[i].firstname + " " + M[i].lastname + " " + M[i].getPassword() + " " + ID + " " + M[i].city + " " + M[i].country + " " + M[i].job);
				i++;
			}
			fr.close();
		}
	
		
	public void removeDriver(int index) throws IOException {
		int i = index;
		System.out.println(i);
		while(D[i+1] != null) {
			D[i] = D[i+1];
			i++;
		}
		D[i] = null;
		System.out.println(i);
		saveDriversData();
	}
	
}
  