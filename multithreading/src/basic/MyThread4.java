package basic;

public class MyThread4 extends Thread {
	
	public MyThread4(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " is running...");
			Thread.yield(); // tell jvm that you can give chance to another thread for running
		}
	}

	public static void main(String[] args) throws InterruptedException{
		MyThread4 t = new MyThread4("t1");
		MyThread4 t2 = new MyThread4("t2");
		
		t.start();
		t2.start();
		
	}
}
