package application;
import java.util.*;

public class Trip {
	String start;
	String destination;
	String driverName;
	String date;
	float ticket;
	Vehicle vehicle;
	Seat seat;
	
	public Trip(String s, String d, Vehicle v, String dr, String da, String S) {
		start = s;
		destination = d;
		vehicle = v;
		driverName = dr;
		date =  da;
		seat = new Seat(S);
	}
}
