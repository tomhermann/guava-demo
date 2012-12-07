package guava.lang.example;

import java.util.Date;

import com.google.common.base.Objects;

public class CreditCard {
	private String number;
	private String cardholderName;
	private String cvv2;
	private Date expirationDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("card number", number)
				.add("cardholder name", cardholderName)
				.add("cvv2", cvv2)
				.add("expiration date", expirationDate)
				.omitNullValues()
			.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getCardholderName(), getCvv2(), getExpirationDate(), getNumber());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CreditCard){
	        final CreditCard other = (CreditCard) obj;
	        return Objects.equal(cardholderName, other.cardholderName)
	            && Objects.equal(number, other.number)
	            && Objects.equal(cvv2, other.cvv2)
	            && Objects.equal(expirationDate, other.expirationDate);
	    } else{
	        return false;
	    }
	}
}
