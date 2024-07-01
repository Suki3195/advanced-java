package concepts.methodOverloading;

public class MethodDemo {

    public void getMethod(String name){
        System.out.println(" get Method 1 =--------" + name);
    }

    public void getMethod(Integer intvalue){
        System.out.println(" get Method 2 =--------" + intvalue);
    }
}
