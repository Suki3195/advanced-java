package advancedJavaConcepts.annotations;

import java.lang.reflect.Method;

public class DemoClass {
    @ValueAnnotationDemo("Sukirti Singh")
    public void myMethod(){
        System.out.println("Annotation Demo");
    }


    public static void main(String[] args) throws NoSuchMethodException {
        // Fetching value pf annotation using Reflection
        DemoClass demoClass = new DemoClass();
        Method method = demoClass.getClass().getMethod("myMethod");
        ValueAnnotationDemo demoAnnotation = method.getAnnotation(ValueAnnotationDemo.class);
        System.out.println("Value of my Annotation :- " + demoAnnotation.value());
    }
}
