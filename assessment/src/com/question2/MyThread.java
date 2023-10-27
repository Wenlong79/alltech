package com.question2;

import java.util.ArrayList;

public class MyThread extends Thread {

    String action;
    ArrayList<Item> list;

    /**
     * @param action : add or diaplay?
     * @param list
     */
    public MyThread(String action, ArrayList<Item> list) {
        this.action = action;
        this.list = list;
    }

    /**
     * call the act() action in Action class
     */
    @Override
    public void run() {
        Action.act(action, list);
    }

}
