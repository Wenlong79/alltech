package com.wl.client;

import com.wl.entity.Actor;
import com.wl.entity.Friend;
import com.wl.entity.Movie;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main12 {
    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Movie movie1 = new Movie("Titanic");
            Movie movie2 = new Movie("2012");

            Actor actor1 = new Actor("Tom");
            Actor actor2 = new Actor("Jerry");

            movie1.getActors().add(actor1);
            movie2.getActors().add(actor2);

            session.persist(movie1);
            session.persist(movie2);

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
