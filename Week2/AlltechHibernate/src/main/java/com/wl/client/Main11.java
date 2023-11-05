package com.wl.client;

import com.wl.entity.Friend;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main11 {
    // one to one mapping
    public static void main(String[] args) {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();

            Friend friend = new Friend("Real Name2");
            friend.getNicknames().add("nickname11");
            friend.getNicknames().add("nickname22");
            friend.getNicknames().add("nickname33");
            friend.getNicknames().add("nickname44");
            session.persist(friend);

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
