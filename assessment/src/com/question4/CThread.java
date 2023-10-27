package com.question4;

public class CThread extends Thread {
    Clang clang;

    public CThread(Clang clang) {
        this.clang = clang;
    }

    public CThread() {
        clang = new Clang();
    }

    @Override
    public synchronized void run() {
        try {
            clang.showMessage();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
