package advancedJavaConcepts.serialization;

import StreamApi.Employee;

import java.io.*;

public class DemoSerializable {
    public static void main(String[] args) throws IOException {

        Employee newEmp = new Employee("Sukirti Singh" , 27,90000,"erih&*65326bj","A");

        // serializing object into a file and saving it there
        String fileName="E:\\coding\\SerializableDemoFil";

        // serialization
        try(FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut= new ObjectOutputStream(fileOut)){
            objOut.writeObject(newEmp);
            System.out.println("Employee is serialized -------" + newEmp.toString());

        }
        catch (IOException ex){
            System.out.println("IO Exception occurred ------");
        }


        // Deserialization
        try(FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(fileIn)){
            Employee emp = (Employee) objIn.readObject();
            System.out.println(" Employee deserialize ---" + emp.toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
