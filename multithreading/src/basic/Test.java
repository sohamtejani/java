package basic;

public class Test extends Thread{
	public static void main(String[] args) {
		
		// 1. Using Extending Thread
		/*
		  World world = new World();
		
		  world.start();
		 */
		
		// 2. Using Implementing Runnable Interface
		
		World2 world2 = new World2();
		
		Thread t = new Thread(world2);
		t.start();
		
		for( ; ; ) {
			// System.out.println("Hello");
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class World extends Thread{

	@Override
	public void run() {
		for(; ; ) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
class World2 implements Runnable{

	@Override
	public void run() {
		for( ; ; ) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
