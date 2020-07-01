package Model;

public class Seat {
	String [] seatingChart = new String [50];
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
		
		initSeatingChart();
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
	
	public void initSeatingChart() {
		int i = 0;
		if(capacity == 12) {
			while(i<6) {
				seatingChart[i] = ("A"+ (i+1));
				i++;
			}
			while(i<12) {
				seatingChart[i] = ("B" + ((i+1)));
				i++;
			}
		}
		else if(capacity == 36) {
			while(i<18) {
				seatingChart[i] = ("A"+ (i+1));
				i++;
			}
			while(i<36) {
				seatingChart[i] = ("B" + ((i+1)));
				i++;
			}
		}
		else if(capacity == 48) {
			while(i<24) {
				seatingChart[i] = ("A"+ (i+1));
				i++;
			}
			while(i<48) {
				seatingChart[i] = ("B" + ((i+1)));
				i++;
			}
		}
		
		else return;
	}
	
	
	public String bookRandom() {
		int i = 0;
	
		if(capacity == 12) {
			while(i<6) {
			if(isBookedByName("A"+(i+1))) {
				i++;
				continue;
			}
			else {
				bookByName("A"+(i+1));
				return ("A"+(i+1));
			}
			}
			while(i<12) {
				if(isBookedByName("B"+(i-5))) {
					i++;
					continue;
				}
				else {
					bookByName("B"+(i-5));
					return("B"+(i-5));
				}
			}
		}
		else if(capacity == 36) {
			while(i<18) {
			if(isBookedByName("A"+(i+1))) {
				i++;
			}
			else {
				bookByName("A"+(i+1));
				return ("A"+(i+1));
			}
			}
			while(i<36) {
				if(isBookedByName("B"+(i+1))) {
					i++;
				}
				else {
					bookByName("B"+(i+1));
					return("B"+(i+1));
				}
			}
		}
		else if(capacity == 48) {
			while(i<24) {
			if(isBookedByName("A"+(i+1))) {
				i++;
			}
			else {
				bookByName("A"+(i+1));
				return ("A"+(i+1));
			}
			}
			while(i<48) {
				if(isBookedByName("B"+(i+1))) {
					i++;
				}
				else {
					bookByName("B"+(i+1));
					return("B"+(i+1));
				}
			}
		}
		return null;
	}
	
