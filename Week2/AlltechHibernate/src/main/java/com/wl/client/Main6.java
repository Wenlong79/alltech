package com.wl.client;

import java.util.List;

import com.wl.entity.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main6 {
    public static void main(String[] args) {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {

            txn.begin();
            List<Book> booksList = session.createQuery("from Book").list();
            //System.out.println(booksList.size());
            for (Book book : booksList){
                System.out.println(book);
            }
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
