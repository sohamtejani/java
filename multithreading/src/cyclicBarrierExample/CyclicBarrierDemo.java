package cyclicBarrierExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int numberOfSystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(
                numberOfSystems,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("All subsystems are up and running. System startup complete");
                    }
                }
        );

        Thread thread1 = new Thread(new SubSystem("Web server", 2000, barrier));
        Thread thread2 = new Thread(new SubSystem("Database", 3000, barrier));
        Thread thread3 = new Thread(new SubSystem("Messaging Service", 1500, barrier));
        Thread thread4 = new Thread(new SubSystem("Cache", 2500, barrier));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class SubSystem implements Runnable{
    private String name;
    private long initializationTime;
    private CyclicBarrier barrier;

    public SubSystem(String name, long initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " initialization started");
            Thread.sleep(initializationTime);
            System.out.println(name + " initialization completed.");
            barrier.await();
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
