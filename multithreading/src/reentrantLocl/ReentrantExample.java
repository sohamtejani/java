package reentrantLocl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
	private final Lock lock = new ReentrantLock();
	//MOST IMP: ReentrantLock, which allows the same thread to lock the same lock multiple times without causing a deadlock.
	// Reentrant lock maintain the count of how many times it is getting lock.
	public void outerMethod() {
		lock.lock(); // before lock, state of thread is   (ENTERING IN HOME)
		// count of lock is 1
		try {
			System.out.println("Outer Method");
			innerMethod();
		}
		finally {
			lock.unlock();// (EXITING FROM HOME)
		}
	}
	
	public void innerMethod() {
		lock.lock(); // locking the already locked object !!! (and waiting for itself to complete) => Deadlock     (ENTERING IN ROOM)
		// count of lock is 2
		try {
			System.out.println("Inner Method");
		}
		finally {
			lock.unlock(); // count of lock is 1   (EXITING FROM ROOM)
//			 lock.unlock();// will work fine!!!    count of lock is 0 (EXITING FROM HOME)
		}
	} 
	
	public static void main(String[] args) {
		ReentrantExample example = new ReentrantExample();
		example.outerMethod();
		System.out.println("Finished!!!");
	}
}
