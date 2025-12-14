package executorsDemo;

import java.util.concurrent.*;

public class DemoExecutor {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 10; i++) {
            int fianlI = i;
            Future<?> future = executorService.submit(() -> {
                long result = factorial(fianlI);
                System.out.println(result);
            });
        }
        executorService.shutdown(); // main thread will not wait for threads in executors to shut down
        // executorService.shutdownNow();

        try {
            // executorService.awaitTermination(100, TimeUnit.SECONDS);
            // will wait for 100s for threads to complete, after that execution will move ahead
            // returns true if all threads terminated before timeout else false

            while (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                System.out.println("Waiting...");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    public static long factorial(int n) {
        long result = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
