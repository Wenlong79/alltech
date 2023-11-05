package com.wl.entity2;

import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    // one to one mapping
    public static void main(String[] args) {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            //department from entity2!
            Department department = new Department("Marketing");
            Worker worker = new Worker("Jerry", 2000F, department);
            session.persist(worker);
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
