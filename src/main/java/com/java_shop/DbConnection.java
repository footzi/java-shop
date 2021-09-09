package com.java_shop;

import java.sql.*;

public class DbConnection {
    static final String DB_URL = "jdbc:postgresql://localhost/java_shop";
    static final String USER = "postgres";
    static final String PASS = "admin";

//    private final Statement statement;
//    static final String QUERY = "SELECT * FROM test";

    //  ResultSet rs = stmt.executeQuery(QUERY);
//    public static Statement connect() {
//        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement stmt = conn.createStatement();
//        ) {
//            return stmt;
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return null;
//        }
//    }

    public static ResultSet executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(query);
        ) {
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static boolean executeUpdate(String query) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }
}
