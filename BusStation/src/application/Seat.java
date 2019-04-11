package application;

public class Seat {
	boolean [][] seat;
	int capacity;
	String vtype;
	
	public Seat(String type) {
		if(type.equals("Bus")) {
			vtype = type;
			seat = new boolean [4][12];
			capacity = 48;
		}
		else if(type.equals("Midbus")) {
			vtype = type;
			seat = new boolean [4][9];
			capacity = 36;
		}
		else if(type.equals("Minibus")) {
			vtype = type;
			seat = new boolean [3][4];
			capacity = 12;
		}
		else if(type.equals("Limo")) {
			vtype=type;
			seat = new boolean [1][3];
			capacity = 3;
		}
	}
	
	boolean isBooked(int row, int col) {
		return(seat[row][col]);
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void bookSeat(int row, int col) {
		seat[row][col] = true;
	}
	
	public void bookAllSeats() {
		for(int i = 0 ; i < seat.length ; i++) {
			for(int j = 0 ; j < seat[0].length ; j++) {
				bookSeat(i,j);
			}
		}
	}
	
	public void freeSeat(int row, int col) {
		seat[row][col] = false;
	}
	
	public void resetSeats() {
		for(int i = 0 ; i < seat.length ; i++) {
			for(int j = 0 ; j < seat[0].length ; j++) {
				freeSeat(i,j);
			}
		}
	}
	
	public int getFreeSeats() {
		int counter=0;
		for(int i = 0 ; i < seat.length ; i++) {
			for(int j = 0 ; j < seat[0].length ; j++) {
				if(!seat[i][j]) {
					counter++;
				}
			}
		}
		return counter;
	}
}
