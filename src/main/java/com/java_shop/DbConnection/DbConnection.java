package com.java_shop.DbConnection;

import java.sql.*;
import java.util.Map;

public class DbConnection {
//    static public final String DB_URL = "jdbc:postgresql://database_container:5432/test";
    static public final String DB_URL = "jdbc:postgresql://localhost/test";
    static public final String USER = "admin";
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

                        if (result == 0) {
                            dbConnectionResult.setFieldInt(field, null);
                        } else {
                            dbConnectionResult.setFieldInt(field, result);
                        }
                    }

                    if (type.equals("string")) {
                        String result = resultSet.getString(field);

                        dbConnectionResult.setFieldString(field, result);
                    }

                    if (type.equals("array")) {
                        Array result = resultSet.getArray(field);
                        Integer[] resultInteger = (Integer[])result.getArray();

                        dbConnectionResult.setFieldArray(field, resultInteger);
                    }
                }
            } else {
                for (Map.Entry<String, String> item : map.entrySet()) {
                    String field = item.getKey();
                    String type = item.getValue();

                    if (type.equals("int")) {
                        dbConnectionResult.setFieldInt(field, null);
                    }

                    if (type.equals("string")) {
                        dbConnectionResult.setFieldString(field, "");
                    }

                    if (type.equals("array")) {
                        dbConnectionResult.setFieldArray(field, null);
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

                        if (result == 0) {
                            dbConnectionResult.setFieldInt(field, null);
                        } else {
                            dbConnectionResult.setFieldInt(field, result);
                        }
                    }

                    if (type.equals("string")) {
                        String result = resultSet.getString(field);

                        dbConnectionResult.setFieldString(field, result);
                    }

                    if (type.equals("array")) {
                        Array result = resultSet.getArray(field);

                        if (result != null) {
                            Integer[] resultInteger = (Integer[])result.getArray();
                            dbConnectionResult.setFieldArray(field, resultInteger);
                        } else {
                            dbConnectionResult.setFieldArray(field, null);
                        }
                    }
                }

                resultList.add(dbConnectionResult);
            }
            return resultList;
        }
    }

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
