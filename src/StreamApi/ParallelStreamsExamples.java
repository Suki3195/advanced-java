package StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStreamsExamples {

    public static void main(String[] args) {

        /* advantages of parallel streams :-
        *   * utilization of multiple cores
        *   * single stream is converted into chunks of streams and
        *      processed parallely
        *   * sequence of processing of chunked streams is not in our control */

        long start =0;
        long end =0;
        /*-------------  TIME VARIATION OF PLAIN AND PARALLEL STREAMS ---------*/
        /*------  PLAIN STREAM EXAMPLE ------- */
        start = System.currentTimeMillis();
//        IntStream.range(1,100000).forEach(s -> System.out.print(" " + s));
        end = System.currentTimeMillis();
//        System.out.println("Time of execution for PLAIN stream :-  " + (end-start));

//        System.out.println("------------------");

        start = System.currentTimeMillis();
//        IntStream.range(1,100000).parallel().forEach(s -> System.out.print(" " + s));
        end = System.currentTimeMillis();
//        System.out.println("Time of execution for PARALLEL stream :-  " + (end-start));


    /*-----------------  THREAD FOR EXECUTION OF PLAIN AND PARALLEL STREAMS -----------*/
//        IntStream.range(1,10).forEach(x ->
//                System.out.println("Thread  : " + Thread.currentThread().getName() +  " :  " +x));
//
//        IntStream.range(1,10).parallel().forEach(x ->
//                System.out.println("Thread  : " + Thread.currentThread().getName() +  " :  " +x));


        /*-------------  code base test of performance  -----------*/
        List<EmployeeStream> employeeStreamList = EmployeeDatabase.getEmployees();
        long plainStart = System.currentTimeMillis();
        Double plainAverage = employeeStreamList.stream().map(emp -> emp.salary()).mapToDouble(i->i).average().getAsDouble();
        System.out.println("Average of Employees using plain stream   :  " + plainAverage);
        long plainEnd= System.currentTimeMillis();
        System.out.println("Time taken for plain stream to process list of Employees :-  " + (plainEnd-plainStart));

        System.out.println(" ------------------------------- ");
        long startTime = System.currentTimeMillis();
        Double parallelAverage = employeeStreamList.parallelStream().map(emp -> emp.salary()).mapToDouble(i->i).average().getAsDouble();
        System.out.println("Average of Employees using parallel stream   :  " + parallelAverage);
        long endTime= System.currentTimeMillis();
        System.out.println("Time taken for parallel stream to process list of Employees :-  " + (endTime-startTime));



    }


}

class EmployeeDatabase {

    public static List<EmployeeStream> getEmployees() {
        List<EmployeeStream> employeeStreamList = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            employeeStreamList.add(new EmployeeStream(
                    i,"emp"+i,Double.valueOf(new Random().nextInt(100 *1000))));

        }
        return employeeStreamList;
    }
}

record EmployeeStream (int id ,String name , double salary){

}