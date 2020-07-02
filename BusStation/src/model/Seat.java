package model;

import java.util.HashMap;

public class Seat {

	private HashMap<String, Boolean> seats;
	private int id;
	private int freeSeats;


	public Seat(int type){
		switch(type){
			case(1):
				freeSeats = 12;
				for(int i = 0 ; i < 12 ; i++) {
					if (i < 6) {
						seats.put(("A" + (i + 1)), false);
					} else {
						seats.put(("B" + (i + 1)), false);
					}
				}
				break;
			case(2):
				freeSeats = 36;
				for(int i = 0 ; i < 36 ; i++) {
					if (i < 18) {
						seats.put(("A" + (i + 1)), false);
					} else {
						seats.put(("B" + (i + 1)), false);
					}
				}
				break;
			case(3):
				freeSeats = 48;
				for(int i = 0 ; i < 48 ; i++) {
					if (i < 24) {
						seats.put(("A" + (i + 1)), false);
					} else {
						seats.put(("B" + (i + 1)), false);
					}
				}
				break;
		}
	}


	public HashMap<String, Boolean> getSeats() {
		return seats;
	}

	public void setSeats(HashMap<String, Boolean> seats) {
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}
	
	boolean isBooked(String seat) {
		return(seats.get(seat));
	}
	
	public boolean bookSeat(String seat) {
		if(isBooked(seat))
			return false;
		seats.replace(seat, true);
		freeSeats--;
		return true;
	}
	
	public void cancelBooking(String seat) {
		seats.replace(seat, false);
	}
	
	public void resetSeats() {
		for(String key : seats.keySet()){
			cancelBooking(key);
		}
	}
	
	public int getFreeSeats() {
		return freeSeats;
	}
	
	
	public String bookRandom() {
		if(freeSeats == 0){
			return null;
		}
		for(String key : seats.keySet()){
			if(!seats.get(key)){
				return key;
			}
			continue;
		}
		return null;
	}
	
}
