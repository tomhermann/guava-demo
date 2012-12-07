package guava.lang.demos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.base.CharMatcher;

public class CharMatcherExampleTest {

	@Test
	public void matchVowelsInStringWithNoVowels() {
		boolean matches = CharMatcher.anyOf("AEIOU").matchesAnyOf("ZZZ");
		
		assertFalse(matches);
	}

	@Test
	public void matchVowelsInStringWithVowels() {
		CharMatcher vowels = CharMatcher.anyOf("aeiou");
		
		assertTrue(vowels.matchesAnyOf("Hello"));
		assertEquals(2, vowels.countIn("Hello"));
	}

	@Test
	public void retainAlphanumericCharacterFromString() {
		CharMatcher notLetterOrDigit = CharMatcher.JAVA_LETTER_OR_DIGIT;

		String trimmed = notLetterOrDigit.retainFrom("I like to@sty sammiches.!!?");
		
		assertEquals("Iliketostysammiches", trimmed);
	}
	@Test
	public void chainingOfMatchers() {
		CharMatcher matcher = CharMatcher.JAVA_LETTER_OR_DIGIT.or(CharMatcher.WHITESPACE).or(CharMatcher.is('.'));
		
		String trimmed = matcher.retainFrom("I like to@sty sammiches.!!?");
		
		assertEquals("I like tosty sammiches.", trimmed);
	}
	
}
