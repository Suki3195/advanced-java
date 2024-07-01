package optionalDemo;

import java.util.Optional;

record Customer (int id,String name) {

}
public class OptionalDemo {

    public static void main(String[] args) {
        Customer cust = new Customer(101,"Suki");
        Customer cust1 = new Customer(105,null);


        // Return Optional of Customer
        Optional<Customer> empty = Optional.empty();
        System.out.println(empty);

        // Optional.of  -> use it when u r sure that u dont have null as its value
//        Optional<String> custOptional = Optional.of(cust1.name());
//        System.out.println(custOptional);


        // If u get null value in Optional , then u r
        // mentioning some optional value to be set
        String custName = Optional.ofNullable(cust1.name()).orElse("Ashu");
        System.out.println(custName);

        // orElse -> to throw an exception
        String s = Optional.of(cust1.name()).orElseThrow(
                    () -> new RuntimeException("Error Occurred"));
    }

}
