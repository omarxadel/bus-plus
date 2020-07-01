package model;

import Interface.PaymentMethod;

import java.util.HashMap;

public class CreditCard implements PaymentMethod {

	HashMap<String, Float> cards = new HashMap<String, Float>();
	String selected;
	
	public CreditCard() {
		cards.put("4916758530208683", (float) 5000.0);
		cards.put("4929906558466049", (float) 0.0);
		cards.put("5542023793127040", (float) 25000);
		cards.put("5506946212637120", (float) 150);
	}
	
	public boolean validateCreditCard(String selected) {
		if(cards.containsKey(selected)) {
			this.selected = selected;
			return true;
		}
		else return false;
	}
	
	@Override
	public void pay(float amount, String selected) {
		float credit = cards.get(selected);
		float newCredit = credit - amount;
		cards.replace(selected, newCredit);
	}
	
	public boolean sufficient(float amount, String selected) {
		return(cards.get(selected) > amount);
	}

}
