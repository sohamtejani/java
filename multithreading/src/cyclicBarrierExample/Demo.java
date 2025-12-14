package cyclicBarrierExample;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        // When all thread do not reach to await() main threads waits for cyclic thread.

        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));

        // Since main service is dependent on these 3 services, For all services we need to submit and call get()
        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown(); // worker thread will still run in background
        // executorService.shutdownNow();// all worker thread will stop
    }

}

class DependentService implements Callable<String> {

    private final CyclicBarrier cyclicBarrier;

    public DependentService(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is waiting at barrier.");
        cyclicBarrier.await();
        return "Done";
    }
}
