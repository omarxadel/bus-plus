package application;

public class Cash implements PaymentMethod {
	float toPay;
	
	@Override
	public void pay(float amount, String code) {
		toPay = amount;
	}
}

