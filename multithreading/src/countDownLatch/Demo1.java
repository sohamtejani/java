package countDownLatch;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(numberOfServices);
        // we use countdown latch when wanted to wait for completion off 1 or more threads

        executorService.submit(new DependentService2(latch));
        executorService.submit(new DependentService2(latch));
        executorService.submit(new DependentService2(latch));

        latch.await(2, TimeUnit.SECONDS); // will wait max for 2 seconds

        // Since main service is dependent on these 3 services, For all services we need to submit and call get()
        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown(); // worker thread will still run in background
        // executorService.shutdownNow();// all worker thread will stop
    }

}

class DependentService2 implements Callable<String> {

    private final CountDownLatch latch;

    public DependentService2(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try{
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(2000);

        }finally {
            latch.countDown();
        }

        return "Done";
    }
}
