package StreamApi;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long SerialVersionUID=2326l;
    private String name;
    private int age;
    private int salary;
    private String grade;

    // a null value is passed for this variable after serialization
    transient private String passCode;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passCode=" + passCode +
                ", salary=" + salary +
                ", grade=" + grade +
                '}';
    }

    public Employee(String name, int age, int salary, String passCode,
                    String grade) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.passCode=passCode;
        this.grade=grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }
}
