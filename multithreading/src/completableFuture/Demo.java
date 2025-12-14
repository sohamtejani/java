package completableFuture;

import java.util.concurrent.CompletableFuture;

public class Demo {


    public static void main(String[] args) {
        // to handle async programming
        // We use multithreading to achieve asynchronous

        // it is daemon thread by default

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Worker 1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Worker 1 Done";
        });

        // stringCompletableFuture.get(); // without this Main thread will not wait to complete.


        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Worker 2");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Worker 2 Done";
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(stringCompletableFuture, stringCompletableFuture2);
        completableFuture.join();

        System.out.println("Main thread run");

    }
}
