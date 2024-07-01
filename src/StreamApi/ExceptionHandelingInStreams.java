package StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ExceptionHandelingInStreams {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("142","175","abc");

        stringList.stream().forEach(s -> handleException(s));

    }

    // static way of handling error in streams
    static void handleException (String s){

        try {
            System.out.println(Integer.parseInt(s));;
        }catch (Exception ex){
            System.out.println("ERROR :- " + s);
        }

    }


    // generic way of handling error in streams
//    static <Target,ExObj extends Exception>
//        Consumer<Target> handleExceptionGenerically (Consumer<Target> targetConsumer ,
//                                                     Class<ExObj> exObjClass) {
//
//    }

//    }
}
