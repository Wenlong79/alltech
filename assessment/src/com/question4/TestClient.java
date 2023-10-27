package com.question4;

import java.util.Scanner;

public class TestClient {


    public static void main(String[] args) throws InterruptedException {
        Clang clang = new Clang();
        JavaLang javaLang = new JavaLang();

        JavaThread javaThread = new JavaThread(javaLang);
        CThread cThread = new CThread(clang);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("C or Java: ");
        String choice = keyboard.nextLine().trim().toLowerCase();
        //String choice = "c";


        // it may execute the prioritized thread first. But it cannot guarantee without notify() or wait()
        synchronized (javaThread){
            switch (choice) {
                case "c":
                    cThread.setPriority(Thread.MAX_PRIORITY);
                    System.out.println("[C-Thread Priority: " + cThread.getPriority() + "]");
                    System.out.println("[Java-Thread Priority: " + javaThread.getPriority() + "]");
                    System.out.println("**********************************");
                    cThread.start();
                    //TEST
                    cThread.join();  // If this removed, cThread is much more likely to execute first! But not guaranteed
                    javaThread.start();
                    break;
                case "java":
                    javaThread.setPriority(Thread.MAX_PRIORITY);
                    System.out.println("[C-Thread Priority: " + cThread.getPriority() + "]");
                    System.out.println("[Java-Thread Priority: " + javaThread.getPriority() + "]");
                    System.out.println("**********************************");
                    javaThread.start();
                    //TEST
                    javaThread.join(); // If this removed, javaThread is much more likely to execute first! But not guaranteed
                    cThread.start();
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
