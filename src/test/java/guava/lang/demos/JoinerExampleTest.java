package guava.lang.demos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

public class JoinerExampleTest {

	@Test
	public void concatenateStringsWithDelimeter() {
		String joined = Joiner.on(", ").join("Larry", "Shemp", "Moe");
		
		assertEquals("Larry, Shemp, Moe", joined);
	}
	
	@Test
	public void skipNullElements() {
		String joined = Joiner.on(", ").skipNulls().join("Larry", null, "Moe");
		
		assertEquals("Larry, Moe", joined);
	}

	@Test
	public void specifyNullBehavior() {
		String joined = Joiner.on(", ").useForNull("NULL!").join("Larry", null, "Moe");
		
		assertEquals("Larry, NULL!, Moe", joined);
	}

	@Test
	public void joinCollection() {
		Collection<String> stooges = Arrays.asList("Larry", "Curly Joe", "Moe");
		
		String joined = Joiner.on("; ").join(stooges);
		
		assertEquals("Larry; Curly Joe; Moe", joined);
	}

	@Test
	public void joinMap() {
		ImmutableMap<String, Integer> map = ImmutableMap.of("One", 1, "Two", 2, "Three", 3);
		
		String joined = Joiner.on(", ").withKeyValueSeparator(":").join(map);
		
		assertEquals("One:1, Two:2, Three:3", joined);
	}
	
}
