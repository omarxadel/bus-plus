package application;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Database {
	private Formatter x;
	Scanner i;
	Manager[] M;
	Driver [] D;
	Passenger [] P;
	
	public void getManagerData() {
		
		try{
		i = new Scanner(new File("ManagersData.txt"));
		}
		catch(Exception e) {	
		}
		
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
			M = new  Manager [5];
			M[J] = new Manager (fname, lname, uname, pword, ID, city, country, job);
			J++;
		}
	}
	
	
	public void getPassengerData() {
		try{
			i = new Scanner(new File("PassengerData.txt"));
			}
			catch(Exception e) {	
			}
		
		int J=0;
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			String job = i.next();
			D = new  Driver [25];
			D[J] = new Driver (fname, lname, uname, pword, ID, city, country, job);
			J++;
		}

	}
	

	public void getDriverData() {
		try{
			i = new Scanner(new File("DriversData.txt"));
			}
			catch(Exception e) {	
			}
		
		int J = 0;
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			P = new  Passenger [25];
			P[J] = new Passenger (fname, lname, uname, pword, ID, city, country);
			J++;
		}

	}
	
	public void getTripData() {
		
	}
	
	public void addDriverData(String fname, String lname, String uname, String pw, int ID, String city, String country) {
		try {
			x = new Formatter("DriversData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.format("%s %s %s %s %d %s %s", fname, lname , uname, pw , ID, city, country , "Driver");
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
		/*try {
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
		x.close();*/
	}
}
