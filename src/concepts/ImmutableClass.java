package concepts;

public final class ImmutableClass {

    private final String name;
    private final int salary;
    private final int age;
    private final Department dept;

    public ImmutableClass(String name, int salary, int age, Department dept) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.dept=dept;
    }

    public static class Department {
        private final String deptName;
        private final int deptId;

        public Department(String deptName, int deptId) {
            this.deptName = deptName;
            this.deptId = deptId;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "deptName='" + deptName + '\'' +
                    ", deptId=" + deptId +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }
}
