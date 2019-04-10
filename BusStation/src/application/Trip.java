package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Trip {
	int ID;
	String type;
	String start;
	String destination;
	String driverName;
	String date;
	String time;
	float ticket;
	Vehicle vehicle;
	int vnum;
	String vmodel;
	Seat seat;
	

	public Trip(int ID, String type, String start, String dest, String vehicle, int vnum , String driver, String date, String time, float ticket, Seat seat){
		
		this.ID = ID;
		this.type = type;
		this.start = start;
		destination = dest;
		this.vehicle = new Vehicle(vehicle);
		vmodel = vehicle;
		this.vnum = vnum;
		this.vehicle.num = vnum;
		driverName = driver;
		this.ticket = ticket;
		this.seat = seat;
		this.date = date;
		this.time = time;
		}
	}

