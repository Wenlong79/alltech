package com.wl.pgm1;

import com.wl.dao.Dao;
import com.wl.entity.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Pgm1Dao implements Dao {

    static ArrayList<Product> products = new ArrayList<>(); // to store product objects
    static HashSet<Long> productIdSet = new HashSet<>(); // to check duplicates
    static Scanner keyboard = new Scanner(System.in);

    @Override
    public void addProduct(Product product) {
        if (idIsUnique(product.getProductId())) {
            products.add(product);
            productIdSet.add(product.getProductId());
            System.out.println("Product Added!");
        } else {
            System.out.println("Failed! This ID exists already!");
        }

    }

    @Override
    public void searchProduct(Long productId) {
        if (validId(productId)) {
            for (Product product : products) {
                if (product.getProductId() == productId) {
                    System.out.println(product);
                    break;
                }
            }
        } else {
            System.out.println("No such ID exists...");
        }
    }

    @Override
    public void browseAllProducts() {
        if (products.size() == 0) {
            System.out.println("No products in the database...");
        } else {
            System.out.println("***************************");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("***************************");
        }
    }

    @Override
    public void updateProduct(Long productId) {
        if (validId(productId)) {
            Product targetProduct = null;
            for (Product product : products) {
                if (product.getProductId().equals(productId)) {
                    targetProduct = product;
                }
            }
            System.out.print("Update the price from [" + targetProduct.getProductPrice() + "] to: ");
            Float newPrice = Float.parseFloat(keyboard.nextLine());
            targetProduct.setProductPrice(newPrice);
            System.out.println("Price Updated!");
        } else {
            System.out.println("No such ID exists...");
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        if (validId(productId)) {
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getProductId().equals(productId)) {
                    iterator.remove();
                }
                break;
            }
            productIdSet.remove(productId);
            System.out.println("Product Deleted!");
        } else {
            System.out.println("No such ID exists...");
        }
    }

    public boolean idIsUnique(Long productId) {
        return !productIdSet.contains(productId);
    }

    public boolean validId(Long productId) {
        return productIdSet.contains(productId);
    }
}
