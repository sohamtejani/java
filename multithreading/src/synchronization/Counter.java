package synchronization;

public class Counter {
	private int count = 0;
	
	// Below is the critical section where the shared resource is modified.
	void increment() {
		synchronized (this) {
			this.count++;
		}
	}
	
	public int getCount() {
		return this.count;
	}

}

// RACE Condition: When 2 or more threads try to modify the shared 
// resources and the final outcome depends on the execution of threads
// access that is called race condition 

// MUTUAL Exclusion: prevents the threads to access the critical section simultaneously.

/* LOCK
 * There are 2 Types of lock: Intrinsic Lock and Explicit Lock
 * 1. These are built in into every object in java.
 * We are using intrinsic lock when we are using synchronized keyword. 
 * things automatically lock in case of synchronized
 * 
 * 2. Explicit Lock: These are more advanced locks we can control ourselves using Lock class from java.util.concurrent.locks
 * we are explicitly saying when to lock and unlock, giving more control.
 */


// ISSUE IN SYNCHRONIZED : 

/*
 * */
 