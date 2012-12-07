package guava.lang.example;

import com.google.common.base.Preconditions;

public class BillingService {
	private final CreditCardProcessor processor;

	public BillingService(CreditCardProcessor processor) {
		this.processor = Preconditions.checkNotNull(processor);
	}
	
	public Receipt chargeOrder(Order order, CreditCard creditCard) {
		Preconditions.checkState(order.hasAcceptedAgreement(), "user must accept agreement!");
		Preconditions.checkArgument(order.getAmount() > 0 , "order amount (given: %s) must be a positive value", order.getAmount());
		
		ChargeResult result = processor.charge(creditCard, order.getAmount());
		
		return result.wasSuccessful() ? Receipt.forSuccessfulCharge(order.getAmount()) : Receipt.forDeclinedCharge(result);
	}
}
