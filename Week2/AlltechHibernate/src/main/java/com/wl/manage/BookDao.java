package com.wl.manage;

import com.wl.entity.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class BookDao {
    public Scanner keyboard = new Scanner(System.in);

    public List<Book> browseAll(){
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        List<Book> booksList = null;
        try {
            txn.begin();
            booksList = session.createQuery("from Book").list();
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return booksList;
    }
    public Book lookUp(int bookId) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        Book result = null;
        try {
            txn.begin();
            result = (Book) session.get(Book.class, bookId);
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public void add(String title, float price) {
        try {
            Session session = HibernateUtil.buildSessionFactory().openSession();
            session.beginTransaction();
            Book book = new Book(title, price);
            session.persist(book);
            session.getTransaction().commit();
            session.close();
            System.out.println("Book Added!");

        } catch (Exception e) {
            System.out.println("Adding Error");
            e.printStackTrace();
        }
    }

    public void update(int bookId) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Book book = (Book) session.get(Book.class, bookId);
            System.out.print("Before update: ");
            System.out.println(book);

            System.out.print("Update the price from " + book.getBookPrice() + " to: ");
            Float newPrice = Float.parseFloat(keyboard.nextLine());
            book.setBookPrice(newPrice);
            txn.commit();
            System.out.println("After update:");
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(int bookId) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Book book = (Book) session.get(Book.class, bookId);
            session.remove(book);
            txn.commit();
            System.out.println("Book Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
