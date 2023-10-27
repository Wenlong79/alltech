package com.test;

import com.student.Student;

import java.io.*;
import java.util.Scanner;

public class StudentImp {
    public static void main(String[] args) {

        Student student = new Student();
        student.readStudInfo();
        student.printStudInfo();

        //file path will be different if this program is run on another platform
        File file = new File("/Users/wenlongy/Desktop/StudentInfo.txt"); //file path
        FileWriter fw = null;
        FileReader fr = null;

        try {
            fw = new FileWriter(file);
            fw.write(student.toString());  //write to file
            fw.close();
            System.out.println("*******************");
            System.out.println("Now we read from file");
            fr = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fr); //read from file
            String line = bufferReader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = bufferReader.readLine(); // read line by line if there are multiple lines
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
