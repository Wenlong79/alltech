package com.wl.pgm2;

import com.wl.dao.Dao;
import com.wl.entity.Product;

import java.sql.*;
import java.util.Scanner;

public class Pgm2Dao implements Dao {

    static Scanner keyboard = new Scanner(System.in);

    String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
//    String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=UTF-8";

    @Override
    public void addProduct(Product product) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = JDBCUtils.getConnection(jdbcUrl);
            connection.setAutoCommit(false);
            StringBuffer query = new StringBuffer("INSERT into Product values(default,?,?)");
            pstmt = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, product.getProductName());
            pstmt.setFloat(2, product.getProductPrice());
            pstmt.executeUpdate();
            connection.commit(); // submit data
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                if (connection != null && connection.isClosed() == false) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void searchProduct(Long id) {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = JDBCUtils.getConnection(jdbcUrl);
            stmt = connection.createStatement();
            StringBuffer query = new StringBuffer("select * from Product where product_id = ");
            query.append("'" + id + "';");
            ResultSet rs = stmt.executeQuery(query.toString());
            String result = "";
            while (rs.next()) {
                Long productId = rs.getLong(1); //product_id
                String productName = rs.getString("product_name");
                Float productPrice = rs.getFloat("product_price");
                result = new Product(productId, productName, productPrice).toString();
            }
            if (result.length() == 0) {
                System.out.println("ACTOR NOT FOUND IN DATABASE");
            } else {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                if (connection != null && connection.isClosed() == false) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void browseAllProducts() {
        String query = "select * from Product";
        Statement stmt = null;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection(jdbcUrl);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Long productId = rs.getLong(1); //product_id
                String productName = rs.getString("product_name");
                Float productPrice = rs.getFloat("product_price");
                System.out.println(new Product(productId, productName, productPrice));
                //System.out.println(productId + "---" + productName + "---" + productPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                if (connection != null && connection.isClosed() == false) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateProduct(Long id) {
        Connection connection = null;
        StringBuffer query = new StringBuffer("select * from Product where product_id = ");
        Statement stmt = null;
        try {
            connection = JDBCUtils.getConnection(jdbcUrl);
            stmt = connection.createStatement();
            query.append("'" + id + "';");

            ResultSet rs = stmt.executeQuery(query.toString());
            Product product = null;
            while (rs.next()) {
                Long productId = rs.getLong(1); //product_id
                String productName = rs.getString("product_name");
                Float productPrice = rs.getFloat("product_price");
                product = new Product(productId, productName, productPrice);
            }

            if (product == null) {
                System.out.println("NOT FOUND");
            } else {
                System.out.print("Before Update: ");
                System.out.println(product);
                System.out.print("Update " + product.getProductName() + " price from " + product.getProductPrice() + " to: ");
                Float newPrice = Float.parseFloat(keyboard.nextLine());
                String updateQuery = "update Product set product_price = '" + newPrice + "' where product_id = '" + id + "';";
                stmt.executeUpdate(updateQuery);

                ResultSet updatedResult = stmt.executeQuery(query.toString());
                System.out.print("After update: ");
                while (updatedResult.next()) {
                    Long productId = updatedResult.getLong(1); //product_id
                    String productName = updatedResult.getString("product_name");
                    Float productPrice = updatedResult.getFloat("product_price");
                    product = new Product(productId, productName, productPrice);
                }
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                if (connection != null && connection.isClosed() == false) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = JDBCUtils.getConnection(jdbcUrl);
            stmt = connection.createStatement();
            StringBuffer query = new StringBuffer("DELETE FROM Product WHERE product_id = '" + id + "';");
            int result = stmt.executeUpdate(query.toString());
            //System.out.println(result);
            if (result == 1) {
                System.out.println("Product Deleted!");
            } else {
                System.out.println("No such product ID...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                if (connection != null && connection.isClosed() == false) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
