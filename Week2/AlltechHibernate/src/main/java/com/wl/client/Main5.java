package com.wl.client;

import com.wl.entity.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main5 {

    //delete object in class!!
    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Book book = (Book) session.get(Book.class, 1);
            session.remove(book);
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
