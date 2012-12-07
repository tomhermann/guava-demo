package guava.lang.example;

import java.text.DecimalFormat;

public class Receipt {
	private String message;
	
	public static Receipt forSuccessfulCharge(double amount) {
		return new Receipt("You have been charged: "	+ DecimalFormat.getCurrencyInstance().format(amount));
	}

	public static Receipt forDeclinedCharge(ChargeResult result) {
		return new Receipt(result.getDeclinedMessage());
	}

	protected Receipt(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
