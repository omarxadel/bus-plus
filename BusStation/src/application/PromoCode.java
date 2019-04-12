package application;

import java.util.HashMap;

public class PromoCode implements PaymentMethod {
	
	HashMap <String, Integer> promocodes = new HashMap<String, Integer>();
	float newPrice;
	
	public PromoCode() {
		promocodes.put("plusGet50", 50);
		promocodes.put("firstRide+", 100);
		promocodes.put("wlcmSummer", 10);
		promocodes.put("alexUni22", 30);
	}
	
	
	public boolean validatePromoCode(String promo) {
		return(promocodes.containsKey(promo));
	}
	
	@Override
	public void pay(float amount, String code) {
		int percentage = promocodes.get(code);
		newPrice = amount%percentage;
	}
	
	public float getNewPrice() {
		return newPrice;
	}
	
}
