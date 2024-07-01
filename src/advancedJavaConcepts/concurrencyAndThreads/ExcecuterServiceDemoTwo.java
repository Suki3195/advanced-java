package advancedJavaConcepts.concurrencyAndThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcecuterServiceDemoTwo {


    // ExcecuterService allows submit tasks in Collections (as List)
    // SingleThreadExecutor will accept task sequentially in the order they are submitted.
//    private static ExecutorService es = Executors.newSingleThreadExecutor();
    private static List<Callable<String>> callables = new ArrayList<>();

    // no guarantee which letter will appear first.
    private static ExecutorService es = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {

        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");

        invokeAll();
//        invokeAny();



    }
    // submitting a collections of tasks executes synchronously and return when one of the task has completed,
    // all other tasks will be cancelled.
    public static void invokeAny(){

        try{

            // NOTE :- Single Thread Executor always execute the first task submitted.
            // Here in this case it will always be "A".

            // FixedThreadPool will give Random letter from the List
            System.out.println("Callable is : " + es.invokeAny(callables));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
        System.out.println("Always at the end  !!!");
    }


// executes synchronously and returns when all of the tasks are completed.
    // Order is maintained.
    public static void invokeAll(){

        try{
            List<Future<String>> responseList = es.invokeAll(callables);

            for(Future<String> future : responseList){
                System.out.println("Callable is : " + future.get());
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
    }

}
