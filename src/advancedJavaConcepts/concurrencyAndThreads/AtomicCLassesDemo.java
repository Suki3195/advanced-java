package advancedJavaConcepts.concurrencyAndThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCLassesDemo {
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    // No Duplicate numbers, guarenteed to get 10
    // Order is not guaranteed
    public static void addToCounter(){
//        int c = count;
        System.out.println("Before  - " + atomicCount  + "   Thread id  :  " + Thread.currentThread().getId());
        atomicCount.addAndGet(1) ;
        System.out.println("After  - " + atomicCount  + "    Thread id  :  " + Thread.currentThread().getId());

    }

    public static void main(String[] args) {

        // Below code will give duplicate
//        for (int i=1;i<=10;i++){
//            new Thread(() -> addToCounter()).start();
//        }


        // will give numbers from 1 to 10 and non will repeat. Order is not guarenteed
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i=1;i<=10;i++){
            es.submit(() -> System.out.println(atomicCount.incrementAndGet()    +  " "));
        }
        es.shutdown();
    }
}
