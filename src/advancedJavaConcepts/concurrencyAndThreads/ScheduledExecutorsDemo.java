package advancedJavaConcepts.concurrencyAndThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsDemo {

    private static ScheduledExecutorService scEs = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {

//        schedule();
        scheduleWithFixedDelay();
//        scheduleAtFixedRate();

    }

    private static void schedule(){
        System.out.println("Start .......");
        Future<String> future = scEs.schedule(() -> "A",2, TimeUnit.SECONDS);
        try{
            System.out.println(future.get());
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            scEs.shutdown();
        }
    }

    private static void scheduleWithFixedDelay (){
        System.out.println("Start ----");

        final long INITIAL_DELAY = 2000, WAIT_PD_AFTER_PREVIOUS_TASK_FINISHED=300;

        scEs.scheduleWithFixedDelay(() -> System.out.println("Thread is :- " +
                        Thread.currentThread().getId()),
                INITIAL_DELAY,WAIT_PD_AFTER_PREVIOUS_TASK_FINISHED, TimeUnit.MILLISECONDS);

    }

    private static void scheduleAtFixedRate (){
        System.out.println("Start ----");

        final long INITIAL_DELAY = 2000, WAIT_PD_BEFORE_STARTING_NEXT_TASK=300;

        scEs.scheduleAtFixedRate(() -> System.out.println("Thread is :- " +
                        Thread.currentThread().getId()),
                INITIAL_DELAY,WAIT_PD_BEFORE_STARTING_NEXT_TASK, TimeUnit.MILLISECONDS);

    }
}

