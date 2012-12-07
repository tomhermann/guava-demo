package guava.lang.utils;

public class StopwatchExample {

	public void doSomethingExpensive() throws InterruptedException {
		Thread.sleep(randomNumberBetween(250, 1000));
	}
	
	private int randomNumberBetween(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
}
