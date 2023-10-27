package com.question4;

public class JavaThread extends Thread{

    private JavaLang javaLang;

    public JavaThread(JavaLang javaLang){
        this.javaLang = javaLang;
    }

    public JavaThread(){
        javaLang = new JavaLang();
    }

    @Override
    public synchronized void run() {
        try {
            javaLang.showMessage();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
