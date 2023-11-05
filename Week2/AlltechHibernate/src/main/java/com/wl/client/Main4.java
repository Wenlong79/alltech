package com.wl.client;

import com.wl.entity.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main4 {

    //update object in class!!
    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Book book = (Book) session.get(Book.class, 1);
            System.out.print("Before update: ");
            System.out.println(book);

            book.setBookTitle(book.getBookTitle() + " Updated!");
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
}
