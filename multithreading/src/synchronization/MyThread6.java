package synchronization;

public class MyThread6 extends Thread{
	private Counter counter;
	
	public MyThread6(Counter c) {
		this.counter = c;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			counter.increment();
		}
	}
}
