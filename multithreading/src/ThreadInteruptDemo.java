class MyThread8 extends Thread {
    public void run() {
        try {
            System.out.println("Thread is running...");
            Thread.sleep(8000); // Simulate a long operation
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while sleeping!");
            // Handle interruption logic, e.g., clean up or stop gracefully
        }
    }
    
}


public class ThreadInteruptDemo {
	public static void main(String[] args) {
		MyThread8 thread = new MyThread8();
        thread.start();

        try {
            Thread.sleep(1000); // main thread is sleeped for 1sec.
            thread.interrupt(); // Interrupt the sleeped thhread 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
