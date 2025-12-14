package basic;

public class MyThread2 extends Thread {
	
	public MyThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		String a = "";
		for(int i = 0; i < 10000; i++) {
			a += "a";
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Prioriry:  " + Thread.currentThread().getPriority());
		}
	}

	public static void main(String[] args) {
		MyThread2 low = new MyThread2("low");
		MyThread2 med = new MyThread2("med");
		MyThread2 high = new MyThread2("high");
		
		low.setPriority(Thread.MIN_PRIORITY);
		med.setPriority(Thread.NORM_PRIORITY);
		high.setPriority(Thread.MAX_PRIORITY);
		
		low.start();
		med.start();
		high.start();
	}
}
