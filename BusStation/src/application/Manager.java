package application;
import java.util.*;

public class Manager extends Users {
	public Trip addTrip(String s, String f, String v, Date d) {
		Trip trip = new Trip();
		trip.start = s;
		trip.destination = f;
		trip.vehicle = v;
		trip.date = d;
		return trip;
	}
}
