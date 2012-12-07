package guava.lang.example;

public interface CreditCardProcessor {
	ChargeResult charge(CreditCard card, double amount);
}
