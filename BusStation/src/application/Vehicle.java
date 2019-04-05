package application;
import java.util.*;

public  class Vehicle {
	String vtype;
	String vmodel;
	int num;
	Seat capacity;
	
	public Vehicle(String vmodel) {
		this.vmodel = vmodel;
		vmodel.toLowerCase();
		if(vmodel.equals("volvo b12") || vmodel.equals("kia granbird")) {
			capacity = new Seat("Bus");
		}
		else if(vmodel.equals("mercedes cito")) {
			capacity = new Seat("MidBus");
		}
		else if(vmodel.equals("toyota hiace")) {
			capacity = new Seat("MiniBus");
		}
		else if(vmodel.equals("hyundai equus")) {
			capacity = new Seat("Limo");
		}
		
	}
}
