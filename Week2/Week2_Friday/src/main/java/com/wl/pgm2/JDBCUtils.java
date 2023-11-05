package com.wl.pgm2;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
    private static String jdbcUserName = "root";
    private static String jdbcPassword = "YwlHigher01";

    public static Connection getConnection(String JDBCurl) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBCurl, jdbcUserName, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
