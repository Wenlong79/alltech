package com.student;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Student implements StudentInt {
    private int rollNo;
    private String name;
    private int subject1;
    private int subject2;
    private int subject3;
    private int totalMarks;

    public Student() {

    }

    /**
     *
     * @param rollNo
     * @param name
     * @param subject1
     * @param subject2
     * @param subject3
     */
    public Student(int rollNo, String name, int subject1, int subject2, int subject3) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1(int subject1) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2(int subject2) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3(int subject3) {
        this.subject3 = subject3;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public void calcTotal() {
        totalMarks = this.getSubject1() + this.getSubject2() + this.getSubject3();
    }

    /**
     * read input Student Info from user
     */
    @Override
    public void readStudInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter student rollNo: ");
        int rollNo = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter student name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter subject1 score: ");
        int subject1Score = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter subject2 score: ");
        int subject2Score = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter subject3 score: ");
        int subject3Score = Integer.parseInt(keyboard.nextLine());

        this.setRollNo(rollNo);
        this.setName(name);
        this.setSubject1(subject1Score);
        this.setSubject2(subject2Score);
        this.setSubject3(subject3Score);
        this.calcTotal();
    }

    /**
     * print the info of current Student object
     */
    @Override
    public void printStudInfo() {
        System.out.println(this);
    }

    /**
     *
     * @return student formatted info
     */
    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", subject1=" + subject1 +
                ", subject2=" + subject2 +
                ", subject3=" + subject3 +
                ", totalMarks=" + totalMarks +
                '}';
    }
}
