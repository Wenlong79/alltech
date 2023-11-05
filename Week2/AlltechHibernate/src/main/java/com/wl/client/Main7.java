package com.wl.client;

import com.wl.entity.Book;
import com.wl.entity.Guide;
import com.wl.entity.Student;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main7 {
    public static void main(String[] args) {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Guide guide = new Guide("GUI333", "Guider3", 3000);
            Student student = new Student("STU333", "Tom3", guide);

            //session.save(guide);
            //session.save(student);


            /**
             * with @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}),
             * we can just add a student and guide will be automatically added
             */
            session.persist(student);

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
