package application;

public class Reservation {
	static Locations locations = new Locations();
	static Database d = new Database();
	
	public Ticket makeReservation(Trip T, String passenger, int serial , String seat, String payment) {
		Ticket new_Ticket = new Ticket(T, passenger, serial, seat, locations.getPrice(T.start, T.destination), payment);
		return new_Ticket;
	}
	
	/*private int getSerial() {
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
	}*/

}
