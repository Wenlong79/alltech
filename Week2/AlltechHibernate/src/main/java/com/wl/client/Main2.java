package com.wl.client;

import com.wl.entity.Book;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;

public class Main2 {
    // unlike Main1, this one uses annotation
    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        Book book = new Book("Harry Potter Notation 5", 400f);
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }
}
