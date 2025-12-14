package executorsDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> submit = executorService.submit(() -> 1 + 2);

        Integer i = submit.get(); // main thread will wait for result
        System.out.println("Sum is: "+ i);

        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        Thread.sleep(10);
        System.out.println(executorService.isTerminated());

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);

        Callable<Integer> callable = () -> {
            System.out.println("Task 1 started");
            Thread.sleep(1000);
            System.out.println("Task 1 completed");
            return 1;
        };
        Callable<Integer> callable1 = () -> {
            System.out.println("Task 2 started");
            Thread.sleep(1000);
            System.out.println("Task 2 completed");
            return 2;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 3 started");
            Thread.sleep(1000);
            System.out.println("Task 3 completed");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable, callable1, callable2);

        List<Future<Integer>> futures = executorService1.invokeAll(list, 1, TimeUnit.SECONDS); // also main thread waits for minimum time of 1s or all threads completed.

        try{
            Integer i1 = executorService1.invokeAny(list, 1, TimeUnit.SECONDS); // also main thread waits for minimum time of 1s or all threads completed.
        }
        catch (InterruptedException e){
            throw new RuntimeException();
        }
        catch (ExecutionException e){
            throw new RuntimeException();
        }

        for(Future<Integer> f: futures){
            System.out.println("Getting result: "+ f.get());
        }

        System.out.println("Main thread continues...");

        executorService1.shutdown();
    }
}
