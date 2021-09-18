package com.java_shop;

import java.sql.*;

public class DbConnection {
    static final String DB_URL = "jdbc:postgresql://localhost/java_shop";
    static final String USER = "postgres";
    static final String PASS = "admin";

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

    /**
     * Возвращает index созданной сущности
     */
    public static int executeUpdate(String query) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();

            return 0;
        }
    }
}
