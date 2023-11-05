package com.wl.client;

import com.wl.entity.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main3 {

    //find object in class!!
    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Book book = (Book) session.get(Book.class, 2);
            System.out.println(book);
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
