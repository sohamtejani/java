package basic;// What is User Thread?
// Thread which does the usefull work is called user thread.
// DAEMON Thread: Thread who are running is Background. (e.g Garbage collector)
// NOTE: Main thread(JVM) will wait for User Thread to Complete but it(JVM) will never work for DAEMON Thread to complete.


public class MyThread5 extends Thread {
	
	public MyThread5(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello world");
		}
	}

	public static void main(String[] args) throws InterruptedException{
		MyThread5 t = new MyThread5("t1");
//		 MyThread5 t = new MyThread5("t2");
		
		 t.setDaemon(true);
		
		t.start();
		
		System.out.println("Main Thread done...");
		
	}
}
