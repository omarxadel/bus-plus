package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Trip {
	String start;
	String destination;
	String driverName;
	Date date;
	float ticket;
	Vehicle vehicle;
	Seat seat;
	
	public Trip(String start, String dest, String vehicle, String driver, String date, Seat seat){
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		
		this.start = start;
		destination = dest;
		this.vehicle = new Vehicle(vehicle);
		driverName = driver;
		this.seat = seat;
		try {
			this.date =  ft.parse(date);
			System.out.printf("%d",this.date);
		} catch (ParseException e) {
			System.out.println("Cannot parse" + ft);
			e.printStackTrace();
		}
	}
}
