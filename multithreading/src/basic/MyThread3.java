package basic;

public class MyThread3 extends Thread {
	public MyThread3(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("I am running");
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println("Thread was interrupted while sleeping." + e);
		}
	}

	public static void main(String[] args) throws InterruptedException{
		MyThread3 t = new MyThread3("low");
		
		try {
			t.start();
			t.interrupt(); // stop whatever you are doing.
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
}
