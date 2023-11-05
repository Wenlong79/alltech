package com.wl.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            //create SessionFactory from hibernate.cfg.xml
            //src/main/resources/hibernate.cfg.xml
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            //System.out.println("serviceRegistry created!");
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            //System.out.println("Metadata created!");
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("[[[SessionFactory Not Created]]]");
            throw new ExceptionInInitializerError(ex);
        }
    }
}

