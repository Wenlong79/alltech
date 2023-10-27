package com.question2;

import java.util.ArrayList;

public class Action {
    /**
     * act on user's input
     *
     * @param action
     * @param list
     */
    public synchronized static void act(String action, ArrayList<Item> list) {
        if (action.equalsIgnoreCase("add")) {
            System.out.println("Adding items...");
            for (int i = 1; i <= 5; i++) {
                String id = "ID_" + i;
                String name = "Name_" + i;
                Item item = new Item(id, name);
                list.add(item);
                //System.out.println(item);
            }
            System.out.println("Adding complete!");
            System.out.println("List size: " + list.size() + "\n");
        } else if ((action.equalsIgnoreCase("display"))) {
            System.out.println("Reading from list:");
            for (Item item : list) {
                System.out.println(item);
            }
            //System.out.println("List size: " + list.size());
        }
    }
}
