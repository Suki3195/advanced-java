package StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewPracticeQuestion {
    public static void main(String[] args) {
        // count occurrence of each char in a string
        String str = "I am Sukirti Singh... The wonder girl !!!";

//       Arrays.stream(str.split("")).map(s -> s.toLowerCase())
//                .collect(Collectors.groupingBy(s->s, LinkedHashMap::new,Collectors.counting())).entrySet()
//                .stream().forEach(entry -> System.out.println("Char " + entry.getKey() + " occurred  : " +entry.getValue() + "  times"));


        // find duplicate elements in a string
       List<String> duplicateCharsInString = Arrays.stream(str.split("")).map(s-> s.toLowerCase())
                .collect(Collectors.groupingBy(s->s,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()>1)
               .map(entry -> entry.getKey())
               .collect(Collectors.toList());

//        System.out.println("duplicate characters in a String are  :- " + duplicateCharsInString);


        /*----------   FIND SECOND HIGHEST NUMBER FROM A GIVEN ARRAY  ---------- */

        int[] numbers = {2,7,88,99,43,21,7,80,76,73,74};
        int secondHighestNumber = Arrays.stream(numbers)
                .boxed()   // converting int to Integer
                .sorted(Comparator.reverseOrder())
                .skip(1)  //skipping element at index n=1 from the stream
                .findFirst().get();
//          System.out.println("SECOND ELEMENT FROM THE LIST   "  +secondHighestNumber);


        List<Integer> numStartWith7 =
                Arrays.stream(numbers).boxed().map(s->String.valueOf(s))
                .filter(s->s.startsWith("7"))
                .map(s-> Integer.valueOf(s))
                .collect(Collectors.toList());

        System.out.println("Integers starting from 7 in the given list  :-  " + numStartWith7);

        /*  longest string from a given List */
        List<String> strList = Arrays.asList("Rohan","Shikha","Sukirti","Ashu" , "Bitto");

        String longestString = strList.stream().reduce((a,b) -> a.length()>b.length()?a:b).get();
        System.out.println("Longest String from the list is  :- " + longestString);

        /* String join */
        List<String> numList = Arrays.asList("1","2","3","4","5");
        // Join all integers with - as delimeter
        String newStr = String.join("-",numList);
        System.out.println("JOINED STRING IS :- " + newStr);

        /* --------  LIMIT AND SKIP OF STREAM API  -----------*/
        IntStream.range(1,15).skip(10)  // skip first 5 elements of the stream
                .limit(11)  // limit the number of elements in the stream
                .forEach(System.out::println);




    }
}
