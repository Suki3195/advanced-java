package advancedJavaConcepts.inputOutputInJava;

import java.io.*;

public class ByteStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try(
             FileInputStream fileIn = new FileInputStream("E:\\coding\\demo.txt");
             FileOutputStream fileOut = new FileOutputStream("E:\\coding\\outputFile.txt");
        ){
            int content;
            while ((content =fileIn.read()) != -1){
                fileOut.write((byte)content);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
