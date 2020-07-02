package model;

import prevalent.Locations;

public class Reservation {
	static Locations locations = new Locations();
	static Database d = new Database();
	
	public Ticket makeReservation(Trip T, String passenger, int serial , String seat, String payment) {
		Ticket new_Ticket = new Ticket(T, passenger, serial, seat, T.ticket, payment);
		return new_Ticket;
	}
	
}
