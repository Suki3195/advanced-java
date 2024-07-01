package advancedJavaConcepts.concurrencyAndThreads;

import java.util.concurrent.*;

public class ExcecuterServiceDemo {

    public static void main(String[] args) throws Exception {
        // Creating Executor Service
        ExecutorService es = Executors.newSingleThreadExecutor();

        // Execute Runnable task Async
        es.execute(() -> System.out.println("Executor Service Example"));

        // Submit Callable Task
        Future<Integer> future = es.submit(() -> 3+5);
        try{
            // get() --> is blocked for 500 ms
            System.out.println(" he Answer is : - " + future.get(500, TimeUnit.MILLISECONDS));
        }
        catch (InterruptedException | ExecutionException | TimeoutException ex){
            ex.printStackTrace();
        }

        // shutdown Executor Service, otherwise application will bever terminate.
        // existing tasks will be allowed to xomplete, but no new tasks will be accepted.
        es.shutdown();
//        throw new Exception("Execution Error");
        // any line below throw is unreachable code.

    }
}
