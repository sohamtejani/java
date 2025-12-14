package reentrantLocl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private int balance = 100;
	
	private final Lock lock = new ReentrantLock(); // ReentrantLock implements the Lock interface
	
	/*public synchronized void withDraw(int amount) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		
		if(balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
			Thread.sleep(8000);
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " completed withdrawal Remianing amount: "+balance );
		}
		else {
			System.out.println(Thread.currentThread().getName() + " insufficient balance "+ balance);
		}
	}*/
	 
	public void withDraw(int amount) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		  
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // Acquires the lock if it is free. If lock is not free then it waits for specified amount of time for lock to become available.
				// if the lock is not acquired within specified amount of time then returns false.
				// if the thread is interrupted while waiting for the lock, the method throws an InterruptedException.
				if(balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
						Thread.sleep(3000);
						balance -= amount;
		 				System.out.println(Thread.currentThread().getName() + " completed withdrawal Remianing amount: "+balance );
					}
					catch(InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
					finally{
						lock.unlock(); 
					}
				}
				else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance "+ balance);
				}
			}else {
				// advantage than synchronized is that thread will execute else part and it is free to do other task.
				System.out.println(Thread.currentThread().getName() + " Could not acquire lock, try again later");
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}
}

// ISSUE WITH SYNCHRONIZED: (Automatic lock)
// if t1 takes the more than 7 second, or infinite time, t1 is not making the progress and t2 is not able enter (start) withDrawl
// How to resolve this?

// Lock is interface
// And we will have implementation class.
// lock.lock() // thread executing  this statement tries to lock this object
// and if lock object is already locked then it will wait.

// lock.unlock() : thread who has locked the lock object will be unlocked. 

// Advantage of reentrantlock is the thread2 has not to wait for indefinite time (until the thread1 finishes it's execution)
// Advantage: Prevents deadlock and infinite waiting.

// if we use lock.lock() instead of lock.trylock() it will wait until the lock becomes unlock.