	public boolean isBookedByName(String name) {
		if (capacity == 12) {
			if(name.equals("A1")) return isBooked(0,0);
			else if(name.equals("A2")) return isBooked(1,0);
			else if(name.equals("A3")) return isBooked(0,1);
			else if(name.equals("A4")) return isBooked(1,1);
			else if(name.equals("A5")) return isBooked(0,2);
			else if(name.equals("A6")) return isBooked(1,2);
			else if(name.equals("B1")) return isBooked(0,3);
			else if(name.equals("B2")) return isBooked(1,3);
			else if(name.equals("B3")) return isBooked(2,0);
			else if(name.equals("B4")) return isBooked(2,1);
			else if(name.equals("B5")) return isBooked(2,2);
			else if(name.equals("B6")) return isBooked(2,3);
		}
		else if(capacity == 36) {
			if(name.equals("A1")) return isBooked(0,0);
			else if(name.equals("A2")) return isBooked(1,0);
			else if(name.equals("A3")) return isBooked(0,1);
			else if(name.equals("A4")) return isBooked(1,1);
			else if(name.equals("A5")) return isBooked(0,2);
			else if(name.equals("A6")) return isBooked(1,2);
			else if(name.equals("A7")) return isBooked(0,3);
			else if(name.equals("A8")) return isBooked(1,3);
			else if(name.equals("A9")) return isBooked(0,4);
			else if(name.equals("A10")) return isBooked(1,4);
			else if(name.equals("A11")) return isBooked(0,5);
			else if(name.equals("A12")) return isBooked(1,5);
			else if(name.equals("A13")) return isBooked(0,6);
			else if(name.equals("A14")) return isBooked(1,6);
			else if(name.equals("A15")) return isBooked(0,7);
			else if(name.equals("A16")) return isBooked(1,7);
			else if(name.equals("A17")) return isBooked(0,8);
			else if(name.equals("A18")) return isBooked(1,8);
			else if(name.equals("B1")) return isBooked(2,0);
			else if(name.equals("B2")) return isBooked(3,0);
			else if(name.equals("B3")) return isBooked(2,1);
			else if(name.equals("B4")) return isBooked(3,1);
			else if(name.equals("B5")) return isBooked(2,2);
			else if(name.equals("B6")) return isBooked(3,2);
			else if(name.equals("B7")) return isBooked(2,3);
			else if(name.equals("B8")) return isBooked(3,3);
			else if(name.equals("B9")) return isBooked(2,4);
			else if(name.equals("B10")) return isBooked(3,4);
			else if(name.equals("B11")) return isBooked(2,5);
			else if(name.equals("B12")) return isBooked(3,5);
			else if(name.equals("B13")) return isBooked(2,6);
			else if(name.equals("B14")) return isBooked(3,6);
			else if(name.equals("B15")) return isBooked(2,7);
			else if(name.equals("B16")) return isBooked(3,7);
			else if(name.equals("B17")) return isBooked(2,8);
			else if(name.equals("B18")) return isBooked(3,8);
		}
		else if(capacity == 48) {
			if(name.equals("A1")) return isBooked(0,0);
			else if(name.equals("A2")) return isBooked(1,0);
			else if(name.equals("A3")) return isBooked(0,1);
			else if(name.equals("A4")) return isBooked(1,1);
			else if(name.equals("A5")) return isBooked(0,2);
			else if(name.equals("A6")) return isBooked(1,2);
			else if(name.equals("A7")) return isBooked(0,3);
			else if(name.equals("A8")) return isBooked(1,3);
			else if(name.equals("A9")) return isBooked(0,4);
			else if(name.equals("A10")) return isBooked(1,4);
			else if(name.equals("A11")) return isBooked(0,5);
			else if(name.equals("A12")) return isBooked(1,5);
			else if(name.equals("A13")) return isBooked(0,6);
			else if(name.equals("A14")) return isBooked(1,6);
			else if(name.equals("A15")) return isBooked(0,7);
			else if(name.equals("A16")) return isBooked(1,7);
			else if(name.equals("A17")) return isBooked(0,8);
			else if(name.equals("A18")) return isBooked(1,8);
			else if(name.equals("A19")) return isBooked(0,9);
			else if(name.equals("A20")) return isBooked(1,9);
			else if(name.equals("A21")) return isBooked(0,10);
			else if(name.equals("A22")) return isBooked(1,10);
			else if(name.equals("A23")) return isBooked(0,11);
			else if(name.equals("A24")) return isBooked(1,11);
			else if(name.equals("B1")) return isBooked(2,0);
			else if(name.equals("B2")) return isBooked(3,0);
			else if(name.equals("B3")) return isBooked(2,1);
			else if(name.equals("B4")) return isBooked(3,1);
			else if(name.equals("B5")) return isBooked(2,2);
			else if(name.equals("B6")) return isBooked(3,2);
			else if(name.equals("B7")) return isBooked(2,3);
			else if(name.equals("B8")) return isBooked(3,3);
			else if(name.equals("B9")) return isBooked(2,4);
			else if(name.equals("B10")) return isBooked(3,4);
			else if(name.equals("B11")) return isBooked(2,5);
			else if(name.equals("B12")) return isBooked(3,5);
			else if(name.equals("B13")) return isBooked(2,6);
			else if(name.equals("B14")) return isBooked(3,6);
			else if(name.equals("B15")) return isBooked(2,7);
			else if(name.equals("B16")) return isBooked(3,7);
			else if(name.equals("B17")) return isBooked(2,8);
			else if(name.equals("B18")) return isBooked(3,8);
			else if(name.equals("B19")) return isBooked(2,9);
			else if(name.equals("B20")) return isBooked(3,9);
			else if(name.equals("B21")) return isBooked(2,10);
			else if(name.equals("B22")) return isBooked(3,10);
			else if(name.equals("B23")) return isBooked(2,11);
			else if(name.equals("B24")) return isBooked(3,11);
		}
		return false;
	}
	
	
	public void bookByName(String name) {
		if (capacity == 12) {
			if(name.equals("A1")) bookSeat(0,0);
			else if(name.equals("A2")) bookSeat(1,0);
			else if(name.equals("A3")) bookSeat(0,1);
			else if(name.equals("A4")) bookSeat(1,1);
			else if(name.equals("A5")) bookSeat(0,2);
			else if(name.equals("A6")) bookSeat(1,2);
			else if(name.equals("B1")) bookSeat(0,3);
			else if(name.equals("B2")) bookSeat(1,3);
			else if(name.equals("B3")) bookSeat(2,0);
			else if(name.equals("B4")) bookSeat(2,1);
			else if(name.equals("B5")) bookSeat(2,2);
			else if(name.equals("B6")) bookSeat(2,3);
			return;
		}
		else if(capacity == 36) {
			if(name.equals("A1")) bookSeat(0,0);
			else if(name.equals("A2")) bookSeat(1,0);
			else if(name.equals("A3")) bookSeat(0,1);
			else if(name.equals("A4")) bookSeat(1,1);
			else if(name.equals("A5")) bookSeat(0,2);
			else if(name.equals("A6")) bookSeat(1,2);
			else if(name.equals("A7")) bookSeat(0,3);
			else if(name.equals("A8")) bookSeat(1,3);
			else if(name.equals("A9")) bookSeat(0,4);
			else if(name.equals("A10")) bookSeat(1,4);
			else if(name.equals("A11")) bookSeat(0,5);
			else if(name.equals("A12")) bookSeat(1,5);
			else if(name.equals("A13")) bookSeat(0,6);
			else if(name.equals("A14")) bookSeat(1,6);
			else if(name.equals("A15")) bookSeat(0,7);
			else if(name.equals("A16")) bookSeat(1,7);
			else if(name.equals("A17")) bookSeat(0,8);
			else if(name.equals("A18")) bookSeat(1,8);
			else if(name.equals("B1")) bookSeat(2,0);
			else if(name.equals("B2")) bookSeat(3,0);
			else if(name.equals("B3")) bookSeat(2,1);
			else if(name.equals("B4")) bookSeat(3,1);
			else if(name.equals("B5")) bookSeat(2,2);
			else if(name.equals("B6")) bookSeat(3,2);
			else if(name.equals("B7")) bookSeat(2,3);
			else if(name.equals("B8")) bookSeat(3,3);
			else if(name.equals("B9")) bookSeat(2,4);
			else if(name.equals("B10")) bookSeat(3,4);
			else if(name.equals("B11")) bookSeat(2,5);
			else if(name.equals("B12")) bookSeat(3,5);
			else if(name.equals("B13")) bookSeat(2,6);
			else if(name.equals("B14")) bookSeat(3,6);
			else if(name.equals("B15")) bookSeat(2,7);
			else if(name.equals("B16")) bookSeat(3,7);
			else if(name.equals("B17")) bookSeat(2,8);
			else if(name.equals("B18")) bookSeat(3,8);
			return;
		}
		else if(capacity == 48) {
			if(name.equals("A1")) bookSeat(0,0);
			else if(name.equals("A2")) bookSeat(1,0);
			else if(name.equals("A3")) bookSeat(0,1);
			else if(name.equals("A4")) bookSeat(1,1);
			else if(name.equals("A5")) bookSeat(0,2);
			else if(name.equals("A6")) bookSeat(1,2);
			else if(name.equals("A7")) bookSeat(0,3);
			else if(name.equals("A8")) bookSeat(1,3);
			else if(name.equals("A9")) bookSeat(0,4);
			else if(name.equals("A10")) bookSeat(1,4);
			else if(name.equals("A11")) bookSeat(0,5);
			else if(name.equals("A12")) bookSeat(1,5);
			else if(name.equals("A13")) bookSeat(0,6);
			else if(name.equals("A14")) bookSeat(1,6);
			else if(name.equals("A15")) bookSeat(0,7);
			else if(name.equals("A16")) bookSeat(1,7);
			else if(name.equals("A17")) bookSeat(0,8);
			else if(name.equals("A18")) bookSeat(1,8);
			else if(name.equals("A19")) bookSeat(0,9);
			else if(name.equals("A20")) bookSeat(1,9);
			else if(name.equals("A21")) bookSeat(0,10);
			else if(name.equals("A22")) bookSeat(1,10);
			else if(name.equals("A23")) bookSeat(0,11);
			else if(name.equals("A24")) bookSeat(1,11);
			else if(name.equals("B1")) bookSeat(2,0);
			else if(name.equals("B2")) bookSeat(3,0);
			else if(name.equals("B3")) bookSeat(2,1);
			else if(name.equals("B4")) bookSeat(3,1);
			else if(name.equals("B5")) bookSeat(2,2);
			else if(name.equals("B6")) bookSeat(3,2);
			else if(name.equals("B7")) bookSeat(2,3);
			else if(name.equals("B8")) bookSeat(3,3);
			else if(name.equals("B9")) bookSeat(2,4);
			else if(name.equals("B10")) bookSeat(3,4);
			else if(name.equals("B11")) bookSeat(2,5);
			else if(name.equals("B12")) bookSeat(3,5);
			else if(name.equals("B13")) bookSeat(2,6);
			else if(name.equals("B14")) bookSeat(3,6);
			else if(name.equals("B15")) bookSeat(2,7);
			else if(name.equals("B16")) bookSeat(3,7);
			else if(name.equals("B17")) bookSeat(2,8);
			else if(name.equals("B18")) bookSeat(3,8);
			else if(name.equals("B19")) bookSeat(2,9);
			else if(name.equals("B20")) bookSeat(3,9);
			else if(name.equals("B21")) bookSeat(2,10);
			else if(name.equals("B22")) bookSeat(3,10);
			else if(name.equals("B23")) bookSeat(2,11);
			else if(name.equals("B24")) bookSeat(3,11);
			return;
		}
	}

