package guava.lang.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import guava.lang.example.BillingService;
import guava.lang.example.ChargeResult;
import guava.lang.example.CreditCard;
import guava.lang.example.CreditCardProcessor;
import guava.lang.example.Order;
import guava.lang.example.Receipt;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BillingServiceTest {
	@InjectMocks
	private BillingService billingService;
	
	@Mock private CreditCardProcessor cardProcessor;
	@Mock private CreditCard creditCard;
	@Mock private Order order;
	@Mock private ChargeResult chargeResult;

	@Rule public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() {
		when(order.hasAcceptedAgreement()).thenReturn(true);
	}
	
	@Test(expected=NullPointerException.class)
	public void serviceWillNotAcceptNullCardProcessor() {
		new BillingService(null);
	}

	@Test
	public void whenUserHasNotAcceptedAgreementThenThrowStateException() {
		when(order.hasAcceptedAgreement()).thenReturn(false);
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("user must accept agreement!");
		
		billingService.chargeOrder(order, creditCard);
	}

	@Test
	public void orderAmountCannotBeNegative() {
		when(order.getAmount()).thenReturn(-421.0);
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("order amount (given: -421.0) must be a positive value");
		
		billingService.chargeOrder(order, creditCard);
	}
	
	@Test
	public void whenChargeSuccessfulReturnRecieptWithSuccessMessage() {
		double amount = 42.0;
		when(order.getAmount()).thenReturn(amount);
		when(chargeResult.wasSuccessful()).thenReturn(true);
		when(cardProcessor.charge(creditCard, 42.0)).thenReturn(chargeResult);
		
		Receipt chargeOrder = billingService.chargeOrder(order, creditCard);
		
		assertEquals("You have been charged: $42.00", chargeOrder.getMessage());
	}
	
	// etc..
}
