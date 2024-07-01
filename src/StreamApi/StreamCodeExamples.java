package StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCodeExamples {
    public static void main(String[] args) {
        // fetching duplicates from an array
        String str = "adhdygykikl";
        Set<String> uniqueSet = new HashSet<>();
        Arrays.stream(str.split("")).filter(s-> !uniqueSet.add(s) ).forEach(System.out::println);


        // Sorting Employee Obj on salary

        List<Employee> empList = Arrays.asList(
                new Employee("Ramesh" , 27,90000 ,"as@ds","A"),
                new Employee("Suresh",20,70000,"gru&gd","B"),
                new Employee("Pankaj",25,150000, "few&*bdw","A"),
                new Employee("Krish" , 27,90000 ,"as@ds","A"),
                new Employee("Dheeraj",20,30000,"gru&gd","C"),
                new Employee("Kartik",25,20000, "few&*bdw","C"));

        List<String> empName = empList.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println("--------" + empName);
        Comparator<Employee> salaryComp= (o1, o2) -> o1.getSalary()-o2.getSalary();
       // get the filtered list of employees whose salary >50k and grade is "A"
        List<Employee> filteredEmpList = empList.stream().sorted(salaryComp)
                .filter(emp-> emp.getSalary()>50000 && emp.getGrade().equals("A")).collect(Collectors.toList());
        System.out.println("Filtered list of Employees is  :- " + filteredEmpList.toString());

        // find avg salary of employees whose grade is "A"

        Double avgSalary = empList.stream().filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
                .mapToDouble(emp -> emp.getSalary())
                .average().getAsDouble();
        System.out.println("THE AVG SALARY OF EMPLOYEES WHOSE GRADE IA A :- " + avgSalary);


        // diff of Map and MapToDouble  -> map will have the same datatype as of input stream
        // but mapToDouble will convert the input datatype to Double

        List<String> list = Arrays.asList("CSE", "JAVA", "gfg",
                "C++", "C");
        list.stream().map(s->s.length()*s.length()).forEach(s-> System.out.println("Map Value is -----"+s));

        list.stream().mapToDouble(s->s.length()*s.length()).forEach(s-> System.out.println("Map Double Value is -----"+s));





    }

}
