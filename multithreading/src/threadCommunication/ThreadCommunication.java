package threadCommunication;// In multithreading environment without thread communication, thread has to check continuously whether particular resource is free or particular condition is satisfied or not?
// kind of polling situation is arising and the cpu cycle is wasted.

// methods: wait(), notify(), notifyAll() (we can only call these methods from synchronized block/method)

class SharedResource{
	private int data;
	private boolean hasData;
	public synchronized void produce(int value) {
		
		while(hasData) {
			try {
				wait();
			}catch(InterruptedException ie) {
				ie.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		data = value;
		hasData = true;
		System.out.println("Produced: "+ value);
		notify();
	}
	public synchronized void consume() {
		while(!hasData) {
			try {
				wait();
			}catch(InterruptedException ie) {
				ie.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		hasData = false;
		notify();
		System.out.println("Comsumed: "+ data);
	}
}

class Producer implements Runnable{
	private final SharedResource resource;
	
	public Producer(SharedResource sr) {
		this.resource = sr;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000000; i++) {
			resource.produce(i);
		}
	}
}

class Consumer implements Runnable{
	private final SharedResource resource;
	
	public Consumer(SharedResource sr) {
		this.resource = sr;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000000; i++) {
			resource.consume();
		}
	}
}

public class ThreadCommunication {
	
	
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		
		Thread producerThread = new Thread(new Producer(resource));
		Thread consumerThread = new Thread(new Consumer(resource));
		
		producerThread.start();
		consumerThread.start();
		
	}
}
