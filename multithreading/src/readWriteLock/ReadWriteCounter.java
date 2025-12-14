package readWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
	private int count = 0;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	// ReadWriteLock allows multiple read threads to read the block until no thread is writing that block. 
	
	private final Lock readLock = lock.readLock();
	
	private final Lock writeLock = lock.writeLock();
	
	public void increment() {
		writeLock.lock();
		try {
			count++;
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			writeLock.unlock();
		}
	}
	// readLock can only be acquired by thread if the writeLock is not acquired by another thread on counter. And Vice-Versa 
	public int getCount() {
		readLock.lock();
		try {
			return count;
		}finally {
			readLock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		ReadWriteCounter counter = new ReadWriteCounter();
		
		Runnable readTask = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " read: "+counter.getCount());
				}
			}
		};
		
		
		Runnable writeTask = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					counter.increment();
					System.out.println(Thread.currentThread().getName() + " incremented: ");
				}
			}
		};
		Thread writerThread1 = new Thread(writeTask);
		Thread readerThread1 = new Thread(readTask);
		Thread readerThread2 = new Thread(readTask);
		
		writerThread1.start();
		readerThread1.start();
		readerThread2.start();
	}
}
