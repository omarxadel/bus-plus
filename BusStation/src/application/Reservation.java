package application;

public class Reservation {
	static Locations locations = new Locations();
	static Database d = new Database();
	
	public Ticket makeReservation(Trip T, String passenger, String seat) {
		Ticket new_Ticket = new Ticket(T, passenger, getSerial(), seat, locations.getPrice(T.start, T.destination));
		return new_Ticket;
	}
	
	private int getSerial() {
		int serial = 225000 , i = 0 ;
		while(d.Tk[i] != null) {
			if(d.Tk[i].serial == serial) {
				serial++;
				i++;
				continue;
			}
			else {
				i++;
				continue;
			}
		}
		return serial;
	}

}
