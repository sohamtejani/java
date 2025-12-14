import synchronization.Counter;
import synchronization.MyThread6;

public class Test2 {
	public static void main(String[] args) {
		Counter c = new Counter(); // shared object
		
		MyThread6 t1 = new MyThread6(c);
		MyThread6 t2 = new MyThread6(c);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(c.getCount());
	}
}
