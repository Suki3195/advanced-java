package advancedJavaConcepts.comparator;

import java.util.*;

public class ComparatorDemo {

    public static void main(String[] args) {

        List<Cat> cats = Arrays.asList(new Cat("Greyi",2),new Cat("Greyi",5),new Cat("Daisy",3));
        // Comparing on Multiple Fields
        Comparator<Cat> compCat = Comparator.comparing(Cat::getName).thenComparing(Cat::getAge);
        Collections.sort(cats,compCat);
        System.out.println(cats);

        // For TreeSet to work properly, the natural order of the class should be defined
        // As is done in Boss class by implementing Comparable
        // Comparator will give CLassCasteException, if the natural order is not defined , as in case of Worker Class
        // which can be corrected by passing the Comparator in the argument of TreeList

        List<Boss> bossList = Arrays.asList(new Boss(2), new Boss(7), new Boss(3));
        List<Worker> workerList = Arrays.asList(new Worker(5),new Worker(2),new Worker(3));

//        Set<Worker> workerSet = new TreeSet<>(workerList); // will give error
        Set<Worker> workersSorted = new TreeSet<>((w1,w2) -> w1.getId() - w2.getId());
        workersSorted.add(new Worker(5));
        workersSorted.add(new Worker(1));
        workersSorted.add(new Worker(7));
        System.out.println(workersSorted);


    }
}

class Cat{

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}


class Boss implements Comparable<Boss>{
    public Boss(int id) {
        this.id = id;
    }

    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Boss o) {
        return this.id - o.getId();
    }
}

class Worker {
    private Integer id;

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                '}';
    }

    public Worker(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}