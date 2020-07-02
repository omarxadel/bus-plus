package model;

import Interface.PaymentMethod;

public class Cash implements PaymentMethod {
	 private float toPay;
	
	@Override
	public void pay(float amount, String code) {

		toPay = amount;
	}

	public float getToPay() {
		return toPay;
	}

	public void setToPay(float toPay) {
		this.toPay = toPay;
	}
}

