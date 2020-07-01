package model;

import Interface.PaymentMethod;

public class Cash implements PaymentMethod {
	float toPay;
	
	@Override
	public void pay(float amount, String code) {
		toPay = amount;
	}
}

