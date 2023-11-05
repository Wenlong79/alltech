package com.wl.client;

import com.wl.entity.Address;
import com.wl.entity.Department;
import com.wl.entity.Employee;
import com.wl.entity.Person;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main9 {
    // About Component Mapping!!!
    public static void main(String[] args) {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Department department = new Department("dept111", "Marketing");
            Employee employee = new Employee("Tom", department);
            session.persist(employee);
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
