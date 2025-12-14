package executorsDemo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Executors Framework
        /** 1. Executors
         * 2. ExecutorService
         * 3. ScheduledExecutorService
         *
         */

        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for(int i = 1; i < 10; i++){
            int fianlI = i;
            threads[i - 1] = new Thread(
                    () -> {
                        long result = factorial(fianlI);
                        System.out.println(result);
                    }
            );
            threads[i - 1].start();
        }
        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Total time: "+ (System.currentTimeMillis() - startTime));
    }
    public static long factorial(int n){
        long result = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
}
