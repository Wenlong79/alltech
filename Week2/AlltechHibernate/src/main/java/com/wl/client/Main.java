package com.wl.client;

import com.wl.domain.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;


// Method 1!!!! Using XML File!
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        Book book = new Book("Harry Potter 4", 70.0f);
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }
}
