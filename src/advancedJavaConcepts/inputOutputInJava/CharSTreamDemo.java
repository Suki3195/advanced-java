package advancedJavaConcepts.inputOutputInJava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharSTreamDemo {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("E:\\coding\\demo.txt");
             FileWriter fileWriter = new FileWriter("E:\\coding\\charOutDemo.txt")){
            int content;
            while ((content = fileReader.read()) != -1){
                fileWriter.write(content);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
