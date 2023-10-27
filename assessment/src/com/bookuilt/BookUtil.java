package com.bookuilt;

import com.book.Book;
import com.book.BookStore;

import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Scanner keyboard = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter book " + i);
            System.out.print("Enter the bookID: ");
            String id = keyboard.nextLine();

            System.out.print("Enter the book title: ");
            String title = keyboard.nextLine();

            System.out.print("Enter the book author: ");
            String author = keyboard.nextLine();

            System.out.print("Enter the category: ");
            String category = keyboard.nextLine();

            System.out.print("Enter the price: ");
            Float price = Float.parseFloat(keyboard.nextLine());

            try {
                validateBookInput(id, price, category);
                Book book = new Book(id, title, author, category, price);
                bookStore.addBook(book);
            } catch (Exception e) {
                System.out.println("Failed to add book");
                e.printStackTrace();
            }
        }

        bookStore.searchByTitle("be happy");
        bookStore.searchByAuthor("jerry");
        bookStore.displayAll();

    }

    /**
     *  validate all the book input from user
     * @param id
     * @param price
     * @param category
     * @throws InvalidBookException
     */
    static void validateBookInput(String id, Float price, String category) throws InvalidBookException {
        if (checkBookId(id) && checkBookPrice(price) && checkCategory(category)) {
            System.out.println("Valid Book Input! Added!\n");
        } else {
            throw new InvalidBookException("Invalid Book ID/Price/Category");
        }
    }

    /**
     * validate bookId
     * @param bookId
     * @return true of false
     */
    static boolean checkBookId(String bookId) {
        return bookId.charAt(0) == 'B' && bookId.length() == 4;
    }

    /**
     * validate book price
     * @param bookPrice
     * @return true of false
     */
    static boolean checkBookPrice(Float bookPrice) {
        return bookPrice > 0.0f;
    }

    /**
     * validate book category
     * @param category
     * @return true of false
     */
    static boolean checkCategory(String category) {
        String lowercase = category.toLowerCase();
        return (lowercase.equals("science") || lowercase.equals("fiction") || lowercase.equals("technology") || lowercase.equals("others"));
    }
}
