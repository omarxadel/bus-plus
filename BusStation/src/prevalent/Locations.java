package prevalent;

public class Locations {
	
	private String[] locations = {"Brussels" , "Zurich", "Munich", "Vienna", "Amsterdam"};
	
	public Locations() {
		
	}
	public String[] getLocations() {
		return locations;
	}
	public float getPrice(String city1, String city2) {
		if(city1.equals("Brussels")) {
			if(city2.equals("Zurich")) return 30;
			else if(city2.equals("Munich")) return 30;
			else if(city2.equals("Vienna")) return 40;
			else if(city2.equals("Amsterdam")) return 10;
	}
		else if(city1.equals("Zurich")) {
			if(city2.equals("Brussels")) return 28;
			else if(city2.equals("Munich")) return 16;
			else if(city2.equals("Vienna")) return 34;
			else if(city2.equals("Amsterdam")) return 35;
		}
		else if(city1.equals("Vienna")) {
			if(city2.equals("Zurich")) return 30;
			else if(city2.equals("Munich")) return 20;
			else if(city2.equals("Brussels")) return 26;
			else if(city2.equals("Amsterdam")) return 40;
		}
		else if(city1.equals("Munich")) {
			if(city2.equals("Zurich")) return 16;
			else if(city2.equals("Brussels")) return 30;
			else if(city2.equals("Vienna")) return 20;
			else if(city2.equals("Amsterdam")) return 34;
		}
		else if(city1.equals("Amsterdam")) {
			if(city2.equals("Zurich")) return 56;
			else if(city2.equals("Munich")) return 35;
			else if(city2.equals("Vienna")) return 50;
			else if(city2.equals("Brussles")) return 9;
		}
		return -1;
	}
}
