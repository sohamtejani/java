package executorsDemo;

import java.util.concurrent.*;

public class Demo4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            try {
                System.out.println("Task started");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e);
            }
            System.out.println("Task completed");
            return 11;
        });

//        future.cancel(true);
        // If the task has not started yet, it will be cancelled and never executed.
        // If the task has already started, the executing thread will be interrupted.
        // The Future is marked as cancelled and get() will throw CancellationException.

//        System.out.println(future.isDone());
//        System.out.println(future.isCancelled());

//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//            System.out.println("Thread interrupted: "+ e);
//        }
        future.cancel(false);
// If the task has not started yet, it will be cancelled and never executed.
// If the task has already started, it will NOT be interrupted and will continue running.
// In both cases, the Future is marked as cancelled and get() will throw CancellationException.

        System.out.println(future.isCancelled());
        System.out.println(future.isDone());

        executorService.shutdown();
    }
}
