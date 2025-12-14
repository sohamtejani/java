package executorsDemo;

import java.util.concurrent.*;

public class Demo3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e);
            }
            return 11;
        });

        Integer i = null;
        try {
            i = future.get(3, TimeUnit.SECONDS);
            System.out.println(future.isDone());
            System.out.println(i);

        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            System.out.println("Exception: " + e);
        }

        executorService.shutdown();
    }
}
