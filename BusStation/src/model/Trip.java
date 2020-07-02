package model;

public class Trip {
	private int id;
	private String type;
	private String start;
	private String dest;
	private String driver;
	private String date;
	private String time;
	private float price;
	private int vehicle;
	

	public Trip(int id, String type, String start, String dest, String driver, int vehicle , String date, String time, float price){
		this.id = id;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.vehicle = vehicle;
		this.driver = driver;
		this.price = price;
		this.date = date;
		this.time = time;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getVehicle() {
		return vehicle;
	}

	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}
}

