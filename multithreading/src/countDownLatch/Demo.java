package countDownLatch;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        // Since main service is dependent on these 3 services, For all services we need to submit and call get()
        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown();
    }

}

class DependentService implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(2000);
        return "Done";
    }
}
