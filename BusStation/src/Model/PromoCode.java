package Model;

import Interface.PaymentMethod;

import java.util.HashMap;

public class PromoCode implements PaymentMethod {
	
	HashMap <String, Float> promocodes = new HashMap<String, Float>();
	float newPrice;
	
	public PromoCode() {
		promocodes.put("plusGet50", (float) 50);
		promocodes.put("firstRide+", (float) 100);
		promocodes.put("wlcmSummer", (float) 10);
		promocodes.put("alexUni22", (float) 30);
	}
	
	
	public boolean validatePromoCode(String promo) {
		return(promocodes.containsKey(promo));
	}
	
	@Override
	public void pay(float amount, String code) {
		float percentage = promocodes.get(code);
		newPrice = amount*(percentage/100);
	}
	
	public float getNewPrice() {
		return newPrice;
	}
	
}
