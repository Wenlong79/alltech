package com.wl.client;

import com.wl.entity.Address;
import com.wl.entity.Guide;
import com.wl.entity.Person;
import com.wl.entity.Student;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main8 {
    // About Component Mapping!!!
    public static void main(String[] args) {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Address address = new Address("Street 1", "City 1", "11111");
            Person person1 = new Person("Person1", address);
            session.persist(person1);

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
