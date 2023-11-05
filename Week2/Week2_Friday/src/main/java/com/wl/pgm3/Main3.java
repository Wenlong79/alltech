package com.wl.pgm3;

import com.wl.entity.Product;
import com.wl.pgm2.Pgm2Dao;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Pgm3Dao dao = new Pgm3Dao();

        //dao.browseAllProducts(); //ok
        //dao.searchProduct(2l);  //ok
        //dao.updateProduct(2l); //ok
        //dao.addProduct(new Product("iPhone 12 Pro", 800f)); // ok
        //dao.deleteProduct(7l); //ok

        while (true) {
            System.out.println("\n----------Book Management MENU---------");
            System.out.println("1 -> Add Product");
            System.out.println("2 -> Search a Product");
            System.out.println("3 -> Browse All Products");
            System.out.println("4 -> Update a Product");
            System.out.println("5 -> Delete a Product");
            System.out.println("6 -> EXIT");
            System.out.print("Enter your choice: ");
            String choice = keyboard.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Product name: ");
                    String productName = keyboard.nextLine();
                    System.out.print("Product price: ");
                    Float productPrice = Float.parseFloat(keyboard.nextLine());

                    Product product = new Product(productName, productPrice);
                    dao.addProduct(product);
                    break;
                case "2":
                    System.out.print("Product ID: ");
                    Long searchId = Long.parseLong(keyboard.nextLine());
                    dao.searchProduct(searchId);
                    break;
                case "3":
                    dao.browseAllProducts();
                    break;
                case "4":
                    System.out.print("Product ID: ");
                    Long updateId = Long.parseLong(keyboard.nextLine());
                    dao.updateProduct(updateId);
                    break;
                case "5":
                    System.out.print("Product ID: ");
                    Long deleteId = Long.parseLong(keyboard.nextLine());
                    dao.deleteProduct(deleteId);
                    break;
                case "6":
                    System.out.println("bye bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
