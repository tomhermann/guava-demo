package guava.lang.demos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalExampleTest {

	@Test
	public void optionalWrapper() {
		Date dateReference = new Date();
		Optional<Date> optionalDate = Optional.of(dateReference);
		
		assertTrue(optionalDate.isPresent());
		assertSame(dateReference, optionalDate.get());
	}
	
	@Test
	public void optionalWrapperWithoutValue() {
		Optional<Date> optionalDate = Optional.absent();
		
		assertFalse(optionalDate.isPresent());
	}

	@Test
	public void optionalWrapperWithNullableValue() {
		Optional<Date> optionalDate = Optional.fromNullable(null);
		
		assertFalse(optionalDate.isPresent());
	}
}
