package lambdaExpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaMainClass {

    interface  SampleInterface {

        int calculate(int a,int b);
    }

    record Book (String name, String writer,int pages){};

    public static void main(String[] args) {

        // Below is the implementation of an abstract method in interface.
        // which is being called without creating an object of a class that
        // implements the interface
        FunctionalInterfaceExample func = () -> {
            System.out.println("I am implementation for SAM ");
        };
        func.methodForLambda();

        // Implementation for Runnable Interface and its call
        // without a thread being created
        Runnable run = () -> System.out.println("Thread Running ----");
        run.run();


        SampleInterface sampInt = (a,b) ->  a+b;
        System.out.println("sum is  " +sampInt.calculate(4,5));;


        // Sorting List of Books according to their names
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Amazon" , "Sukirti Singh" , 1052 ));
        booksList.add(new Book("Ganga" , "Sukirti Singh" , 102 ));
        booksList.add(new Book("Tapi" , "Sukirti Singh" , 152 ));
        booksList.add(new Book("Godavari" , "Sukirti Singh" , 112 ));
        booksList.add(new Book("Jhelum" , "Sukirti Singh" , 1012 ));

        // COMPARING TWO STRING using comapreTo() of String
        Comparator<Book> nameComp = (o1, o2) -> o1.name.compareTo(o2.name);
        booksList.sort(nameComp);
        System.out.println(" Sorted List of Books   "  + booksList.toString());

        // reverse order using Stream API
        booksList.stream().sorted(nameComp.reversed()).forEach(System.out::println);
        // inbuild stream method for field based comparison
        booksList.stream().sorted(Comparator.comparing(book -> book.name())).forEach(System.out::println );

    }





}
