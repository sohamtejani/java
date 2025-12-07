//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Streams

        //Lambda expressions: way to express anonymous function (no name, no return type, no access modifier)

        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(() -> {
            System.out.println("Hello from lambda expression");
        });
        t1.start();
        t2.start();

        MathOperation sumOperation = (int a, int b) -> {
          return a + b;
        }; // Functional interface can hold reference of lambda expression

        MathOperation subtractOperation = (int a, int b) -> a - b;
        MathOperation multiplyOperation = (a, b) -> a * b;

        int sum = sumOperation.operate(2, 3);
        System.out.println("sum: "+ sum);

    }
}
class Task implements  Runnable{
    @Override
    public void run(){
        System.out.println("Hello from class");
    }
}