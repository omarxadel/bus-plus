package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Trip {
	int ID;
	String start;
	StringProperty start1 = new SimpleStringProperty();
	String destination;
	String driverName;
	String date;
	String time;
	float ticket;
	Vehicle vehicle;
	int vnum;
	String vmodel;
	Seat seat;
	

	public Trip(int ID, String start, String dest, String vehicle, int vnum , String driver, String date, String time, float ticket, Seat seat){
		
		this.ID = ID;
		this.start = start;
		destination = dest;
		this.vehicle = new Vehicle(vehicle);
		this.vehicle.num = vnum;
		driverName = driver;
		this.ticket = ticket;
		this.seat = seat;
		this.date = date;
		this.time = time;
		}
	public Trip(String s) {
		this.start1.set(s);
	}
	
	}

