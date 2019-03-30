package application;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Database {
	private Formatter x;
	Scanner i;
	Manager[] M;
	Driver [] D;
	
	public void openManagerFile() {
		try{
		i = new Scanner(new File("ManagersData.txt"));
		}
		catch(Exception e) {	
		}
	}	
	
	public void getManagerData() {
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			String job = i.next();
			int J = 0;
			M = new  Manager [5];
			M[J] = new Manager (fname, lname, uname, pword, ID, city, country, job);
			J++;
		}
	}
	
	public void openDriverFile() {
		try{
			i = new Scanner(new File("DriversData.txt"));
			}
			catch(Exception e) {	
			}
	}
	
	public void getDriverData() {
		while(i.hasNext()) {
			String fname = i.next();
			String lname = i.next();
			String uname = i.next();
			String pword = i.next();
			int ID = i.nextInt();
			String city = i.next();
			String country = i.next();
			String job = i.next();
			int J = 0;
			D = new  Driver [25];
			D[J] = new Driver (fname, lname, uname, pword, ID, city, country, job);
			J++;
		}

	}
	public void addData(String data) {
		x.format("%s", data);
	}
	
	
}
