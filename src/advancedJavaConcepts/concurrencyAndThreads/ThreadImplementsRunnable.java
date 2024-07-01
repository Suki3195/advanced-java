package advancedJavaConcepts.concurrencyAndThreads;

public class ThreadImplementsRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(" Thread 2 Running ---------" + Thread.currentThread().getName());
    }
}
