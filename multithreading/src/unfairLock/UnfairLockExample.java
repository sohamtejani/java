package unfairLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
	private final Lock unfairLock = new ReentrantLock(true);
	// default it is false, 
	// if it is true means (fairness: true) (MEANS THE CHANCE WILL BE GIVEN TO EVERY TO RUN IN THE REQUESTED ORDER OF LOCK)
	
	public void accessResourcs(){
		unfairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " acquired the lock.");
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			unfairLock.unlock();
			System.out.println(Thread.currentThread().getName()+ " released the lock.");
		}
	}
	public static void main(String[] args) {
		UnfairLockExample example = new UnfairLockExample();
		
		Runnable task = () -> example.accessResourcs();
		
		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");
		Thread thread3 = new Thread(task, "Thread 3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
// Disadvantages of Synchronization:
/*1.  No Fairness garauntee
 * 2. Blocking for Indefinite time.
 * 3. Interruptability (we can't interrupt the thread if we use synchronized keyword)
 * 4. Read/write block (while using synchronize it can't differentiate which thread is read or which is write thread? (it will block all))
 * */

/*
 * Fair locks Ensure that threads are served in the order they request the lock
 * Prevent thread starvation and ensure a predictable order of execution Are
 * recommended when there is high contention for resources Unfair locks
 * Prioritize throughput over fairness Allow threads to acquire the lock
 * regardless of when they requested it Are recommended when there is low
 * contention for resources
 */
/*
 * Print job processing: Fair locks ensure that each user gets a turn to access
 * the printer Database connection pooling: Unfair locks can optimize throughput
 * by allowing threads to quickly access database connections
 */