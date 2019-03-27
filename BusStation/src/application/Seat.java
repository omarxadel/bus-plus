package application;

public class Seat {
	boolean [][] seat;
	int capacity;
	
	public Seat(String type) {
		if(type.equals("Bus")) {
			seat = new boolean [4][12];
			capacity = 46;
		}
		else if(type.equals("Midbus")) {
			seat = new boolean [4][9];
			capacity = 34;
		}
		else if(type.equals("Minibus")) {
			seat = new boolean [3][4];
			capacity = 12;
		}
		else if(type.equals("Limo")) {
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
	
}
