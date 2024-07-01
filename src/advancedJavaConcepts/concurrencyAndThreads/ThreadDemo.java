package advancedJavaConcepts.concurrencyAndThreads;

public class ThreadDemo {

    public static void main(String[] args) {
        try{
            ThreadExtendsThread t1 = new ThreadExtendsThread();
            ThreadExtendsThread th1 = new ThreadExtendsThread();
//            t1.start();
//            th1.start();

            // creating thread from a class that implements Runnable
            Thread t2 = new Thread(new ThreadImplementsRunnable());
            ThreadImplementsRunnable t3 = new ThreadImplementsRunnable();

            t2.start();
            // start() not available on class that implements Runnable
            t3.run();      // run() dont create new thread... the execution occurs on the main thread.
//            t2.run();  // thread created from Class Implementing Runnable --> will have start() as well

//    note :-

        }
        catch (Exception ex){
            System.out.println("Exception Occurred");
        }

    }
}
