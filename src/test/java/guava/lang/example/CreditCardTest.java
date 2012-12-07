package guava.lang.example;

import guava.lang.example.CreditCard;

import java.util.Date;

import org.joda.time.DateMidnight;
import org.junit.Test;

public class CreditCardTest {

	@Test
	public void demonstrateToString() {
		Date oneYearFromToday = new DateMidnight().plusYears(1).toDate();

		CreditCard card = new CreditCard();
		card.setCardholderName("Robert Barker");
		card.setNumber("401288888888");
		card.setCvv2("123");
		card.setExpirationDate(oneYearFromToday);
		
		System.out.println(card);
	}

	@Test
	public void demonstrateToStringWithOmittedNullValue() {
		Date oneYearFromToday = new DateMidnight().plusYears(1).toDate();
		
		CreditCard card = new CreditCard();
		card.setCardholderName("Robert Barker");
		card.setNumber(null);
		card.setCvv2("123");
		card.setExpirationDate(oneYearFromToday);
		
		System.out.println(card);
	}

}
