package guava.lang.demos;

import guava.lang.utils.StopwatchExample;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

public class StopwatchExampleTest {

	@Test
	public void demonstrateStopwatch() throws Exception {
		Stopwatch stopwatch = new Stopwatch().start();

		new StopwatchExample().doSomethingExpensive();
		
		stopwatch.stop();
		long elapsedTime = stopwatch.elapsedTime(TimeUnit.MILLISECONDS);
		
		System.err.println("Elapsed time: " + elapsedTime);
	}
}
