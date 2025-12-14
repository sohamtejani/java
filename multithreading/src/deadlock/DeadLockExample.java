package deadlock;

class Pen{
	//	here synchronization will apply the lock on Pen object not on Paper
	public synchronized  void writeWithPen(Paper paper) {
		System.out.println(Thread.currentThread().getName() + " has pen and waiting for paper ");
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		paper.finishWriting();
	}
	//	here synchronization will apply the lock on Pen object not on Paper
	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " got pen...");
		System.out.println(Thread.currentThread().getName() + " finished it's writing.");
	}
}

class Paper{
	// here synchronization will apply the lock on Paper object not on pen
	public synchronized void writeWithPaper(Pen pen) {
		System.out.println(Thread.currentThread().getName() + " has paper and waiting for pen ");
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pen.finishWriting();
		
	}
	// here synchronization will apply the lock on Paper object not on pen
	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " got paper...");
		System.out.println(Thread.currentThread().getName() + " finished it's writing.");
	}
}

class Task1 implements Runnable{
	private final Paper paper;
	private final Pen pen;
	
	Task1(Paper paper, Pen pen){
		this.paper = paper;
		this.pen = pen;
	}
	
	@Override
	public void run() {
//		synchronized(paper) {
//			pen.writeWithPen(paper); 
//		}
		 paper.writeWithPaper(pen); // will cause deadlock
	}
	
}
class Task2 implements Runnable{
	private final Paper paper;
	private final Pen pen;
	
	Task2(Paper paper, Pen pen){
		this.paper = paper;
		this.pen = pen;
	}
	
	@Override
	public void run() {
		// telling that first you must have lock on pen (acquire lock on pen if available) then only you can apply lock on paper
//		synchronized(pen) {
//			paper.writeWithPaper(pen);
//		}
		 pen.writeWithPen(paper); // will cause deadlock
	}
}
public class DeadLockExample {
	public static void main(String[] args) throws InterruptedException {
		Paper paper = new Paper();
		Pen pen = new Pen();
		
		Task1 task1 = new Task1(paper, pen);
		Task2 task2 = new Task2(paper, pen);
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		t2.start();
		
		/*Runnable rn1 = new Runnable() {
			@Override
			public void run() {
				pen.writeWithPen(paper);
			}
		};
		Runnable rn2 = new Runnable() {
			@Override
			public void run() {
				paper.writeWithPaper(pen);
			}
		};
		Thread th1 = new Thread(rn1);
		Thread th2 = new Thread(rn2);
		
		th1.start();
		th2.start();
		*/
	}
}
