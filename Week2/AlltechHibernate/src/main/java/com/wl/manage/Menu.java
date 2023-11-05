package com.wl.manage;

import com.wl.entity.Book;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BookDao bookDao = new BookDao();
        while (true) {
            System.out.println("\n*****************************MENU*****************************");
            System.out.println("1 -> Browse all books");
            System.out.println("2 -> Look Up a Book");
            System.out.println("3 -> Add a Book");
            System.out.println("4 -> Update a Book");
            System.out.println("5 -> Delete a Book");
            System.out.println("6 -> Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(keyboard.nextLine());

            switch (choice) {
                case 1:
                    List<Book> bookList = bookDao.browseAll();
                    if (bookList == null){
                        System.out.println("No Table found!");
                    } else {
                        for (Book book :bookList){
                            System.out.println(book);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the book ID: ");
                    int bookId = Integer.parseInt(keyboard.nextLine());
                    Book result = bookDao.lookUp(bookId);
                    if (result == null) {
                        System.out.println("NOT FOUND");
                    } else {
                        System.out.println(result);
                    }
                    break;
                case 3:
                    System.out.print("Enter the Book Title: ");
                    String title = keyboard.nextLine();

                    System.out.print("Enter the Book Price: ");
                    Float price = Float.parseFloat(keyboard.nextLine());
                    bookDao.add(title, price);

                    break;
                case 4:
                    System.out.print("Enter the book ID: ");
                    int updateId = Integer.parseInt(keyboard.nextLine());
                    bookDao.update(updateId);
                    break;
                case 5:
                    System.out.print("Enter the book ID: ");
                    int deleteId = Integer.parseInt(keyboard.nextLine());
                    bookDao.delete(deleteId);

                    break;
                case 6:
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
