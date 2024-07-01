import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InbuiltFunctionalInterfaces {

    public static void main(String[] args) {

        // CONSUMER FUNCTIONAL INTERFACE
        // Used in ForEach method of Stream Api
        Consumer<String> consumer = (String s)-> System.out.println("Input is  " + s);
        consumer.accept("Sukirti Singh");


        // PREDICATE FUNCTIONAL INTERFACE
        // used in filter of Stream API
        Predicate<Integer> predicate = (Integer a ) -> a%2==0;

        System.out.println("------" + predicate.test(5));


        // Supplier interface
        // return dummy data in Stream api
        Supplier<String> supplier = () -> "Supplier Interface";
//        System.out.println(supplier.get());
        List<String> dummyList = Arrays.asList();
        System.out.println(dummyList.stream().findAny().orElseGet(supplier));


    }
}
