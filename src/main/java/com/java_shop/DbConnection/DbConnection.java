package com.java_shop.DbConnection;

import java.sql.*;
import java.util.Map;

public class DbConnection {
    static public final String DB_URL = "jdbc:postgresql://localhost/java_shop";
    static public final String USER = "postgres";
    static public final String PASS = "admin";


    public static DbConnectionResult executeQuery(String query, DBConnectionInput input) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
        ) {
            Map<String, String> map = input.getInputMap();
            ResultSet resultSet = stmt.executeQuery(query);
            DbConnectionResult dbConnectionResult = new DbConnectionResult();

            if (resultSet.next()) {
                for (Map.Entry<String, String> item : map.entrySet()) {
                    String field = item.getKey();
                    String type = item.getValue();

                    if (type.equals("int")) {
                        int result = resultSet.getInt(field);

                        dbConnectionResult.setFieldInt(field, result);
                    }

                    if (type.equals("string")) {
                        String result = resultSet.getString(field);

                        dbConnectionResult.setFieldString(field, result);
                    }
                }
            } else {
                for (Map.Entry<String, String> item : map.entrySet()) {
                    String field = item.getKey();
                    String type = item.getValue();

                    if (type.equals("int")) {
                        dbConnectionResult.setFieldInt(field, 0);
                    }

                    if (type.equals("string")) {
                        dbConnectionResult.setFieldString(field, "");
                    }
                }
            }

            return dbConnectionResult;
        }
    }

    public static DbConnectionResultList executeQueryList(String query, DBConnectionInput input) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
        ) {
            ResultSet resultSet = stmt.executeQuery(query);
            DbConnectionResultList resultList = new DbConnectionResultList();
            Map<String, String> map = input.getInputMap();

            while (resultSet.next()) {
                DbConnectionResult dbConnectionResult = new DbConnectionResult();

                for (Map.Entry<String, String> item : map.entrySet()) {
                    String field = item.getKey();
                    String type = item.getValue();

                    if (type.equals("int")) {
                        int result = resultSet.getInt(field);

                        dbConnectionResult.setFieldInt(field, result);
                    }

                    if (type.equals("string")) {
                        String result = resultSet.getString(field);

                        dbConnectionResult.setFieldString(field, result);
                    }
                }

                resultList.add(dbConnectionResult);
            }
            return resultList;
        }
    }

//    public static void executeQueryObject(String query) throws SQLException {
//        try (Connection conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);
//             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
//        ) {
//            ResultSet resultSet = stmt.executeQuery(query);
//        }
//    }

    /**
     * Возвращает index созданной сущности
     */
    public static int executeUpdate(String query) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 0;
        }
    }
}
