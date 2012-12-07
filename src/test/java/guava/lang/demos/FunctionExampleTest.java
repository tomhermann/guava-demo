package guava.lang.demos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class FunctionExampleTest {

	@Test
	public void transformCollection() throws Exception {
		List<Employee> employees = Arrays.asList(new Employee("Somebody"));
		
		List<String> names = Lists.transform(employees, new Function<Employee, String>() {
			public String apply(Employee input) {
				return input.name;
			}
		});
		
		assertEquals("Somebody", names.get(0));
	
	}
	
	private class Employee {
		private final String name;

		public Employee(String name) {
			this.name = name;
		}
	}
}
