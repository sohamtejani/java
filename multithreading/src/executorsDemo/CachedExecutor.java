package executorsDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedExecutor {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(2);

        ExecutorService executorService = Executors.newCachedThreadPool();

        // created dynamic threads as required and also closes after 60 seconds
        // Use when load is variable and short-lived tasks are there.
    }
}
