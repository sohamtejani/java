package reentrantLocl;

public class MyThread7 {
	public static void main(String[] args) {
		BankAccount sbi = new BankAccount();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					sbi.withDraw(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(task, "Thread: 1"); 
		Thread t2 = new Thread(task, "Thread: 2");
		
		t1.start();
		t2.start();
	}
}
