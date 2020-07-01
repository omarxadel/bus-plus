package Model;

public  class Vehicle {
	String vtype;
	String vmodel;
	int num;
	int capacity;
	Seat s;
	
	public Vehicle(String vmodel) {
		this.vmodel = vmodel;
		vmodel = vmodel.toLowerCase();
		if(vmodel.equals("volvob12") || vmodel.equals("kiagranbird")) {
			s = new Seat("Bus");
			capacity = s.getCapacity();
		}
		else if(vmodel.equals("mercedescito")) {
			s = new Seat("Midbus");
			capacity = s.getCapacity();
		}
		else if(vmodel.equals("toyotahiace")) {
			s = new Seat("Minibus");
			capacity = s.getCapacity();
		}
		else if(vmodel.equals("hyundaiequus")) {
			s = new Seat("Limo");
			capacity = s.getCapacity();
		}
		
	}
	
	public Seat getSeats() {
		return s;
	}
	
	public int getCap() {
		return capacity;
	}
}
