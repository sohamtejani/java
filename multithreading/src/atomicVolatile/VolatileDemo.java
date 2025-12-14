package atomicVolatile;

public class VolatileDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedResource.setFlagTrue();
        });

        Thread readerThread = new Thread(() -> {
            sharedResource.printFlagIfTrue();
        });

        writerThread.start();
        readerThread.start();
    }
}

class SharedResource{
//    private boolean flag = false;
        private volatile boolean flag = false; // now thread will refer to ram data instead of making local copy.

    public void setFlagTrue(){
        flag = true;
    }
    public void printFlagIfTrue(){
        // every thread has it's local copy of variable like flag.
        // hence even if flag becomes true, readerThread still reading copied value and goes to infinite loop.
        while(!flag){

        }
        System.out.println("Flag is true!");
    }
}
