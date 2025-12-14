public class LambdaExpression {
	public static void main(String[] args) {
		Runnable runnable = () -> System.out.println("Hello");
		
		Thread th = new Thread(runnable);
		th.start();
	}
}