	/*public void resetByName(String seat2) {
		
		
	}*/
	
	public void resetByName(String name) {
		if (capacity == 12) {
			if(name.equals("A1")) freeSeat(0,0);
			else if(name.equals("A2")) freeSeat(1,0);
			else if(name.equals("A3")) freeSeat(0,1);
			else if(name.equals("A4")) freeSeat(1,1);
			else if(name.equals("A5")) freeSeat(0,2);
			else if(name.equals("A6")) freeSeat(1,2);
			else if(name.equals("B1")) freeSeat(0,3);
			else if(name.equals("B2")) freeSeat(1,3);
			else if(name.equals("B3")) freeSeat(2,0);
			else if(name.equals("B4")) freeSeat(2,1);
			else if(name.equals("B5")) freeSeat(2,2);
			else if(name.equals("B6")) freeSeat(2,3);
			return;
		}
		else if(capacity == 36) {
			if(name.equals("A1")) freeSeat(0,0);
			else if(name.equals("A2")) freeSeat(1,0);
			else if(name.equals("A3")) freeSeat(0,1);
			else if(name.equals("A4")) freeSeat(1,1);
			else if(name.equals("A5")) freeSeat(0,2);
			else if(name.equals("A6")) freeSeat(1,2);
			else if(name.equals("A7")) freeSeat(0,3);
			else if(name.equals("A8")) freeSeat(1,3);
			else if(name.equals("A9")) freeSeat(0,4);
			else if(name.equals("A10")) freeSeat(1,4);
			else if(name.equals("A11")) freeSeat(0,5);
			else if(name.equals("A12")) freeSeat(1,5);
			else if(name.equals("A13")) freeSeat(0,6);
			else if(name.equals("A14")) freeSeat(1,6);
			else if(name.equals("A15")) freeSeat(0,7);
			else if(name.equals("A16")) freeSeat(1,7);
			else if(name.equals("A17")) freeSeat(0,8);
			else if(name.equals("A18")) freeSeat(1,8);
			else if(name.equals("B1")) freeSeat(2,0);
			else if(name.equals("B2")) freeSeat(3,0);
			else if(name.equals("B3")) freeSeat(2,1);
			else if(name.equals("B4")) freeSeat(3,1);
			else if(name.equals("B5")) freeSeat(2,2);
			else if(name.equals("B6")) freeSeat(3,2);
			else if(name.equals("B7")) freeSeat(2,3);
			else if(name.equals("B8")) freeSeat(3,3);
			else if(name.equals("B9")) freeSeat(2,4);
			else if(name.equals("B10")) freeSeat(3,4);
			else if(name.equals("B11")) freeSeat(2,5);
			else if(name.equals("B12")) freeSeat(3,5);
			else if(name.equals("B13")) freeSeat(2,6);
			else if(name.equals("B14")) freeSeat(3,6);
			else if(name.equals("B15")) freeSeat(2,7);
			else if(name.equals("B16")) freeSeat(3,7);
			else if(name.equals("B17")) freeSeat(2,8);
			else if(name.equals("B18")) freeSeat(3,8);
			return;
		}
		else if(capacity == 48) {
			if(name.equals("A1")) freeSeat(0,0);
			else if(name.equals("A2")) freeSeat(1,0);
			else if(name.equals("A3")) freeSeat(0,1);
			else if(name.equals("A4")) freeSeat(1,1);
			else if(name.equals("A5")) freeSeat(0,2);
			else if(name.equals("A6")) freeSeat(1,2);
			else if(name.equals("A7")) freeSeat(0,3);
			else if(name.equals("A8")) freeSeat(1,3);
			else if(name.equals("A9")) freeSeat(0,4);
			else if(name.equals("A10")) freeSeat(1,4);
			else if(name.equals("A11")) freeSeat(0,5);
			else if(name.equals("A12")) freeSeat(1,5);
			else if(name.equals("A13")) freeSeat(0,6);
			else if(name.equals("A14")) freeSeat(1,6);
			else if(name.equals("A15")) freeSeat(0,7);
			else if(name.equals("A16")) freeSeat(1,7);
			else if(name.equals("A17")) freeSeat(0,8);
			else if(name.equals("A18")) freeSeat(1,8);
			else if(name.equals("A19")) freeSeat(0,9);
			else if(name.equals("A20")) freeSeat(1,9);
			else if(name.equals("A21")) freeSeat(0,10);
			else if(name.equals("A22")) freeSeat(1,10);
			else if(name.equals("A23")) freeSeat(0,11);
			else if(name.equals("A24")) freeSeat(1,11);
			else if(name.equals("B1")) freeSeat(2,0);
			else if(name.equals("B2")) freeSeat(3,0);
			else if(name.equals("B3")) freeSeat(2,1);
			else if(name.equals("B4")) freeSeat(3,1);
			else if(name.equals("B5")) freeSeat(2,2);
			else if(name.equals("B6")) freeSeat(3,2);
			else if(name.equals("B7")) freeSeat(2,3);
			else if(name.equals("B8")) freeSeat(3,3);
			else if(name.equals("B9")) freeSeat(2,4);
			else if(name.equals("B10")) freeSeat(3,4);
			else if(name.equals("B11")) freeSeat(2,5);
			else if(name.equals("B12")) freeSeat(3,5);
			else if(name.equals("B13")) freeSeat(2,6);
			else if(name.equals("B14")) freeSeat(3,6);
			else if(name.equals("B15")) freeSeat(2,7);
			else if(name.equals("B16")) freeSeat(3,7);
			else if(name.equals("B17")) freeSeat(2,8);
			else if(name.equals("B18")) freeSeat(3,8);
			else if(name.equals("B19")) freeSeat(2,9);
			else if(name.equals("B20")) freeSeat(3,9);
			else if(name.equals("B21")) freeSeat(2,10);
			else if(name.equals("B22")) freeSeat(3,10);
			else if(name.equals("B23")) freeSeat(2,11);
			else if(name.equals("B24")) freeSeat(3,11);
			return;
		}
	}
	
}
