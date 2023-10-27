package com.book;

import java.util.ArrayList;

public class BookStore {
    ArrayList<Book> books;

    public BookStore(ArrayList<Book> books) {
        this.books = books;
    }

    public BookStore() {
        this.books = new ArrayList<>();
    }

    /**
     *
     * @param book
     * add book to book list
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     *
     * @param title
     * will be notified if not found
     */
    public void searchByTitle(String title) {
        Book target = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                target = book;
            }
        }
        if (target == null) {
            System.out.println("Not Found");
        } else {
            System.out.println(target);
        }

    }

    /**
     *
     * @param author
     * will be notified if not found
     */
    public void searchByAuthor(String author) {
        Book target = null;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                target = book;
            }
        }
        if (target == null) {
            System.out.println("Not Found");
        } else {
            System.out.println(target);
        }
    }

    /**
     * display all books in the bookstore
     */
    public void displayAll() {
        System.out.println("***************Book Store Inventory***************");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("***************Book Store Inventory***************");
    }
}
