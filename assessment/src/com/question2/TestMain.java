package com.question2;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Item> list = new ArrayList<>();
        MyThread thread1 = new MyThread("add", list); //add items
        MyThread thread2 = new MyThread("display", list); //display items

        thread1.start(); //start adding 5 items
        thread1.join(); // thread1 must finish first!
        thread2.start(); //start reading items from list
    }
}
