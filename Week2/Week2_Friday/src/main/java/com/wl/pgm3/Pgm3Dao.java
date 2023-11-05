package com.wl.pgm3;

import com.wl.dao.Dao;
import com.wl.entity.Product;
import com.wl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Pgm3Dao implements Dao {

    static Scanner keyboard = new Scanner(System.in);
    Connection connection = null;

    String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=UTF-8";

    @Override
    public void addProduct(Product product) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            session.persist(product);
            txn.commit();
            //System.out.println(product);
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void searchProduct(Long id) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Product product = (Product) session.get(Product.class, id);
            System.out.println(product);
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void browseAllProducts() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            List<Product> productList = session.createQuery("from Product").list();
            //System.out.println(booksList.size());
            for (Product product : productList){
                System.out.println(product);
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

    @Override
    public void updateProduct(Long id) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Product product = (Product) session.get(Product.class, id);

            System.out.print("Before update: ");
            System.out.println(product);

            System.out.print("Update the price of " + product.getProductName() + " from " + product.getProductPrice() +" to: " );
            Float newPrice = Float.parseFloat(keyboard.nextLine());

            product.setProductPrice(newPrice);
            txn.commit();
            System.out.print("After update:");
            System.out.println(product);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Product product = (Product) session.get(Product.class, id);
            session.remove(product);
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
