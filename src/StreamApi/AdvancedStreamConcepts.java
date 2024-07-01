package StreamApi;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AdvancedStreamConcepts {

    public static void main(String[] args) {

        // First non-Duplicate char in a String
        String str = "teeth";
        Set<String> setOfChar = new LinkedHashSet<>();

        System.out.println(Arrays.stream(str.split("")).collect(Collectors.groupingBy(
                s->s, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue()==1)
                .findFirst().get().getKey());

        Arrays.stream(str.split("")).filter(s -> !setOfChar.add(s)).forEach(System.out::println);


        // Longest String from a list  REDUCE() OF stream api
        List<String> sampleList = Arrays.asList("Sukirti","Bitto", "Ashu","Rohan");
        System.out.println("The Longest String in the given list is --- "
                +sampleList.stream().reduce((s1,s2) -> s1.length()>s2.length() ? s1:s2).get());
//        sampleList.stream().map(s -> length.put(s,s.length())).forEach(s -> System.out.println(s));

//        System.out.println("The map is  :- " + length.toString());
//        System.out.println("LONGEST STRING IN THE LIST IS :- " + length.entrySet().stream().max((o1, o2) - > o1.getKey()-o2.getKey()).get().getValue());



        // Stream API on MAP
        Map<String,Integer> dummyMap = new HashMap<>();
        dummyMap.put("a",1);
        dummyMap.put("b",2);
        dummyMap.put("c",3);
        dummyMap.put("d",4);

        // directly using for each on map without converting into Stream
        dummyMap.forEach((k,v )-> System.out.println(k + " : " + v) );

        // converting map into stream api
        dummyMap.entrySet().stream().forEach((k)-> System.out.println(k + " : " + dummyMap.get(k)));



        // Sorting by key using inbuilt stream method
        dummyMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        // MAP AND FLAT MAP Intermediate methods of stream api
        // Map  -> One-To-One
        // Flat Map -> One-To-Many  -> List<List<String>> -> flatMap -> List<String> [NESTED LIST]

        List <List<String>> mobString = new ArrayList<>();
        mobString.add(Arrays.asList("123123","963963"));
        mobString.add(Arrays.asList("789789","963963"));
        mobString.add(Arrays.asList("852852","963963"));

        System.out.println(mobString.stream().map(s-> s).collect(Collectors.toList()));
        // FLAT MAP TAKE INPUT AS STREAM
        System.out.println(mobString.stream().flatMap(strings -> strings.stream()).collect(Collectors.toList()));
        // COLLECTING UNIQUE VALUES OF LIST
        System.out.println(mobString.stream().flatMap(strings -> strings.stream()).collect(Collectors.toSet()));


        // REDUCE METHOD OF STREAMS
        List<Integer> intList = Arrays.asList(1,6,9,4,5,8,7);
        /******** Using reduce() to find sum    first param is value initialized and
         *  second param is  function to process **********/
       Integer reduceSum =  intList.stream().reduce(0, (a,b)->(a+b));
       System.out.println("********r reduce sum is " + reduceSum);

       /********    OR          *********/
        Integer reduceSum1 =  intList.stream().reduce(Integer::sum).get();
        System.out.println("********" + reduceSum1);

        Integer reducedMultiple = intList.stream().reduce(1,(a,b)-> (a*b));
        System.out.println("reducedMultiple -------" + reducedMultiple);

        // Max Int value from a list
        System.out.println(intList.stream().reduce(0, Integer::max));


        // u have 2 maps -->  1. channels to noOfSubscribers   AND 2. channels to NameOfPublisher
        // Map NameOfPublisher to their subscribers.

        Map<String,Integer> channelsToSubscriber = new HashMap<>();
        channelsToSubscriber.put("Zee",40000);
        channelsToSubscriber.put("Star",8000);
        channelsToSubscriber.put("Sony",45000);

        Map<String,String> channelsToPublisher = new HashMap<>();
        channelsToPublisher.put("Zee","Rajat");
        channelsToPublisher.put("Star","Sardar g");
        channelsToPublisher.put("Sony","Chadda g");
// Ek naya map banaya hai.. use sort krna hai..wo nahi ho raha hais
        Map<String,Integer> publisherToSubscriber = channelsToPublisher.keySet().
                stream().collect(Collectors.toMap(k -> channelsToPublisher.get(k), k-> channelsToSubscriber.get(k)))
                .entrySet().stream().sorted(
                        Map.Entry.comparingByValue()
                ).collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry :: getValue));
        System.out.println("publisherToSubscriber --> "  + publisherToSubscriber.toString());

    }

    
}
